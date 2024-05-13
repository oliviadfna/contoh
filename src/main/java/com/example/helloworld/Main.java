package com.example.helloworld;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoryZakat history = new HistoryZakat();

        System.out.println("Selamat datang di Program Zakat Calculator!");

        boolean continueCalculating;

        do {
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
                    System.out.print("Pilihan Anda [1]/[2]/[3]: ");
                    choice = scanner.nextInt();
                    validChoice = true;
                } catch (InputMismatchException e) {
                    System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                    scanner.nextLine(); // Membersihkan buffer
                }
            }

            if (choice == 1 || choice == 2) {
                // Meminta input untuk zakat fitrah atau maal
                System.out.print("Masukkan nama anda: ");
                scanner.nextLine(); // Membersihkan buffer
                String nama = scanner.nextLine();

                System.out.println("Masukkan tanggal [DD/MM/YYYY]: ");
                Date tanggal = inputDate();

                if (choice == 1) {
                    int jumlahOrang = inputPositiveInteger("Masukkan jumlah orang dalam keluarga: ");
                    ZakatFitrahh zakatFitrah = new ZakatFitrahh(nama, tanggal, jumlahOrang);
                    int zakat = zakatFitrah.hitungZakat();
                    System.out.println("Jumlah zakat fitrah yang harus Anda bayar: Rp. " + zakat);
                    history.addZakat(zakatFitrah);
                } else if (choice == 2) {
                    System.out.println("Pilih jenis zakat maal yang ingin dihitung:");
                    System.out.println("1. Zakat Penghasilan");
                    System.out.println("2. Zakat Pertanian");
                    System.out.println("3. Zakat Peternakan");
                    System.out.println("4. Zakat Emas dan Perak");
                    int maalChoice = inputPositiveInteger("Pilihan Anda [1]/[2]/[3]/[4]: ");
                    double jumlah = 0;

                    switch (maalChoice) {
                        case 1:
                            double penghasilanPerBulan = inputPositiveDouble("Masukkan penghasilan per bulan: Rp. ");
                            double penghasilanLain = inputPositiveDouble("Masukkan penghasilan lain (jika ada): Rp. ");
                            ZakatPenghasilan zakatPenghasilan = new ZakatPenghasilan(nama, tanggal, penghasilanPerBulan, penghasilanLain);
                            jumlah = zakatPenghasilan.hitungZakat();
                            System.out.println("Jumlah zakat penghasilan yang harus Anda bayar: Rp. " + jumlah);
                            history.addZakat(zakatPenghasilan);
                            break;
                        case 2:
                            double hasilPanenPertanian = inputPositiveDouble("Masukkan hasil panen (Kg): ");
                            ZakatPertanian zakatPertanian = new ZakatPertanian(nama, tanggal, hasilPanenPertanian);
                            jumlah = zakatPertanian.hitungZakat();
                            System.out.println("Jumlah zakat pertanian yang harus Anda bayar: " + jumlah + " Kg");
                            history.addZakat(zakatPertanian);
                            break;
                        case 3:
                            double jumlahKambingDanDomba = inputPositiveDouble("Masukkan jumlah kambing/domba (ekor): ");
                            double jumlahSapi = inputPositiveDouble("Masukkan jumlah sapi (ekor): ");

                            // Membuat objek ZakatPeternakan dan menghitung zakat
                            ZakatPeternakan zakatPeternakan = new ZakatPeternakan(nama, tanggal, jumlahKambingDanDomba, jumlahSapi);
                            int zakatKambingDanDombaResult = zakatPeternakan.hitungZakatKambingDomba();
                            int zakatSapiResult = zakatPeternakan.hitungZakatSapi();
                            System.out.println("Jumlah zakat peternakan kambing/domba yang harus Anda bayar: " + zakatKambingDanDombaResult + " Ekor");
                            System.out.println("Jumlah zakat peternakan sapi yang harus Anda bayar: " + zakatSapiResult + " Ekor");

                            // Menyimpan riwayat zakat ke dalam HistoryZakat
                            history.addZakat(zakatPeternakan);

                            break;
                        case 4:
                            double jumlahEmas_Gram = inputPositiveDouble("Masukkan Jumlah Emas (gram): ");
                            double jumlahPerak_Gram = inputPositiveDouble("Masukkan Jumlah Perak (gram): ");

                            ZakatEmasdanPerak zakatEmasdanPerak = new ZakatEmasdanPerak(nama, tanggal, jumlahEmas_Gram, jumlahPerak_Gram);
                            int zakatEmasResult = zakatEmasdanPerak.hitungZakatEmas();
                            int zakatPerakResult = zakatEmasdanPerak.hitungZakatPerak();
                            System.out.println("Jumlah zakat emas yang harus Anda bayar: " + zakatEmasResult + " gram");
                            System.out.println("Jumlah zakat perak yang harus Anda bayar: " + zakatPerakResult + " gram");

                            // Menyimpan riwayat zakat ke dalam HistoryZakat
                            history.addZakat(zakatEmasdanPerak);
                            break;
                        default:
                            System.out.println("Pilihan tidak valid!");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Menu Riwayat Zakat:");
                System.out.println("1. Lihat Riwayat Zakat");
                System.out.println("2. Hapus Riwayat Zakat");

                int historyChoice = 0;
                boolean validHistoryChoice = false;

                while (!validHistoryChoice) {
                    try {
                        System.out.print("Pilihan Anda [1]/[2]: ");
                        historyChoice = scanner.nextInt();
                        validHistoryChoice = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Maaf, data yang dimasukkan salah, mohon periksa kembali!");
                        scanner.nextLine(); // Membersihkan buffer
                    }
                }

                // Membersihkan buffer
                scanner.nextLine();

                switch (historyChoice) {
                    case 1:
                        // View History
                        System.out.print("Masukkan nama untuk melihat riwayat zakat: ");
                        String viewName = scanner.nextLine();
                        history.displayZakatDetails(viewName);
                        break;
                    case 2:
                        // Delete History
                        System.out.print("Masukkan nama untuk menghapus riwayat zakat: ");
                        String deleteName = scanner.nextLine();
                        history.deleteZakat(deleteName);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                System.out.println("Pilihan tidak valid!");
            }


            // Meminta input dari pengguna apakah ingin melakukan perhitungan lagi
            System.out.print("Apakah Anda ingin melakukan perhitungan zakat lagi? (y/n): ");
            char continueChar = scanner.next().charAt(0);
            continueCalculating = (continueChar == 'y' || continueChar == 'Y');
        } while (continueCalculating);

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