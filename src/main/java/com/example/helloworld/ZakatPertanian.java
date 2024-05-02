package com.example.helloworld;

class ZakatPertanian extends Zakat {
    private static final double NISAB_PER_TAHUNNN = 750;
    private double hasilPanen;

    public ZakatPertanian(int jumlahOrang, double hasilPanen) {
        super(jumlahOrang);
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
        return PerhitunganZakat.hitungZakatPertanian(getJumlahOrang(), hasilPanen, NISAB_PER_TAHUNNN);
    }
}
