package com.example.helloworld;

import java.util.Date;

class HistoryZakat {
    private String nama;
    private Date tanggal;
    private String jenisZakat;
    private int jumlahZakat;

    public HistoryZakat(String nama, Date tanggal, String jenisZakat, int jumlahZakat) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.jenisZakat = jenisZakat;
        this.jumlahZakat = jumlahZakat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenisZakat() {
        return jenisZakat;
    }

    public void setJenisZakat(String jenisZakat) {
        this.jenisZakat = jenisZakat;
    }

    public int getJumlahZakat() {
        return jumlahZakat;
    }

    public void setJumlahZakat(int jumlahZakat) {
        this.jumlahZakat = jumlahZakat;
    }
}
