package com.yemekapp.android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.yemekapp.android.Adapter.ImageAdapter;
import com.yemekapp.android.R;

public class YemekSiparisActivity extends AppCompatActivity {
    ViewPager viewPagerSlider;
    ImageAdapter adapterView;

    public void init(){
        viewPagerSlider = findViewById(R.id.viewPagerSlider);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_siparis);
        init();

        adapterView = new ImageAdapter(getApplicationContext());
        viewPagerSlider.setAdapter(adapterView);
    }
}