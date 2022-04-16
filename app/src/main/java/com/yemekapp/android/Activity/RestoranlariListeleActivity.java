package com.yemekapp.android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.yemekapp.android.R;

public class RestoranlariListeleActivity extends AppCompatActivity {

    EditText etRestoranAra;
    ImageView ivHome;
    RecyclerView rvRestoranlariListele;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoranlari_listele);
        init();
    }
}