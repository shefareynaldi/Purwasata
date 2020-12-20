package com.example.purwasata.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static com.example.purwasata.API.ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(com.example.purwasata.API.ApiService.class);
    }
}