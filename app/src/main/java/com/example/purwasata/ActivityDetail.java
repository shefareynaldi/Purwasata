package com.example.purwasata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView nama = findViewById(R.id.nama);
        TextView kategori = findViewById(R.id.kategori);
        ImageView gambar = findViewById(R.id.gambar);

        nama.setText(getIntent().getStringExtra("nama"));
        kategori.setText("Kategori: "+ getIntent().getStringExtra( "kategori"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambar")).into(gambar);
    }
}