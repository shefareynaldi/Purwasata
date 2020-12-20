package com.example.purwasata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.purwasata.API.ApiConfig;
import com.example.purwasata.API.ApiService;
import com.example.purwasata.model.WisataItem;
import com.example.purwasata.model.WisataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private ArrayList<WisataItem> wisataItems;
    private AdapterWisata adapterWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        wisataItems = new ArrayList<>();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<WisataModel>() {
            @Override
            public void onResponse(Call<WisataModel> call, Response<WisataModel> response) {
                if (response.isSuccessful()) {
                    wisataItems = response.body().getWisata();
                    adapterWisata = new AdapterWisata(wisataItems, getApplicationContext());
                    recyclerview.setAdapter(adapterWisata);
                    recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<WisataModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        recyclerview = findViewById(R.id.recyclerview);
    }
}