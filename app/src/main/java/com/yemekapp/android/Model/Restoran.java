package com.yemekapp.android.Model;

import java.io.Serializable;

public class Restoran implements Serializable {
    private int id;
    private String restoranAdi;
    private int restoranIl;
    private String restoranIlceMahalle;
    private String restoranAdresi;
    private String restoranKapakGorsel;
    private double getirmeUcreti;
    private double getirmeSuresi;
    private double minUcret;

    public Restoran() {
    }

    public Restoran(int id, String restoranAdi, int restoranIl, String restoranIlceMahalle, String restoranAdresi, String restoranKapakGorsel, double getirmeUcreti, double getirmeSuresi, double minUcret) {
        this.id = id;
        this.restoranAdi = restoranAdi;
        this.restoranIl = restoranIl;
        this.restoranIlceMahalle = restoranIlceMahalle;
        this.restoranAdresi = restoranAdresi;
        this.restoranKapakGorsel = restoranKapakGorsel;
        this.getirmeUcreti = getirmeUcreti;
        this.getirmeSuresi = getirmeSuresi;
        this.minUcret = minUcret;
    }

    public String getRestoranIlceMahalle() {
        return restoranIlceMahalle;
    }

    public void setRestoranIlceMahalle(String restoranIlceMahalle) {
        this.restoranIlceMahalle = restoranIlceMahalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestoranAdi() {
        return restoranAdi;
    }

    public void setRestoranAdi(String restoranAdi) {
        this.restoranAdi = restoranAdi;
    }

    public int getRestoranIl() {
        return restoranIl;
    }

    public void setRestoranIl(int restoranIl) {
        this.restoranIl = restoranIl;
    }

    public String getRestoranAdresi() {
        return restoranAdresi;
    }

    public void setRestoranAdresi(String restoranAdresi) {
        this.restoranAdresi = restoranAdresi;
    }

    public String getRestoranKapakGorsel() {
        return restoranKapakGorsel;
    }

    public void setRestoranKapakGorsel(String restoranKapakGorsel) {
        this.restoranKapakGorsel = restoranKapakGorsel;
    }

    public double getGetirmeUcreti() {
        return getirmeUcreti;
    }

    public void setGetirmeUcreti(double getirmeUcreti) {
        this.getirmeUcreti = getirmeUcreti;
    }

    public double getGetirmeSuresi() {
        return getirmeSuresi;
    }

    public void setGetirmeSuresi(double getirmeSuresi) {
        this.getirmeSuresi = getirmeSuresi;
    }

    public double getMinUcret() {
        return minUcret;
    }

    public void setMinUcret(double minUcret) {
        this.minUcret = minUcret;
    }
}
