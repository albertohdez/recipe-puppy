package com.alberto.recipepuppy.ui.home.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alberto.recipepuppy.R;
import com.alberto.recipepuppy.common.model.SearchDTO;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.MyViewHolder> {

    private List<SearchDTO> recipesList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(SearchDTO searchDTO);
    }

    public RecipesAdapter(List<SearchDTO> recipesList) {
        this.recipesList = recipesList;
    }

    @Override
    public RecipesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View recipeView = inflater.inflate(R.layout.row_recipes, parent, false);
        return new MyViewHolder(recipeView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SearchDTO recipe = recipesList.get(position);
        ImageView imageView = holder.ivRecipe;
        Glide.with(context)
                .load(recipe.getThumbnail())
                .placeholder(android.R.drawable.ic_dialog_alert)
                .into(imageView);
        holder.tvTitle.setText(recipe.getTitle());
        holder.tvDesc.setText(recipe.getIngredients());
        holder.tvUrl.setText(recipe.getHref());
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivRecipe)
        ImageView ivRecipe;

        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvDesc)
        TextView tvDesc;
        @BindView(R.id.tvUrl)
        TextView tvUrl;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.rlRecipe)
        public void onClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                SearchDTO recipe = recipesList.get(position);
                onItemClickListener.onItemClick(recipe);
            }
        }
    }
}
