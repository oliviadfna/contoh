package com.example.helloworld;

class ZakatPertanian extends Zakat {
    private static final double NISAB_PER_TAHUNNN = 750;
    private double hasilPanen;

    public ZakatPertanian(double hasilPanen) {
        this.hasilPanen = hasilPanen;
    }

    public double getHasilPanen() {
        return hasilPanen;
    }

    public void setHasilPanen(double hasilPanen) {
        this.hasilPanen = hasilPanen;
    }

    @Override
    public int hitungZakat() {
        return PerhitunganZakat.hitungZakatPertanian(hasilPanen, NISAB_PER_TAHUNNN);
    }
}
