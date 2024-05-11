package com.example.helloworld;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Program Zakat Calculator!");

        // Meminta input dari pengguna untuk memilih jenis zakat
        System.out.println("Pilih jenis zakat yang ingin dihitung:");
        System.out.println("1. Zakat Fitrah");
        System.out.println("2. Zakat Maal");
        System.out.println("3. Riwayat Zakat");

        int choice = 0;
        boolean validChoice = false;

        // Melakukan loop hingga pilihan yang valid dimasukkan
        while (!validChoice) {
            try {
                System.out.print("Pilihan Anda [1]/[2]: ");
                choice = scanner.nextInt();
                validChoice = true;
            } catch (InputMismatchException e) {
                System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                scanner.nextLine(); // Membersihkan buffer
            }
        }

        if (choice == 1) {
            // Meminta input untuk zakat fitrah
            System.out.print("Masukkan nama anda: ");
            scanner.nextLine(); // Membersihkan buffer
            String nama = scanner.nextLine();

            System.out.println("Masukkan tanggal [DD/MM/YYYY]: ");
            Date tanggal = inputDate();

            int jumlahOrang = inputPositiveInteger("Masukkan jumlah orang dalam keluarga: ");

            // Membuat objek ZakatFitrahh dan menghitung zakat
            ZakatFitrahh zakatFitrah = new ZakatFitrahh(nama, tanggal, jumlahOrang);
            int zakat = zakatFitrah.hitungZakat();

            System.out.println("Jumlah zakat fitrah yang harus Anda bayar: Rp. " + zakat);
        } else if (choice == 2) {
            // Meminta input untuk zakat maal
            System.out.println("Pilih jenis zakat maal yang ingin dihitung:");
            System.out.println("1. Zakat Penghasilan");
            System.out.println("2. Zakat Pertanian");
            System.out.println("3. Zakat Peternakan");
            System.out.println("4. Zakat Emas dan Perak");

            int maalChoice = inputPositiveInteger("Pilihan Anda [1]/[2]/[3]/[4]: ");

            System.out.println("Masukkan nama Anda: ");
            scanner.nextLine(); // Membersihkan buffer
            String nama = scanner.nextLine();

            System.out.println("Masukkan tanggal [DD/MM/YYYY]: ");
            Date tanggal = inputDate();

            switch (maalChoice) {
                case 1:
                    double penghasilanPerBulan = inputPositiveDouble("Masukkan penghasilan per bulan: Rp. ");
                    double penghasilanLain = inputPositiveDouble("Masukkan penghasilan lain (jika ada): Rp. ");

                    // Membuat objek ZakatPenghasilan dan menghitung zakat
                    ZakatPenghasilan zakatPenghasilan = new ZakatPenghasilan(nama, tanggal, penghasilanPerBulan, penghasilanLain);
                    int zakatPenghasilanResult = zakatPenghasilan.hitungZakat();

                    System.out.println("Jumlah zakat penghasilan yang harus Anda bayar: Rp. " + zakatPenghasilanResult);
                    break;
                case 2:
                    double hasilPanenPertanian = inputPositiveDouble("Masukkan hasil panen (Kg): ");

                    // Membuat objek ZakatPertanian dan menghitung zakat
                    ZakatPertanian zakatPertanian = new ZakatPertanian(nama, tanggal, hasilPanenPertanian);
                    int zakatPertanianResult = zakatPertanian.hitungZakat();

                    System.out.println("Jumlah zakat pertanian yang harus Anda bayar: " + zakatPertanianResult + " Kg");
                    break;
                case 3:
                    double jumlahKambingDanDomba = inputPositiveDouble("Masukkan jumlah kambing/domba (ekor): ");
                    double jumlahSapi = inputPositiveDouble("Masukkan jumlah sapi (ekor): ");

                    // Membuat objek ZakatPeternakan dan menghitung zakat
                    ZakatPeternakan zakatPeternakan = new ZakatPeternakan(nama, tanggal, jumlahKambingDanDomba, jumlahSapi);
                    int zakatPeternakanResult = zakatPeternakan.hitungZakat();

                    System.out.println("Jumlah zakat peternakan yang harus Anda bayar: " + zakatPeternakanResult + " Ekor");
                    break;
                case 4:
                    double jumlahEmas_Gram = inputPositiveDouble("Masukkan Jumlah Emas (gram): ");
                    double jumlahPerak_Gram = inputPositiveDouble("Masukkan Jumlah Perak (gram): ");

                    ZakatEmasdanPerak zakatEmasdanPerak = new ZakatEmasdanPerak(nama, tanggal, jumlahEmas_Gram, jumlahPerak_Gram);
                    int zakatEmasdanPerakResult = zakatEmasdanPerak.hitungZakat();

                    System.out.println("Jumlah zakat emas dan perak yang harus Anda bayar: " + zakatEmasdanPerakResult + " Gram");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }

    // Method untuk meminta input tanggal dengan error handling
    private static Date inputDate() {
        Scanner scanner = new Scanner(System.in);
        Date tanggal = null;
        boolean inputValid = false;

        // Melakukan loop hingga input valid
        while (!inputValid) {
            try {
                String tanggalInput = scanner.nextLine();
                tanggal = parseDate(tanggalInput);
                inputValid = true;
            } catch (Exception e) {
                System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
            }
        }
        return tanggal;
    }

    // Metode untuk mengonversi String menjadi objek Date
    private static Date parseDate(String dateString) {
        String[] parts = dateString.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Mengurangi 1 karena bulan dimulai dari 0 di Java Date
        int year = Integer.parseInt(parts[2]) - 1900; // Mengurangi 1900 karena Java Date dimulai dari tahun 1900
        return new Date(year, month, day);
    }

    // Method untuk meminta input angka bulat positif dengan error handling
    private static int inputPositiveInteger(String message) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean inputValid = false;

        // Melakukan loop hingga input valid
        while (!inputValid) {
            try {
                System.out.print(message);
                number = scanner.nextInt();

                // Cek apakah angka positif
                if (number < 0) {
                    System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                } else {
                    inputValid = true; // Keluar dari loop jika input valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                scanner.nextLine(); // Membersihkan buffer
            }
        }
        return number;
    }

    // Method untuk meminta input angka positif dengan error handling
    private static double inputPositiveDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        boolean inputValid = false;

        // Melakukan loop hingga input valid
        while (!inputValid) {
            try {
                System.out.print(message);
                number = scanner.nextDouble();

                // Cek apakah angka positif
                if (number < 0) {
                    System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                } else {
                    inputValid = true; // Keluar dari loop jika input valid
                }
            } catch (InputMismatchException e) {
                System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                scanner.nextLine(); // Membersihkan buffer
            }
        }
        return number;
    }
}
