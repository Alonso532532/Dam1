package Java.Basicos.ejercicios;

import java.util.ArrayList;

public class ej19 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < 10;i++){
            numeros[i] = (int)(Math.random()*22-11);
        }
        System.out.print("|");
        for (int i:numeros){
            if (i >= 0){
                System.out.print(" ");
            }
            System.out.print(i + "|");
        }
        System.out.println();
        int repetidos = 0;
        for (int i = -10; i <= 10;i++){
            int contR = 0;
            for (int j = 0; j < 10;j++){
                if (numeros[j] == i){
                    contR++;
                }
            }
            if (contR > 0){
                System.out.println("El numero " + i + " se repite " + contR + " veces");
                repetidos++;
            }
        }
        System.out.println("Se repiten " + repetidos + " numeros");
    }
}
