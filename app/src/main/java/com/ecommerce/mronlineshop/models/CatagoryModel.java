package com.ecommerce.mronlineshop.models;

public class CatagoryModel {
    private String cat_title;
    private String cat_img;
    public CatagoryModel() {
    }

    public CatagoryModel(String cat_title, String cat_img) {
        this.cat_title = cat_title;
        this.cat_img = cat_img;
    }

    public String getCat_title() {
        return cat_title;
    }

    public void setCat_title(String cat_title) {
        this.cat_title = cat_title;
    }

    public String getCat_img() {
        return cat_img;
    }

    public void setCat_img(String cat_img) {
        this.cat_img = cat_img;
    }
}
