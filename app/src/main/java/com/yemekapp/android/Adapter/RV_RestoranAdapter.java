package com.yemekapp.android.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yemekapp.android.Activity.RestoranDetayActivity;
import com.yemekapp.android.Holder.RestoranHolder;
import com.yemekapp.android.Model.Restoran;
import com.yemekapp.android.R;

import java.util.ArrayList;

public class RV_RestoranAdapter extends RecyclerView.Adapter<RestoranHolder> implements Filterable {
    private ArrayList<Restoran> restoranList;
    private ArrayList<Restoran> restoranListFiltered;

    public RV_RestoranAdapter(ArrayList<Restoran> restoranList){
        this.restoranList = restoranList;
        this.restoranListFiltered = restoranList;
    }

    @NonNull
    @Override
    public RestoranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.restoran_row,null);
        return new RestoranHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RestoranHolder holder, int position) {
        Restoran r = restoranListFiltered.get(position);
        holder.tvRestoranAdi.setText(r.getRestoranAdi());
        holder.tvRestoranGetirmeUcreti.setText(""+r.getGetirmeUcreti());
        holder.tvRestoranMinUcret.setText(""+r.getMinUcret());
        holder.tvRestoranOrtalamaSure.setText(""+r.getGetirmeSuresi());
        holder.tvRestoranIlceMahalle.setText(r.getRestoranIlceMahalle());
        Glide.with(holder.itemView.getContext()).load(r.getRestoranKapakGorsel()).into(holder.ivRestoranKapakGorsel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), RestoranDetayActivity.class);
                intent.putExtra("restoran",r);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restoranListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String query = charSequence.toString();
                ArrayList<Restoran> filtered = new ArrayList<>();

                //edittextin içerisi boşsa
                if(query.isEmpty()){
                    // filtreyi restoranlistesiyle doldur
                    filtered = restoranList;
                }else{
                    for (Restoran r:restoranList
                         ) {
                        //edittextin içindeki yazı başlıkta geçiyorsa
                        if(r.getRestoranAdi().toLowerCase().contains(query.toLowerCase()) ||
                                r.getRestoranIlceMahalle().toLowerCase().contains(query.toLowerCase())){
                            filtered.add(r);
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
                restoranListFiltered = (ArrayList<Restoran>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
