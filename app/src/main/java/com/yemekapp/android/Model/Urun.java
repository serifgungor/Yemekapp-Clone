package com.yemekapp.android.Model;

import java.io.Serializable;

public class Urun implements Serializable {
    private int id;
    private int urun_adedi;
    private double urun_fiyat;
    private String urun_adi;
    private String urun_aciklama;
    private String urun_gorsel_url;
    private boolean urun_satisdurumu;

    public Urun() {
    }

    public Urun(int id, int urun_adedi, double urun_fiyat, String urun_adi, String urun_aciklama, String urun_gorsel_url, boolean urun_satisdurumu) {
        this.id = id;
        this.urun_adedi = urun_adedi;
        this.urun_fiyat = urun_fiyat;
        this.urun_adi = urun_adi;
        this.urun_aciklama = urun_aciklama;
        this.urun_gorsel_url = urun_gorsel_url;
        this.urun_satisdurumu = urun_satisdurumu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrun_adedi() {
        return urun_adedi;
    }

    public void setUrun_adedi(int urun_adedi) {
        this.urun_adedi = urun_adedi;
    }

    public double getUrun_fiyat() {
        return urun_fiyat;
    }

    public void setUrun_fiyat(double urun_fiyat) {
        this.urun_fiyat = urun_fiyat;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getUrun_aciklama() {
        return urun_aciklama;
    }

    public void setUrun_aciklama(String urun_aciklama) {
        this.urun_aciklama = urun_aciklama;
    }

    public String getUrun_gorsel_url() {
        return urun_gorsel_url;
    }

    public void setUrun_gorsel_url(String urun_gorsel_url) {
        this.urun_gorsel_url = urun_gorsel_url;
    }

    public boolean isUrun_satisdurumu() {
        return urun_satisdurumu;
    }

    public void setUrun_satisdurumu(boolean urun_satisdurumu) {
        this.urun_satisdurumu = urun_satisdurumu;
    }
}
