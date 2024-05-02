package com.example.helloworld;

class PerhitunganZakat {

    public static int hitungZakatFitrah(int jumlahOrang, double beratBeras, double hargaBerasPerKg) {
        double totalJumlahBeras = jumlahOrang * beratBeras;
        double totalJumlahUang = totalJumlahBeras * hargaBerasPerKg;
        return (int) totalJumlahUang;
    }

    public static int hitungZakatPenghasilan(int jumlahOrang, double penghasilanPerBulan, double penghasilanLain,
                                             double NISAB_PER_BULAN, double NISAB_PER_TAHUN) {
        double totalPenghasilanPerBulan = penghasilanPerBulan + penghasilanLain;
        if (totalPenghasilanPerBulan > NISAB_PER_BULAN) {
            return (int) (0.025 * totalPenghasilanPerBulan);
        } else {
            return 0;
        }
    }

    public static int hitungZakatEmasDanPerak(int jumlahOrang, double jumlahEmas_Gram, double jumlahPerak_Gram,
                                              double NISAB_PER_TAHUNN) {
        double totalNilaiEmasPerak = (jumlahEmas_Gram * 1300000) + (jumlahPerak_Gram * 14000);
        if (totalNilaiEmasPerak > NISAB_PER_TAHUNN) {
            return (int) (0.025 * totalNilaiEmasPerak);
        } else {
            return 0;
        }
    }

    public static int hitungZakatPertanian(int jumlahOrang, double hasilPanen, double NISAB_PER_TAHUNNN) {
        if (hasilPanen > NISAB_PER_TAHUNNN) {
            return (int) (0.05 * hasilPanen);
        }else {
            return 0;
        }
    }

    public static int hitungZakatPeternakan(int jumlahOrang, double jumlahKambingDanDomba, double jumlahSapi,
                                            double NISAB_KAMBING_DOMBA, double NISAB_SAPI) {
        int zakatKambingDanDomba = 0;
        int zakatSapi = 0;

        // Perhitungan zakat untuk kambing dan domba
        if (jumlahKambingDanDomba > NISAB_KAMBING_DOMBA) {
            zakatKambingDanDomba = (int) (jumlahKambingDanDomba / NISAB_KAMBING_DOMBA);
        }

        // Perhitungan zakat untuk sapi
        if (jumlahSapi > NISAB_SAPI) {
            zakatSapi = (int) (jumlahSapi / NISAB_SAPI);
        }

        return zakatKambingDanDomba + zakatSapi;
    }
}

