package com.yemekapp.android.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yemekapp.android.R;

public class RestoranHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView ivRestoranKapakGorsel;
    public TextView tvRestoranAdi,tvRestoranIlceMahalle,tvRestoranMinUcret,tvRestoranOrtalamaSure,tvRestoranGetirmeUcreti;

    public RestoranHolder(@NonNull View itemView) {
        super(itemView);
        ivRestoranKapakGorsel = itemView.findViewById(R.id.ivRestoranKapakGorsel);
        tvRestoranAdi = itemView.findViewById(R.id.tvRestoranAdi);
        tvRestoranIlceMahalle = itemView.findViewById(R.id.tvRestoranIlceMahalle);
        tvRestoranMinUcret = itemView.findViewById(R.id.tvRestoranMinUcret);
        tvRestoranOrtalamaSure = itemView.findViewById(R.id.tvRestoranOrtalamaSure);
        tvRestoranGetirmeUcreti = itemView.findViewById(R.id.tvRestoranGetirmeUcreti);
        itemView.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {

    }
}
