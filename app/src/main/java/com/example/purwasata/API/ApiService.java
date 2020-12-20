package com.example.purwasata.API;

import com.example.purwasata.model.WisataModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("purwakarta/wisata")
    Call<WisataModel> getData();
}