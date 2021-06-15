package com.suresh.accuciatest.apis;

import com.suresh.accuciatest.models.ProductsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/json")
    Call<ProductsModel> getProducts();
}
