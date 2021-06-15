package com.suresh.accuciatest.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String MainURL = "https://stark-spire-93433.herokuapp.com/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(MainURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getApiInterface()
    {
        ApiInterface interfaceUserInfo= RetrofitClient.getClient().create(ApiInterface.class);
        return interfaceUserInfo;
    }
}
