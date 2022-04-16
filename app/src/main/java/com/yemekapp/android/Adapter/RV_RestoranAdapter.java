package com.yemekapp.android.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yemekapp.android.Holder.RestoranHolder;
import com.yemekapp.android.Model.Restoran;
import com.yemekapp.android.R;

import java.util.ArrayList;

public class RV_RestoranAdapter extends RecyclerView.Adapter<RestoranHolder> {
    private ArrayList<Restoran> restoranList;

    public RV_RestoranAdapter(ArrayList<Restoran> restoranList){
        this.restoranList = restoranList;
    }

    @NonNull
    @Override
    public RestoranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.restoran_row,null);
        return new RestoranHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RestoranHolder holder, int position) {
        Restoran r = restoranList.get(position);
        holder.tvRestoranAdi.setText(r.getRestoranAdi());
        holder.tvRestoranGetirmeUcreti.setText(""+r.getGetirmeUcreti());
        holder.tvRestoranMinUcret.setText(""+r.getMinUcret());
        holder.tvRestoranOrtalamaSure.setText(""+r.getGetirmeSuresi());
        holder.tvRestoranIlceMahalle.setText(r.getRestoranIlceMahalle());
        Glide.with(holder.itemView.getContext()).load(r.getRestoranKapakGorsel()).into(holder.ivRestoranKapakGorsel);
    }

    @Override
    public int getItemCount() {
        return restoranList.size();
    }
}
