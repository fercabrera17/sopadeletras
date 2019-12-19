package com.minsait.sopadeletras;

import java.util.Random;

/*
 * @author Daniel Cruz
 */
public class Tablero {

    char tableroMatriz[][];

    Tablero(int tamanio) {
        tableroMatriz = new char[tamanio][tamanio];
    }

    char[][] colocarHorizontal(String palabra, int posicionRenglonFijo, int posicionColumnaComienzo) {
        if (posicionColumnaComienzo + palabra.length() <= tableroMatriz.length) {
            for (int posicionColumnaRecorrido = posicionColumnaComienzo; posicionColumnaRecorrido < palabra.length() + posicionColumnaComienzo; posicionColumnaRecorrido++) {
                tableroMatriz[posicionRenglonFijo][posicionColumnaRecorrido] = palabra.charAt(posicionColumnaRecorrido-posicionColumnaComienzo);
            }
        } else {
            System.err.println("No se puede colocar la palabra en las coordenadas especificadas");
        }
        return tableroMatriz;
    }
    char[][] colocarVertical(String palabra, int posicionColumnaFija, int posicionRenglonComienzo) {
        if (posicionRenglonComienzo + palabra.length() <= tableroMatriz.length) {
            for (int posicionRenglonRecorrido = posicionRenglonComienzo; posicionRenglonRecorrido < palabra.length() + posicionRenglonComienzo; posicionRenglonRecorrido++) {
                tableroMatriz[posicionRenglonRecorrido][posicionColumnaFija] = palabra.charAt(posicionRenglonRecorrido-posicionRenglonComienzo);
            }
        } else {
            System.err.println("No se puede colocar la palabra en las coordenadas especificadas");
        }
        return tableroMatriz;
    }
    
    void imprimeTablero() {
        for (int i = 0; i < tableroMatriz.length; i++) {
            for (int j = 0; j < tableroMatriz.length; j++) {
                System.out.print(tableroMatriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void inicializarTablero() {
        for (int i = 0; i < tableroMatriz.length; i++) {
            for (int j = 0; j < tableroMatriz.length; j++) {
                tableroMatriz[i][j] = '-';
            }
        }
    }

    
    
    
    
    char[][] getTablero() {
        return tableroMatriz;
    }

    boolean insertarCaracter(char letra, int renglon, int columna) {
        tableroMatriz[renglon][columna] = letra;
        return true;
    }

    char[][] rellenaVacios() {
        for (int i = 0; i < tableroMatriz.length; i++) {
            for (int j = 0; j < tableroMatriz.length; j++) {
                Random valorRandom = new Random();
                int valorLetra = (valorRandom.nextInt(25) + 97);
                if(tableroMatriz[i][j]=='-'){
                    tableroMatriz[i][j] = (char) (valorLetra);
                }                
               // System.out.print(tableroMatriz[i][j] + "\t");
            }
            //System.out.println();
        }
        return this.tableroMatriz;
    }
}
