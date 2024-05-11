package com.example.helloworld;

import java.util.Date;

class ZakatEmasdanPerak extends Zakat{
    private static final double NISAB_PER_TAHUNN = 82000000;
    private double jumlahEmas_Gram;
    private double jumlahPerak_Gram;

    public ZakatEmasdanPerak(String nama, Date tanggal, double jumlahEmas_Gram, double jumlahPerak_Gram) {
        super(nama,tanggal);
        this.jumlahEmas_Gram = jumlahEmas_Gram;
        this.jumlahPerak_Gram = jumlahPerak_Gram;
    }

    public double getJumlahEmas_Gram() {
        return jumlahEmas_Gram;
    }

    public void setJumlahEmas_Gram(double jumlahEmas_Gram) {
        this.jumlahEmas_Gram = jumlahEmas_Gram;
    }

    public double getJumlahPerak_Gram() {
        return jumlahPerak_Gram;
    }

    public void setJumlahPerak_Gram(double jumlahPerak_Gram) {
        this.jumlahPerak_Gram = jumlahPerak_Gram;
    }

    @Override
    public int hitungZakat(){
     double totalNilaiEmasPerak = (jumlahEmas_Gram * 1300000) + (jumlahPerak_Gram * 140000);
     if (totalNilaiEmasPerak > NISAB_PER_TAHUNN) {
         return (int) (0.025 * totalNilaiEmasPerak);
     } else {
         return 0;
     }
    }
}
