package com.suresh.accuciatest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ranking {
    @SerializedName("ranking")
    @Expose
    private String ranking;
    @SerializedName("products")
    @Expose
    private List<Product__1> products = null;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Product__1> getProducts() {
        return products;
    }

    public void setProducts(List<Product__1> products) {
        this.products = products;
    }
}
