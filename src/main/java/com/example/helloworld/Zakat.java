package com.example.helloworld;

abstract class Zakat {
    protected int jumlahOrang;

    public Zakat(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public abstract int hitungZakat();
}
