package com.ecommerce.mronlineshop.models;

public class Simple_product_model {

    private int simple_image;
    private String simple_title;

    public int getSimple_image() {
        return simple_image;
    }

    public void setSimple_image(int simple_image) {
        this.simple_image = simple_image;
    }

    public String getSimple_title() {
        return simple_title;
    }

    public void setSimple_title(String simple_title) {
        this.simple_title = simple_title;
    }

    public String getSimple_description() {
        return simple_description;
    }

    public void setSimple_description(String simple_description) {
        this.simple_description = simple_description;
    }

    public String getSimple_price() {
        return simple_price;
    }

    public void setSimple_price(String simple_price) {
        this.simple_price = simple_price;
    }

    public String getSimple_coupon() {
        return simple_coupon;
    }

    public void setSimple_coupon(String simple_coupon) {
        this.simple_coupon = simple_coupon;
    }

    public String getSimple_off() {
        return simple_off;
    }

    public void setSimple_off(String simple_off) {
        this.simple_off = simple_off;
    }

    public String getSimple_status() {
        return simple_status;
    }

    public void setSimple_status(String simple_status) {
        this.simple_status = simple_status;
    }

    public Simple_product_model(int simple_image, String simple_title, String simple_description, String simple_price, String simple_coupon, String simple_off, String simple_status) {
        this.simple_image = simple_image;
        this.simple_title = simple_title;
        this.simple_description = simple_description;
        this.simple_price = simple_price;
        this.simple_coupon = simple_coupon;
        this.simple_off = simple_off;
        this.simple_status = simple_status;
    }

    private String simple_description;
    private String simple_price;
    private String simple_coupon;
    private String simple_off;
    private String simple_status;

    public Simple_product_model() {
    }
}
