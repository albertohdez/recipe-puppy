package com.alberto.recipepuppy.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.alberto.recipepuppy.R;
import com.alberto.recipepuppy.common.model.SearchDTO;
import com.alberto.recipepuppy.common.model.response.SearchResponse;
import com.alberto.recipepuppy.common.view.activity.BaseActivity;
import com.alberto.recipepuppy.ui.detail.RecipeDetailActivity;
import com.alberto.recipepuppy.ui.home.adapter.RecipesAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeMvpView, RecipesAdapter.OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.emptyView)
    TextView emptyView;

    @BindView(R.id.rvRecipes)
    RecyclerView rvRecipes;

    @Inject
    HomePresenter homePresenter;

    private String lastSearch = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        homePresenter.attachView(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        final MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                lastSearch = query;
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if (query.length() > 2) {
                    homePresenter.searchQuery(query);
                } else if (!lastSearch.isEmpty()) {
                    homePresenter.searchQuery(lastSearch);
                } else {
                    updateRecyclerView(new ArrayList<SearchDTO>());
                    showEmptyView(true);
                }
                return false;
            }
        });
        return true;
    }

    @Override
    public void searchSuccess(SearchResponse searchResponse) {
        showEmptyView(searchResponse.getResults().size() == 0);
        updateRecyclerView(searchResponse.getResults());
    }

    @Override
    public void searchError() {
        showEmptyView(true);
    }

    @Override
    public void onItemClick(SearchDTO searchDTO) {
        Intent intent = RecipeDetailActivity.newInstance(this, searchDTO);
        startActivity(intent);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvRecipes.setLayoutManager(layoutManager);
        rvRecipes.setHasFixedSize(true);
        rvRecipes.setItemAnimator(new DefaultItemAnimator());
        rvRecipes.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void updateRecyclerView(List<SearchDTO> results) {
        RecipesAdapter adapter = new RecipesAdapter(results);
        adapter.setOnItemClickListener(this);
        rvRecipes.setAdapter(adapter);
    }

    private void showEmptyView(boolean show) {
        emptyView.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}
