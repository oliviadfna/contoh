package com.example.helloworld;

import java.util.ArrayList;

public class HistoryZakat {
    private ArrayList<Zakat> zakats = new ArrayList<>();

    public void addZakat(Zakat zakat) {
        zakats.add(zakat);
        System.out.println("Zakat added to history successfully!");
    }

    public void deleteZakat(String nama) {
        zakats.removeIf(zakat -> zakat.getNama().equals(nama));
        System.out.println("Contact deleted successfully!");
    }

    public boolean displayZakatDetails(String nama) {
        boolean found = false;
        for (Zakat zakat : zakats) {
            if (zakat.getNama().equals(nama)) {
                System.out.println("Nama: " + zakat.getNama());
                System.out.println("Tanggal: " + zakat.getTanggal());
                System.out.println("Jumlah zakat: " + zakat.hitungZakat());
                found = true;
            }
        }
        if (!found) {
            System.out.println("history zakat tidak ditemukan!");
        }
        return found;
    }
}