package com.example.purwasata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.purwasata.model.WisataItem;

import java.util.ArrayList;

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.ViewHolder> {
    private ArrayList<WisataItem> wisataItems;
    private Context context;

    public AdapterWisata(ArrayList<WisataItem> wisataItems, Context context) {
        this.wisataItems = wisataItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_wisata, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_nama.setText(wisataItems.get(position).getNama());
        Glide.with(context).load(wisataItems.get(position).getGambarUrl()).into(holder.iv_wisata);
        holder.list_wisata.setOnClickListener(view -> {
            Intent intent = new Intent(context, ActivityDetail.class);
            intent.putExtra("nama", wisataItems.get(position).getNama());
            intent.putExtra("kategori", wisataItems.get(position).getKategori());
            intent.putExtra("gambar", wisataItems.get(position).getGambarUrl());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return wisataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_nama;
        private ImageView iv_wisata;
        private RelativeLayout list_wisata;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nama = itemView.findViewById(R.id.tv_nama);
            iv_wisata = itemView.findViewById(R.id.iv_wisata);
            list_wisata = itemView.findViewById(R.id.list_wisata);
        }
    }
}