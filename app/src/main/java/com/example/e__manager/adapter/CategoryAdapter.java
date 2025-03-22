package com.example.e__manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e__manager.R;
import com.example.e__manager.databinding.SampleCategoryItemBinding;
import com.example.e__manager.models.Category;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryViewHolder> {

    Context context;

    ArrayList<Category> categories;

    public interface CategoryClicklistener {
        void onCategoryClicked(Category category);
    }
    CategoryClicklistener categoryClicklistener;

    public CategoryAdapter(Context context,ArrayList<Category> categories, CategoryClicklistener categoryClicklistener) {
        this.context = context;
        this.categories = categories;
        this.categoryClicklistener = categoryClicklistener;
    }

    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new categoryViewHolder(LayoutInflater.from(context).inflate(R.layout.sample_category_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.binding.categoryText.setText(category.getCategoryName());
        holder.binding.categoryIcon.setImageResource(category.getCategoryImage());

        holder.binding.categoryIcon.setBackgroundTintList(context.getColorStateList(category.getCategorycolor()));

        holder.itemView.setOnClickListener(c -> {
            categoryClicklistener.onCategoryClicked(category);

        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {

        SampleCategoryItemBinding binding;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =SampleCategoryItemBinding.bind(itemView);
        }
    }
}
