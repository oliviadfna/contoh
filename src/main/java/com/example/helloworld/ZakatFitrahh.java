package com.example.helloworld;

class ZakatFitrahh extends Zakat {
    private static final double BERAT_BERAS = 2.5; // kg
    private static final double HARGA_BERAS_PER_KG = 20000; // rupiah

    public ZakatFitrahh(int jumlahOrang) {
        super(jumlahOrang);
    }

    @Override
    public int hitungZakat() {
        return PerhitunganZakat.hitungZakatFitrah(getJumlahOrang(), BERAT_BERAS, HARGA_BERAS_PER_KG);
    }
}