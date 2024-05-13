package com.example.helloworld;

import java.util.ArrayList;

public class HistoryZakat {
    private ArrayList<Zakat> zakats = new ArrayList<>();

    public void addZakat(Zakat zakat) {
        zakats.add(zakat);
        System.out.println("Riwayat zakat berhasil ditambahkan!");
    }

    public void deleteZakat(String nama) {
        zakats.removeIf(zakat -> zakat.getNama().equals(nama));
        System.out.println("Riwayat zakat berhasil dihapus!");
    }

    public boolean displayZakatDetails(String nama) {
        boolean found = false;
        for (Zakat zakat : zakats) {
            if (zakat.getNama().equals(nama)) {
                System.out.println("Nama: " + zakat.getNama());
                System.out.println("Tanggal: " + zakat.getTanggal());

                // Periksa tipe zakat
                if (zakat instanceof ZakatFitrahh) {
                    ZakatFitrahh zakatFitrahh = (ZakatFitrahh) zakat;
                    System.out.println("Jumlah zakat fitrah: Rp. " + zakatFitrahh.hitungZakat());
                } else if (zakat instanceof ZakatPenghasilan) {
                    ZakatPenghasilan zakatPenghasilan = (ZakatPenghasilan) zakat;
                    System.out.println("Jumlah zakat penghasilan: Rp. " + zakatPenghasilan.hitungZakat());
                } else if (zakat instanceof ZakatPertanian) {
                    ZakatPertanian zakatPertanian = (ZakatPertanian) zakat;
                    System.out.println("Jumlah zakat pertanian: " + zakatPertanian.hitungZakat() + " Kg.");
                } else if (zakat instanceof ZakatPeternakan) {
                    ZakatPeternakan zakatPeternakan = (ZakatPeternakan) zakat;
                    System.out.println("Jumlah zakat kambing/domba: " + zakatPeternakan.hitungZakatKambingDomba() + " Ekor");
                    System.out.println("Jumlah zakat sapi: " + zakatPeternakan.hitungZakatSapi() + " Ekor");
                } else if (zakat instanceof ZakatEmasdanPerak) {
                    ZakatEmasdanPerak zakatEmasdanPerak = (ZakatEmasdanPerak) zakat;
                    System.out.println("Jumlah zakat emas: " + zakatEmasdanPerak.hitungZakatEmas() + " gram");
                    System.out.println("Jumlah zakat perak: " + zakatEmasdanPerak.hitungZakatPerak() + " gram");
                }

                found = true;
            }
        }
        if (!found) {
            System.out.println("Riwayat zakat tidak ditemukan!");
        }
        return found;
    }
}