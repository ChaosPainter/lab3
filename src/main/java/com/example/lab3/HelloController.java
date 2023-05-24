package com.example.lab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML private TableColumn kol_id;
    @FXML private TableColumn kol_imie;
    @FXML private TableColumn kol_nazwisko;
    @FXML private TableView tab;
    @FXML private TextField inNazwisko;
    @FXML private TextField inImie;
    @FXML private Button buttonDodajOsoba;

    @FXML public void initialize() {

        kol_id.setCellValueFactory( new PropertyValueFactory<>("id"));
        kol_imie.setCellValueFactory( new PropertyValueFactory<>("imie"));
        kol_nazwisko.setCellValueFactory( new PropertyValueFactory<>("nazwisko"));


        ObservableList<Osoba> lista=FXCollections.observableArrayList();

        lista.add(new Osoba("Adam", "Mickiewicz"));
        lista.add(new Osoba("Juliusz", "Słowacki"));
        lista.add(new Osoba("Jakub", "Roman"));

        //dodaj elementy listy
        tab.getItems().addAll(lista);
    }

    @FXML
    private void OsobaDodaj(){
        String firstName = inImie.getText();
        String lastName = inNazwisko.getText();
        if(firstName.length() < 3 || lastName.length() < 3)
            return;

        tab.getItems().add(new Osoba(firstName, lastName));

        inImie.setText("");
        inNazwisko.setText("");

    }


}