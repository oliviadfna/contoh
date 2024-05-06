package com.example.helloworld;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label titleLabel = new Label("Zakat Calculator");

        // UI components for ZakatFitrahh
        Label fitrahLabel = new Label("Jumlah Orang:");
        TextField fitrahTextField = new TextField();
        Button fitrahButton = new Button("Hitung Zakat Fitrah");
        Label fitrahResultLabel = new Label();

        // UI components for ZakatPenghasilan
        Label bulanLabel = new Label("Penghasilan per Bulan:");
        TextField bulanTextField = new TextField();
        Label lainLabel = new Label("Penghasilan Lain:");
        TextField lainTextField = new TextField();
        Button penghasilanButton = new Button("Hitung Zakat Penghasilan");
        Label penghasilanResultLabel = new Label();

        // UI components for Zakat Emas dan Perak
        Label emasLabelGram = new Label("Jumlah Emas (gram):");
        TextField emasTextField = new TextField();
        Label perakLabelGram = new Label("Jumlah Perak (gram):");
        TextField perakTextField = new TextField();
        Button emasButton = new Button("Hitung Zakat Emas dan Perak");
        Label emasResultLabel = new Label();

        // UI components for Zakat Pertanian
        Label hasilPanenLabel = new Label("Hasil Panen(Kg):");
        TextField hasilPanenTextField = new TextField();
        Button pertanianButton = new Button("Hitung Zakat Pertanian");
        Label pertanianResultLabel = new Label();

        // UI components for Zakat Peternakan
        Label kambingLabel = new Label("Jumlah Kambing/Domba:");
        TextField kambingTextField = new TextField();
        Label sapiLabel = new Label("Jumlah Sapi:");
        TextField sapiTextField = new TextField();
        Button peternakanButton = new Button("Hitung Zakat Peternakan");
        Label peternakanResultLabel = new Label();

        // Button to open History Zakat window
        Button historyButton = new Button("History Zakat");

        // GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // Add components to the GridPane
        gridPane.add(titleLabel, 0, 0, 2, 1);

        // Zakat Fitrah UI
        gridPane.add(fitrahLabel, 0, 1);
        gridPane.add(fitrahTextField, 1, 1);
        gridPane.add(fitrahButton, 0, 2, 2, 1);
        gridPane.add(fitrahResultLabel, 0, 3, 2, 1);

        // Zakat Penghasilan UI
        gridPane.add(bulanLabel, 0, 4);
        gridPane.add(bulanTextField, 1, 4);
        gridPane.add(lainLabel, 0, 5);
        gridPane.add(lainTextField, 1, 5);
        gridPane.add(penghasilanButton, 0, 6, 2, 1);
        gridPane.add(penghasilanResultLabel, 0, 7, 2, 1);

        // Zakat Emas dan Perak UI
        gridPane.add(emasLabelGram, 0, 8);
        gridPane.add(emasTextField, 1, 8);
        gridPane.add(perakLabelGram, 0, 9);
        gridPane.add(perakTextField, 1, 9);
        gridPane.add(emasButton, 0, 10, 2, 1);
        gridPane.add(emasResultLabel, 0, 11, 2, 1);

        // Zakat Pertanian UI
        gridPane.add(hasilPanenLabel, 0, 12);
        gridPane.add(hasilPanenTextField, 1, 12);
        gridPane.add(pertanianButton, 0, 13, 2, 1);
        gridPane.add(pertanianResultLabel, 0, 14, 2, 1);

        // Zakat Peternakan UI
        gridPane.add(kambingLabel, 0, 15);
        gridPane.add(kambingTextField, 1, 15);
        gridPane.add(sapiLabel, 0, 16);
        gridPane.add(sapiTextField, 1, 16);
        gridPane.add(peternakanButton, 0, 17, 2, 1);
        gridPane.add(peternakanResultLabel, 0, 18, 2, 1);

        // Add History Zakat button
        gridPane.add(historyButton, 0, 19, 2, 1);

        // Event handler for History Zakat button
        historyButton.setOnAction(event -> {
            Stage historyStage = new Stage();
            historyStage.setTitle("History Zakat");

            // Create UI components for History Zakat window
            Label nameLabel = new Label("Nama:");
            TextField nameTextField = new TextField();
            Label jenisZakatLabel = new Label("Jenis Zakat:");
            TextField jenisZakatTextField = new TextField();
            Label jumlahZakatLabel = new Label("Jumlah Zakat:");
            TextField jumlahZakatTextField = new TextField();
            Label tanggalLabel = new Label("Tanggal (YYYY-MM-DD):");
            TextField tanggalTextField = new TextField();
            Button saveButton = new Button("Simpan");

            GridPane historyGridPane = new GridPane();
            historyGridPane.setPadding(new Insets(10));
            historyGridPane.setHgap(5);
            historyGridPane.setVgap(5);

            historyGridPane.add(nameLabel, 0, 0);
            historyGridPane.add(nameTextField, 1, 0);
            historyGridPane.add(jenisZakatLabel, 0, 1);
            historyGridPane.add(jenisZakatTextField, 1, 1);
            historyGridPane.add(jumlahZakatLabel, 0, 2);
            historyGridPane.add(jumlahZakatTextField, 1, 2);
            historyGridPane.add(tanggalLabel, 0, 3);
            historyGridPane.add(tanggalTextField, 1, 3);
            historyGridPane.add(saveButton, 0, 4, 2, 1);

            Scene historyScene = new Scene(historyGridPane, 300, 200);
            historyStage.setScene(historyScene);
            historyStage.show();

            // Event handler for save button
            saveButton.setOnAction(saveEvent -> {
                String name = nameTextField.getText();
                String jenisZakat = jenisZakatTextField.getText();
                int jumlahZakat = Integer.parseInt(jumlahZakatTextField.getText());
                String tanggalStr = tanggalTextField.getText();
                // Parse tanggalStr to Date
                Date tanggal = null; // You need to implement parsing of the date string here
                // Create HistoryZakat object and save it
                HistoryZakat historyZakat = new HistoryZakat(name, tanggal, jenisZakat, jumlahZakat);
                // Save the historyZakat object wherever you want (e.g., in a list or database)
                System.out.println("Zakat transaction saved: " + historyZakat);
                historyStage.close();
            });
        });

        // Event handler for Zakat Fitrah button
        fitrahButton.setOnAction(event -> {
            try {
                int jumlahOrang = Integer.parseInt(fitrahTextField.getText());
                ZakatFitrahh zakatFitrahh = new ZakatFitrahh(jumlahOrang);
                int zakatAmount = zakatFitrahh.hitungZakat();
                fitrahResultLabel.setText("Jumlah Zakat Fitrah: " + zakatAmount + " rupiah");
            } catch (NumberFormatException e) {
                fitrahResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Penghasilan button
        penghasilanButton.setOnAction(event -> {
            try {
                double penghasilanPerBulan = Double.parseDouble(bulanTextField.getText());
                double penghasilanLain = Double.parseDouble(lainTextField.getText());
                ZakatPenghasilan zakatPenghasilan = new ZakatPenghasilan(penghasilanPerBulan, penghasilanLain);
                int zakatAmount = zakatPenghasilan.hitungZakat();
                penghasilanResultLabel.setText("Jumlah Zakat Penghasilan: " + zakatAmount + " rupiah");
            } catch (NumberFormatException e) {
                penghasilanResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Emas dan Perak button
        emasButton.setOnAction(event -> {
            try {
                double jumlahEmas = Double.parseDouble(emasTextField.getText());
                double jumlahPerak = Double.parseDouble(perakTextField.getText());
                ZakatEmasdanPerak zakatEmasdanPerak = new ZakatEmasdanPerak( jumlahEmas, jumlahPerak);
                int zakatAmount = zakatEmasdanPerak.hitungZakat();
                emasResultLabel.setText("Jumlah Zakat Emas dan Perak: " + zakatAmount + " rupiah");
            } catch (NumberFormatException e) {
                emasResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Pertanian button
        pertanianButton.setOnAction(event -> {
            try {
                double hasilPanen = Double.parseDouble(hasilPanenTextField.getText());
                ZakatPertanian zakatPertanian = new ZakatPertanian(hasilPanen);
                int zakatAmount = zakatPertanian.hitungZakat();
                pertanianResultLabel.setText("Jumlah Zakat Pertanian: " + zakatAmount + " Kg");
            } catch (NumberFormatException e) {
                pertanianResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Peternakan button
        peternakanButton.setOnAction(event -> {
            try {
                double jumlahKambing = Double.parseDouble(kambingTextField.getText());
                double jumlahSapi = Double.parseDouble(sapiTextField.getText());
                ZakatPeternakan zakatPeternakan = new ZakatPeternakan(jumlahKambing, jumlahSapi);
                int zakatAmount = zakatPeternakan.hitungZakat();
                peternakanResultLabel.setText("Jumlah Zakat Peternakan: " + zakatAmount + " ekor");
            } catch (NumberFormatException e) {
                peternakanResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Create the scene and set it on the stage
        Scene scene = new Scene(gridPane, 400, 750);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Zakat Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}