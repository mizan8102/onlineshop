package com.ecommerce.mronlineshop.models;

public class Great_offer_model {
    private int offer_img;
    private String shop_name;
    private String time;

    public Great_offer_model() {
    }

    public int getOffer_img() {
        return offer_img;
    }

    public void setOffer_img(int offer_img) {
        this.offer_img = offer_img;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private String discount;

    public Great_offer_model(int offer_img, String shop_name, String time, String discount, String rating) {
        this.offer_img = offer_img;
        this.shop_name = shop_name;
        this.time = time;
        this.discount = discount;
        this.rating = rating;
    }

    private String rating;


}
