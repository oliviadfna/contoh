package com.example.helloworld;

import java.util.Date;

class ZakatFitrahh extends Zakat {
    private static final double BERAT_BERAS = 2.5; // kg
    private static final double HARGA_BERAS_PER_KG = 20000; // rupiah
    private int jumlahOrang;

    public ZakatFitrahh(String nama, Date tanggal, int jumlahOrang) {
        super(nama, tanggal);
        this.jumlahOrang = jumlahOrang;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    @Override
    public int hitungZakat() {
        double totalJumlahBeras = jumlahOrang * BERAT_BERAS;
        double totalJumlahUang = totalJumlahBeras * HARGA_BERAS_PER_KG;
        return (int) totalJumlahUang;
    }
}
