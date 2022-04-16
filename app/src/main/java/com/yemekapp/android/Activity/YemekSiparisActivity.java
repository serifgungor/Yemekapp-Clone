package com.yemekapp.android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yemekapp.android.Adapter.ImageAdapter;
import com.yemekapp.android.R;

import java.util.ArrayList;

public class YemekSiparisActivity extends AppCompatActivity{
    ViewPager viewPagerSlider;
    ImageAdapter adapterView;

    LinearLayout mutfaklarLayout,favoriMekanlarimLayout,oncekiSiparislerimLayout;




    public void init(){
        viewPagerSlider = findViewById(R.id.viewPagerSlider);
        mutfaklarLayout = findViewById(R.id.mutfaklarLayout);
        favoriMekanlarimLayout = findViewById(R.id.favoriMekanlarimLayout);
        oncekiSiparislerimLayout = findViewById(R.id.oncekiSiparislerimLayout);
    }

    public void mutfaklariDoldur(){
        ArrayList<String> mutfaklar = new ArrayList<>();
        mutfaklar.add("Burger");
        mutfaklar.add("Çiğ Köfte");
        mutfaklar.add("Dondurma");
        mutfaklar.add("Döner");
        mutfaklar.add("Ev Yemekleri");
        mutfaklar.add("Kahve");
        mutfaklar.add("Kebap & Türk Mutfağı");
        mutfaklar.add("Kumpir");
        mutfaklar.add("Makarna & Salata");
        mutfaklar.add("Meze");
        mutfaklar.add("Pastane & Fırın");
        mutfaklar.add("Pide & Lahmacun");

        for (String mutfak:mutfaklar) {
            TextView tvMutfakAdi = new TextView(getApplicationContext());
            tvMutfakAdi.setText(mutfak);
            tvMutfakAdi.setTextSize(20f);
            tvMutfakAdi.setTextColor(Color.parseColor("#000000"));
            tvMutfakAdi.setPadding(25,10,25,10);
            tvMutfakAdi.setOnClickListener(this::onClickMutfak);
            mutfaklarLayout.addView(tvMutfakAdi);
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_siparis);
        init();
        mutfaklariDoldur();

        adapterView = new ImageAdapter(getApplicationContext());
        viewPagerSlider.setAdapter(adapterView);
    }

    public void onClickMutfak(View view) {
        Toast.makeText(getApplicationContext(), ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public void onClickFavoriMekan(View view) {
        Toast.makeText(getApplicationContext(), ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public void onClickOncekiSiparis(View view) {
        Toast.makeText(getApplicationContext(), ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
    }
}