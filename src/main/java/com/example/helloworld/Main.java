package com.example.helloworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        Label penghasilanLabel = new Label("Jumlah Orang:");
        TextField penghasilanTextField = new TextField();
        Label bulanLabel = new Label("Penghasilan per Bulan:");
        TextField bulanTextField = new TextField();
        Label lainLabel = new Label("Penghasilan Lain:");
        TextField lainTextField = new TextField();
        Button penghasilanButton = new Button("Hitung Zakat Penghasilan");
        Label penghasilanResultLabel = new Label();

        // UI components for ZakatEmasdanPerak
        Label emasLabel = new Label("Jumlah Orang:");
        TextField emasOrangTextField = new TextField();
        Label emasLabelGram = new Label("Jumlah Emas (gram):");
        TextField emasTextField = new TextField();
        Label perakLabelGram = new Label("Jumlah Perak (gram):");
        TextField perakTextField = new TextField();
        Button emasButton = new Button("Hitung Zakat Emas dan Perak");
        Label emasResultLabel = new Label();

        // UI components for ZakatPertanian
        Label pertanianLabel = new Label("Jumlah Orang:");
        TextField pertanianOrangTextField = new TextField();
        Label hasilPanenLabel = new Label("Hasil Panen(Kg):");
        TextField hasilPanenTextField = new TextField();
        Button pertanianButton = new Button("Hitung Zakat Pertanian");
        Label pertanianResultLabel = new Label();

        // UI components for ZakatPeternakan
        Label peternakanLabel = new Label("Jumlah Orang:");
        TextField peternakanOrangTextField = new TextField();
        Label kambingLabel = new Label("Jumlah Kambing/Domba:");
        TextField kambingTextField = new TextField();
        Label sapiLabel = new Label("Jumlah Sapi:");
        TextField sapiTextField = new TextField();
        Button peternakanButton = new Button("Hitung Zakat Peternakan");
        Label peternakanResultLabel = new Label();

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
        gridPane.add(penghasilanLabel, 0, 4);
        gridPane.add(penghasilanTextField, 1, 4);
        gridPane.add(bulanLabel, 0, 5);
        gridPane.add(bulanTextField, 1, 5);
        gridPane.add(lainLabel, 0, 6);
        gridPane.add(lainTextField, 1, 6);
        gridPane.add(penghasilanButton, 0, 7, 2, 1);
        gridPane.add(penghasilanResultLabel, 0, 8, 2, 1);

        // Zakat Emas dan Perak UI
        gridPane.add(emasLabel, 0, 9);
        gridPane.add(emasOrangTextField, 1, 9);
        gridPane.add(emasLabelGram, 0, 10);
        gridPane.add(emasTextField, 1, 10);
        gridPane.add(perakLabelGram, 0, 11);
        gridPane.add(perakTextField, 1, 11);
        gridPane.add(emasButton, 0, 12, 2, 1);
        gridPane.add(emasResultLabel, 0, 13, 2, 1);

        // Zakat Pertanian UI
        gridPane.add(pertanianLabel, 0, 14);
        gridPane.add(pertanianOrangTextField, 1, 14);
        gridPane.add(hasilPanenLabel, 0, 15);
        gridPane.add(hasilPanenTextField, 1, 15);
        gridPane.add(pertanianButton, 0, 16, 2, 1);
        gridPane.add(pertanianResultLabel, 0, 17, 2, 1);

        // Zakat Peternakan UI
        gridPane.add(peternakanLabel, 0, 18);
        gridPane.add(peternakanOrangTextField, 1, 18);
        gridPane.add(kambingLabel, 0, 19);
        gridPane.add(kambingTextField, 1, 19);
        gridPane.add(sapiLabel, 0, 20);
        gridPane.add(sapiTextField, 1, 20);
        gridPane.add(peternakanButton, 0, 21, 2, 1);
        gridPane.add(peternakanResultLabel, 0, 22, 2, 1);

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
                int jumlahOrang = Integer.parseInt(penghasilanTextField.getText());
                double penghasilanPerBulan = Double.parseDouble(bulanTextField.getText());
                double penghasilanLain = Double.parseDouble(lainTextField.getText());
                ZakatPenghasilan zakatPenghasilan = new ZakatPenghasilan(jumlahOrang, penghasilanPerBulan, penghasilanLain);
                int zakatAmount = zakatPenghasilan.hitungZakat();
                penghasilanResultLabel.setText("Jumlah Zakat Penghasilan: " + zakatAmount + " rupiah");
            } catch (NumberFormatException e) {
                penghasilanResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Emas dan Perak button
        emasButton.setOnAction(event -> {
            try {
                int jumlahOrang = Integer.parseInt(emasOrangTextField.getText());
                double jumlahEmas = Double.parseDouble(emasTextField.getText());
                double jumlahPerak = Double.parseDouble(perakTextField.getText());
                ZakatEmasdanPerak zakatEmasdanPerak = new ZakatEmasdanPerak(jumlahOrang, jumlahEmas, jumlahPerak);
                int zakatAmount = zakatEmasdanPerak.hitungZakat();
                emasResultLabel.setText("Jumlah Zakat Emas dan Perak: " + zakatAmount + " rupiah");
            } catch (NumberFormatException e) {
                emasResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Pertanian button
        pertanianButton.setOnAction(event -> {
            try {
                int jumlahOrang = Integer.parseInt(pertanianOrangTextField.getText());
                double hasilPanen  = Double.parseDouble(hasilPanenTextField.getText());
                ZakatPertanian zakatPertanian = new ZakatPertanian(jumlahOrang, hasilPanen);
                int zakatAmount = zakatPertanian.hitungZakat();
                pertanianResultLabel.setText("Jumlah Zakat Pertanian: " + zakatAmount + " Kg");
            } catch (NumberFormatException e) {
                pertanianResultLabel.setText("Masukkan data yang valid!");
            }
        });

        // Event handler for Zakat Peternakan button
        peternakanButton.setOnAction(event -> {
            try {
                int jumlahOrang = Integer.parseInt(peternakanOrangTextField.getText());
                double jumlahKambing = Double.parseDouble(kambingTextField.getText());
                double jumlahSapi = Double.parseDouble(sapiTextField.getText());
                ZakatPeternakan zakatPeternakan = new ZakatPeternakan(jumlahOrang, jumlahKambing, jumlahSapi);
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