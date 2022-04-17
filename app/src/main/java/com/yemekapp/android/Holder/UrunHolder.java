package com.yemekapp.android.Holder;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yemekapp.android.R;

public class UrunHolder extends RecyclerView.ViewHolder {

    public ImageView ivUrunResim;
    public TextView tvUrunAdi;
    public TextView tvUrunUcret;
    public TextView tvUrunHesaplananUcret;
    public EditText etUrunSayisi;
    public Button btnUrunArttir,btnUrunAzalt;

    public UrunHolder(@NonNull View itemView) {
        super(itemView);
        ivUrunResim = itemView.findViewById(R.id.ivUrunResim);
        tvUrunAdi = itemView.findViewById(R.id.tvUrunAdi);
        tvUrunUcret = itemView.findViewById(R.id.tvUrunUcret);
        tvUrunHesaplananUcret = itemView.findViewById(R.id.tvUrunHesaplananUcret);
        etUrunSayisi = itemView.findViewById(R.id.etUrunSayisi);
        btnUrunArttir = itemView.findViewById(R.id.btnUrunArttir);
        btnUrunAzalt = itemView.findViewById(R.id.btnUrunAzalt);
    }
}
