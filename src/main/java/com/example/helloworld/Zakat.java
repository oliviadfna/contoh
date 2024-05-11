package com.example.helloworld;

import java.util.Date;

abstract class Zakat {
    private String nama;
    private Date tanggal;

    public Zakat(String nama, Date tanggal){
        this.nama = nama;
        this.tanggal = tanggal;
    }

    public abstract int hitungZakat();

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public Date getTanggal(){
        return tanggal;
    }
    public void setTanggal(Date tanggal){
        this.tanggal = tanggal;
    }
}
