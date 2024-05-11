package com.example.helloworld;

import java.util.Date;

class ZakatPenghasilan extends Zakat {
    private static final double NISAB_PER_BULAN = 6800000;
    private static final double NISAB_PER_TAHUN = 82000000;
    private double penghasilanPerBulan;
    private double penghasilanLain;

    public ZakatPenghasilan(String nama, Date tanggal, double penghasilanPerBulan, double penghasilanLain) {
        super(nama, tanggal);
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
    public int hitungZakat(){
        double totalPenghasilanPerBulan = penghasilanPerBulan + penghasilanLain;
        if (totalPenghasilanPerBulan > NISAB_PER_BULAN){
            return (int) (0.025 * totalPenghasilanPerBulan);
        } else {
            return 0;
        }
    }
}