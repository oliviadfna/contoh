package com.example.helloworld;
import java.util.Date;

class ZakatPertanian extends Zakat {
    private static final double NISAB_PER_TAHUNNN = 750;
    private double hasilPanen;

    public ZakatPertanian(String nama, Date tanggal, double hasilPanen) {
        super(nama, tanggal);
        this.hasilPanen = hasilPanen;
    }

    public double getHasilPanen() {
        return hasilPanen;
    }

    public void setHasilPanen(double hasilPanen) {
        this.hasilPanen = hasilPanen;
    }

    @Override
    public int hitungZakat(){
        if (hasilPanen > NISAB_PER_TAHUNNN) {
            return (int) (0.05 * hasilPanen);
        } else {
            return 0;
        }
    }
}