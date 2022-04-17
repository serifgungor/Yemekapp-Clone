package com.yemekapp.android.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yemekapp.android.Holder.UrunHolder;
import com.yemekapp.android.Model.Urun;
import com.yemekapp.android.R;

import java.util.ArrayList;

public class RV_UrunAdapter extends RecyclerView.Adapter<UrunHolder> implements Filterable {
    private ArrayList<Urun> urunler = new ArrayList<>();
    private ArrayList<Urun> urunlerFiltered = new ArrayList<>();

    public RV_UrunAdapter(ArrayList<Urun> urunler){
        this.urunler = urunler;
        this.urunlerFiltered = urunler;
    }

    @NonNull
    @Override
    public UrunHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.urun_row,null);
        return new UrunHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UrunHolder holder, @SuppressLint("RecyclerView") final int position) {
        Urun u = urunlerFiltered.get(position);
        holder.btnUrunArttir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int urunSayisi = Integer.parseInt(holder.etUrunSayisi.getText().toString());
                urunSayisi = urunSayisi +1;
                holder.etUrunSayisi.setText(""+urunSayisi);
                double hesaplananToplamUcret = urunSayisi*u.getUrun_fiyat();
                holder.tvUrunHesaplananUcret.setText(""+hesaplananToplamUcret);
            }
        });
        holder.btnUrunAzalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int urunSayisi = Integer.parseInt(holder.etUrunSayisi.getText().toString());
                if(urunSayisi>0){
                    urunSayisi = urunSayisi - 1;
                    holder.etUrunSayisi.setText(""+urunSayisi);
                    double hesaplananToplamUcret = urunSayisi*u.getUrun_fiyat();
                    holder.tvUrunHesaplananUcret.setText(""+hesaplananToplamUcret);
                }
            }
        });
        holder.tvUrunAdi.setText(u.getUrun_adi());
        holder.etUrunSayisi.setText(""+0);
        holder.tvUrunUcret.setText(""+u.getUrun_fiyat());
        Glide.with(holder.itemView.getContext()).load(u.getUrun_gorsel_url()).into(holder.ivUrunResim);
    }

    @Override
    public int getItemCount() {
        return urunlerFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();
                ArrayList<Urun> filtered = new ArrayList<>();
                if(query.isEmpty()){
                    filtered = urunler;
                }else{
                    for (Urun u:urunler) {
                        if(u.getUrun_adi().toLowerCase().contains(query.toLowerCase())){
                            filtered.add(u);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.count = filtered.size();
                results.values = filtered;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                urunlerFiltered = (ArrayList<Urun>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
