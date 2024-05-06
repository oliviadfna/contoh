package com.example.helloworld;

class ZakatPenghasilan extends Zakat {
    private static final double NISAB_PER_BULAN = 6800000;
    private static final double NISAB_PER_TAHUN = 82000000;
    private double penghasilanPerBulan;
    private double penghasilanLain;

    public ZakatPenghasilan(double penghasilanPerBulan, double penghasilanLain) {
        this.penghasilanPerBulan = penghasilanPerBulan;
        this.penghasilanLain = penghasilanLain;
    }

    public double getPenghasilanPerBulan() {
        return penghasilanPerBulan;
    }

    public void setPenghasilanPerBulan(double penghasilanPerBulan) {
        this.penghasilanPerBulan = penghasilanPerBulan;
    }

    public double getPenghasilanLain() {
        return penghasilanLain;
    }

    public void setPenghasilanLain(double penghasilanLain) {
        this.penghasilanLain = penghasilanLain;
    }

    @Override
    public int hitungZakat() {
        return PerhitunganZakat.hitungZakatPenghasilan(penghasilanPerBulan, penghasilanLain,
                NISAB_PER_BULAN, NISAB_PER_TAHUN);
    }
}
