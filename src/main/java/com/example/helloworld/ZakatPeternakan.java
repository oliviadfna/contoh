package com.example.helloworld;

import java.util.Date;

class ZakatPeternakan extends Zakat{
    private static final double NISAB_KAMBING_DOMBA= 120;
    private static final double NISAB_SAPI= 30;
    private double jumlahKambingDanDomba;
    private double jumlahSapi;

    public ZakatPeternakan(String nama, Date tanggal, double jumlahKambingDanDomba, double jumlahSapi) {
        super(nama, tanggal);
        this.jumlahKambingDanDomba = jumlahKambingDanDomba;
        this.jumlahSapi = jumlahSapi;
    }

    public double getJumlahKambingDanDomba() {
        return jumlahKambingDanDomba;
    }

    public void setJumlahKambingDanDomba(double jumlahKambingDanDomba) {
        this.jumlahKambingDanDomba = jumlahKambingDanDomba;
    }

    public double getJumlahSapi() {
        return jumlahSapi;
    }

    public void setJumlahSapi(double jumlahSapi) {
        this.jumlahSapi = jumlahSapi;
    }

    @Override
    public int hitungZakat(){
        int zakatKambingDanDomba = 0;
        int zakatSapi = 0;

        //kambing
        if (jumlahKambingDanDomba > NISAB_KAMBING_DOMBA){
            zakatKambingDanDomba = (int) (jumlahKambingDanDomba / NISAB_KAMBING_DOMBA);
        }
        //sapi
        if (jumlahSapi > NISAB_SAPI) {
            zakatSapi = (int) (jumlahSapi / NISAB_SAPI);
        }
        return zakatKambingDanDomba + zakatSapi;
    }
}