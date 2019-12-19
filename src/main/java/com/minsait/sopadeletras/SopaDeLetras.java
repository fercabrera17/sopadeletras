package com.minsait.sopadeletras;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SopaDeLetras {

    public List<String> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(List<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    private List<String> listaPalabras;

    List<String> generarPalabras(int numeroPalabras, int tamanioTablero) throws FileNotFoundException, IOException {

        List<String> listaCompleta = new ArrayList<>();
        List<String> listaAleatoria = new ArrayList<>();

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(new FileInputStream("palabras.txt"), "UTF-8"));
        String sCadena;
        while ((sCadena = bf.readLine()) != null) {
            listaCompleta.add(sCadena);
        }

        for (int i = 0; i < numeroPalabras; i++) {
            int valorEntero = (int) Math.floor(Math.random() * listaCompleta.size());
            if (listaCompleta.get(valorEntero).length() <= tamanioTablero) {
                listaAleatoria.add(listaCompleta.get(valorEntero));
            } else {
                i--;
            }
        }

        return listaAleatoria;
    }

}
