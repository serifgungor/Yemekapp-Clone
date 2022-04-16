package com.yemekapp.android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yemekapp.android.Adapter.ImageAdapter;
import com.yemekapp.android.Helper.DatabaseHelper;
import com.yemekapp.android.R;

import java.io.IOException;
import java.util.ArrayList;

public class YemekSiparisActivity extends AppCompatActivity{
    ViewPager viewPagerSlider;
    ImageAdapter adapterView;

    LinearLayout mutfaklarLayout,favoriMekanlarimLayout,oncekiSiparislerimLayout;


    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public void dbInit(){
        try {
            dbHelper = new DatabaseHelper(getApplicationContext());
            db = dbHelper.getReadableDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        viewPagerSlider = findViewById(R.id.viewPagerSlider);
        mutfaklarLayout = findViewById(R.id.mutfaklarLayout);
        favoriMekanlarimLayout = findViewById(R.id.favoriMekanlarimLayout);
        oncekiSiparislerimLayout = findViewById(R.id.oncekiSiparislerimLayout);
    }

    @SuppressLint("Range")
    public void mutfaklariDoldur(){
        ArrayList<String> mutfaklar = new ArrayList<>();

        //Mutfakların veritabanından çekilmesi işlemi
        Cursor c = db.rawQuery("select * from Mutfak",null);
        while (c.moveToNext()){
            mutfaklar.add(c.getString(c.getColumnIndex("mutfak_adi")));
        }

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
        dbInit();
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