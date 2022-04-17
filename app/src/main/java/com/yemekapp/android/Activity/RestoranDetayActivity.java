package com.yemekapp.android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yemekapp.android.Adapter.RV_UrunAdapter;
import com.yemekapp.android.Model.Restoran;
import com.yemekapp.android.Model.Urun;
import com.yemekapp.android.R;

import java.util.ArrayList;

public class RestoranDetayActivity extends AppCompatActivity {
    ImageView ivHomeDetay; //geri git butonu
    EditText etUrunAraRestoran; //toolbardan ürün adı arama
    RecyclerView rvUrunleriListele; //Recyclerview ile restorandaki ürünlerin listelenmesi
    ImageView ivRestoranKapakGorselDetay;
    TextView tvRestoranAdiDetay,tvRestoranIlceMahalleDetay;
    Restoran restoran;

    RV_UrunAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    public ArrayList<Urun> getUrunler(){
        ArrayList<Urun> urunler = new ArrayList<>();


        //int id, int urun_adedi, double urun_fiyat, String urun_adi, String urun_aciklama, String urun_gorsel_url, boolean urun_satisdurumu

        urunler.add(new Urun(1,1,10,"Ramazan Pidesi","","https://i01.sozcucdn.com/wp-content/uploads/2022/03/22/iecrop/ramazan-pidesi-shutter_16_9_1647958254.jpg",true));
        urunler.add(new Urun(1,1,10,"Kır Pidesi","","https://www.yemek24.com/wp-content/uploads/2020/05/Kastamonu-Kir-Pidesi.jpg",true));
        urunler.add(new Urun(1,1,10,"Ramazan Şerbeti","","https://iasbh.tmgrup.com.tr/1b3f5c/650/344/0/54/1000/578?u=https://isbh.tmgrup.com.tr/sbh/2018/05/16/iftar-sofralarinin-ferahlatan-tadi-osmanli-serbeti-1526458555083.jpg",true));
        urunler.add(new Urun(1,1,10,"Ayran","","https://im.haberturk.com/2020/10/16/ver1602810555/2837117_810x458.jpg",true));

        return urunler;
    }

    public void init(){
        ivHomeDetay = findViewById(R.id.ivHomeDetay);
        ivHomeDetay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        etUrunAraRestoran = findViewById(R.id.etUrunAraRestoran);
        rvUrunleriListele = findViewById(R.id.rvUrunleriListele);
        ivRestoranKapakGorselDetay = findViewById(R.id.ivRestoranKapakGorselDetay);
        tvRestoranAdiDetay = findViewById(R.id.tvRestoranAdiDetay);
        tvRestoranIlceMahalleDetay = findViewById(R.id.tvRestoranIlceMahalleDetay);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoran_detay);
        init();

        restoran = (Restoran)getIntent().getSerializableExtra("restoran");
        tvRestoranAdiDetay.setText(restoran.getRestoranAdi());
        tvRestoranIlceMahalleDetay.setText(restoran.getRestoranIlceMahalle());
        Glide.with(getApplicationContext()).load(restoran.getRestoranKapakGorsel()).into(ivRestoranKapakGorselDetay);

        adapter = new RV_UrunAdapter(getUrunler());
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rvUrunleriListele.setAdapter(adapter);
        rvUrunleriListele.setLayoutManager(layoutManager);
        rvUrunleriListele.setItemAnimator(new DefaultItemAnimator());

        etUrunAraRestoran.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}