package com.yemekapp.android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.yemekapp.android.Adapter.RV_RestoranAdapter;
import com.yemekapp.android.Model.Restoran;
import com.yemekapp.android.R;

import java.util.ArrayList;

public class RestoranlariListeleActivity extends AppCompatActivity {

    EditText etRestoranAra;
    ImageView ivHome;
    RecyclerView rvRestoranlariListele;
    RecyclerView.LayoutManager layoutManager;
    RV_RestoranAdapter adapter;

    public void init(){
        rvRestoranlariListele = findViewById(R.id.rvRestoranlariListele);
        etRestoranAra = findViewById(R.id.etRestoranAra);
        ivHome = findViewById(R.id.ivHome);
        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public ArrayList<Restoran> getRestoranlar(){
        ArrayList<Restoran> restoranlar = new ArrayList<>();

        restoranlar.add(new Restoran(1,"Ad 1",34,"Sultangazi Uğurmumcu","Adres","https://cdn.yemeksepeti.com/adm/ramazan_new_web.jpg",0,30,20));
        restoranlar.add(new Restoran(2,"Ad 2",34,"Sultangazi Uğurmumcu","Adres","https://cdn.yemeksepeti.com/adm/ramazan_new_web.jpg",0,30,20));
        restoranlar.add(new Restoran(3,"Ad 3",34,"Sultangazi Uğurmumcu","Adres","https://cdn.yemeksepeti.com/adm/ramazan_new_web.jpg",0,30,20));

        return restoranlar;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoranlari_listele);
        init();

        layoutManager = new LinearLayoutManager(getApplicationContext());
        adapter = new RV_RestoranAdapter(getRestoranlar());
        rvRestoranlariListele.setLayoutManager(layoutManager);
        rvRestoranlariListele.setAdapter(adapter);
        rvRestoranlariListele.setItemAnimator(new DefaultItemAnimator());
    }
}