package com.example.e__manager.models;

public class Category {

    private String categoryName;
    private int categoryImage;


    private int categorycolor;

    public Category() {

    }

    public Category(String categoryName, int categoryImage, int categorycolor) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categorycolor = categorycolor;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategorycolor() {
        return categorycolor;
    }

    public void setCategorycolor(int categorycolor) {
        this.categorycolor = categorycolor;
    }
}
