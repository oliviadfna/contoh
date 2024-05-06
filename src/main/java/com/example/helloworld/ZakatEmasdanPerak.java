package com.example.helloworld;

class ZakatEmasdanPerak extends Zakat{
    private static final double NISAB_PER_TAHUNN = 82000000;
    private double jumlahEmas_Gram;
    private double jumlahPerak_Gram;

    public ZakatEmasdanPerak(double jumlahEmas_Gram, double jumlahPerak_Gram) {
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
    public int hitungZakat() {
        return PerhitunganZakat.hitungZakatEmasDanPerak(jumlahEmas_Gram, jumlahPerak_Gram,
                NISAB_PER_TAHUNN);
    }
}
