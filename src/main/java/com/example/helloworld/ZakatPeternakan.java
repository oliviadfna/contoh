package com.example.helloworld;

class ZakatPeternakan extends Zakat{
    private static final double NISAB_KAMBING_DOMBA= 120;
    private static final double NISAB_SAPI= 30;
    private double jumlahKambingDanDomba;
    private double jumlahSapi;

    public ZakatPeternakan(int jumlahOrang, double jumlahKambingDanDomba, double jumlahSapi) {
        super(jumlahOrang);
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
    public int hitungZakat() {
        return PerhitunganZakat.hitungZakatPeternakan(getJumlahOrang(), jumlahKambingDanDomba, jumlahSapi,
                NISAB_KAMBING_DOMBA, NISAB_SAPI);
    }
}
