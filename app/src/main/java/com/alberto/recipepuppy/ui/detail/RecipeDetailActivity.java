package com.alberto.recipepuppy.ui.detail;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.alberto.recipepuppy.R;
import com.alberto.recipepuppy.common.model.SearchDTO;
import com.alberto.recipepuppy.common.view.activity.BaseActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends BaseActivity {
    private static final String EXTRA_RECIPE = "extra_recipe";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.backdrop)
    ImageView backdrop;

    @BindView(R.id.tvIngredients)
    TextView tvIngredients;

    @BindView(R.id.tvReference)
    TextView tvReference;

    public static Intent newInstance(Activity activity, SearchDTO searchDTO) {
        Intent intent = new Intent(activity, RecipeDetailActivity.class);
        intent.putExtra(EXTRA_RECIPE, searchDTO);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchDTO recipe = getIntent().getParcelableExtra(EXTRA_RECIPE);
        if (recipe != null) {
            setupUI(recipe);
        }
    }

    private void setupUI(SearchDTO recipe) {
        Glide.with(this)
                .load(recipe.getThumbnail())
                .centerCrop()
                .into(backdrop);

        collapsingToolbar.setTitle(recipe.getTitle());
        tvIngredients.setText(recipe.getIngredients());
        tvReference.setText(recipe.getHref());
    }
}
