package com.minsait.sopadeletras;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    int tamanioTablero = 7;
    int numeroPalabras = 6;
    int contadorPalabrasAgregadas = 0;
    List<String> palabrasIngresadas = new ArrayList<String>();

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private RadioButton radioButtonFacil;
    @FXML
    private RadioButton radioButtonMedio;
    @FXML
    private RadioButton radioButtonDificil;
    @FXML
    private TextField textFieldIngresarPalabra;
    @FXML
    private Button buttonGuardarPalabra;
    @FXML
    private ComboBox<Integer> comboBoxTamanioTablero;
    @FXML
    private ComboBox<Integer> comboBoxNumeroPalabras;
    @FXML
    private CheckBox checkBoxManual;
    @FXML
    private CheckBox checkBoxMixta;
    @FXML
    private CheckBox checkBoxAleatorio;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        tamanioTablero = comboBoxTamanioTablero.getValue();
        numeroPalabras = comboBoxNumeroPalabras.getValue();
        Tablero tablero = new Tablero(tamanioTablero);
        SopaDeLetras sopaDeLetras = new SopaDeLetras();

        if (devolverModoPalabras().equals("al")) {
            palabrasIngresadas = sopaDeLetras.generarPalabras(numeroPalabras, tablero.getTablero().length);

        }

        //palabrasIngresadas.stream().forEach(System.out::println);
        tablero.inicializarTablero();
        tablero.imprimeTablero();
        System.out.println("Palabra a colocar: " +palabrasIngresadas.get(0)+"\n");
        tablero.colocarHorizontal(palabrasIngresadas.get(0), 1, 1);//(Palabra, renglon, columna)
        System.out.println("Palabra a colocar: " +palabrasIngresadas.get(1)+"\n");
        tablero.colocarVertical(palabrasIngresadas.get(1), 0, 0);//(Palabra, renglon, columna)
        tablero.imprimeTablero();
        System.out.println("");

        tablero.rellenaVacios();
        System.out.println();
        tablero.imprimeTablero();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxTamanioTablero.getItems().addAll(7, 8, 9);
        comboBoxNumeroPalabras.getItems().addAll(6, 7, 8);
        radioButtonFacil.setSelected(true);
        checkBoxAleatorio.setSelected(true);
        textFieldIngresarPalabra.setDisable(true);
        buttonGuardarPalabra.setDisable(true);
    }

    String devolverDificultad() {
        if (radioButtonFacil.isSelected()) {
            comboBoxTamanioTablero.getItems().clear();
            comboBoxTamanioTablero.getItems().addAll(
                    6, 7, 8
            );
            comboBoxNumeroPalabras.getItems().clear();
            comboBoxNumeroPalabras.getItems().addAll(
                    7, 8, 9
            );
            return "f";
        }
        if (radioButtonMedio.isSelected()) {
            comboBoxTamanioTablero.getItems().clear();
            comboBoxTamanioTablero.getItems().addAll(
                    9, 10, 11
            );
            comboBoxNumeroPalabras.getItems().clear();
            comboBoxNumeroPalabras.getItems().addAll(
                    10, 11, 12
            );

            return "m";
        }
        if (radioButtonDificil.isSelected()) {
            comboBoxTamanioTablero.getItems().clear();
            comboBoxTamanioTablero.getItems().addAll(
                    12, 13, 14
            );
            comboBoxNumeroPalabras.getItems().clear();
            comboBoxNumeroPalabras.getItems().addAll(
                    13, 14, 15
            );
            return "d";
        }
        return null;
    }

    String devolverModoPalabras() {
        if (checkBoxManual.isSelected()) {
            return "ma";
        }
        if (checkBoxMixta.isSelected()) {
            return "mi";
        }
        if (checkBoxAleatorio.isSelected()) {
            return "al";
        }
        return null;
    }

    @FXML
    private void radioButtonFacilEvent(ActionEvent event) {
        if (devolverDificultad() == null) {
            radioButtonFacil.setSelected(true);
        }
        if (radioButtonMedio.isSelected()) {
            radioButtonMedio.setSelected(false);
        }
        if (radioButtonDificil.isSelected()) {
            radioButtonDificil.setSelected(false);
        }
    }

    @FXML
    private void radioButtonMedioEvent(ActionEvent event) {
        if (devolverDificultad() == null) {
            radioButtonMedio.setSelected(true);
        }
        if (radioButtonFacil.isSelected()) {
            radioButtonFacil.setSelected(false);
        }
        if (radioButtonDificil.isSelected()) {
            radioButtonDificil.setSelected(false);
        }
        devolverDificultad();
    }

    @FXML
    private void radioButtonDificilEvent(ActionEvent event) {
        if (devolverDificultad() == null) {
            radioButtonDificil.setSelected(true);
        }
        if (radioButtonMedio.isSelected()) {
            radioButtonMedio.setSelected(false);
        }
        if (radioButtonFacil.isSelected()) {
            radioButtonFacil.setSelected(false);
        }
        devolverDificultad();
    }

    @FXML
    private void checkBoxManualEvent(ActionEvent event) {
        if (devolverModoPalabras() == null) {
            checkBoxManual.setSelected(true);
        }
        textFieldIngresarPalabra.setDisable(false);
        buttonGuardarPalabra.setDisable(false);
        if (checkBoxMixta.isSelected()) {
            checkBoxMixta.setSelected(false);
        }
        if (checkBoxAleatorio.isSelected()) {
            checkBoxAleatorio.setSelected(false);
        }
    }

    @FXML
    private void checkBoxMixtaEvent(ActionEvent event) {
        if (devolverModoPalabras() == null) {
            checkBoxMixta.setSelected(true);
        }
        textFieldIngresarPalabra.setDisable(false);
        buttonGuardarPalabra.setDisable(false);
        if (checkBoxManual.isSelected()) {
            checkBoxManual.setSelected(false);
        }
        if (checkBoxAleatorio.isSelected()) {
            checkBoxAleatorio.setSelected(false);
        }

    }

    @FXML
    private void checkBoxAleatorioEvent(ActionEvent event) {
        if (devolverModoPalabras() == null) {
            checkBoxAleatorio.setSelected(true);
        }
        textFieldIngresarPalabra.setDisable(true);
        buttonGuardarPalabra.setDisable(true);
        if (checkBoxMixta.isSelected()) {
            checkBoxMixta.setSelected(false);
        }
        if (checkBoxManual.isSelected()) {
            checkBoxManual.setSelected(false);
        }
    }

    @FXML
    private void buttonGuardarPalabraEvent(ActionEvent event) {
        if (contadorPalabrasAgregadas <= numeroPalabras) {
            label.setText("Palabra añadida");
            if (!textFieldIngresarPalabra.getText().trim().equals("")) {
                palabrasIngresadas.add(textFieldIngresarPalabra.getText());
            } else {
                label.setText("Ingrese una palabra váldia");
            }
        } else {
            label.setText("Se han agregado todas las palabras");
        }

    }

}
