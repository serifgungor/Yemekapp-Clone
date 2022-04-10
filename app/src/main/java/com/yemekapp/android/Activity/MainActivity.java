package com.yemekapp.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yemekapp.android.Adapter.ImageAdapter;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbarMain;
    TextView tvYemekSiparis,tvAlisveris,tvHizliMarket;

    public void init(){
        //Androidin varsayılanındaki toolbarı iptal edip, yeni bir toolbar oluşturup onu kullandık.
        //this.getSupportActionBar().hide(); //Var olan toolbarı gizledik.
        toolbarMain = findViewById(R.id.toolbarMain);
        this.setSupportActionBar(toolbarMain);

        tvYemekSiparis = findViewById(R.id.tvYemekSiparisi);
        tvAlisveris = findViewById(R.id.tvAlisveris);
        tvHizliMarket = findViewById(R.id.tvHizliMarket);


        tvYemekSiparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),YemekSiparisActivity.class));
            }
        });
        tvAlisveris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tvHizliMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

}