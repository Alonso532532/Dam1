package Java.Basicos.ejercicios.Practica2;

import java.util.ArrayList;
import java.util.Arrays;

public class MasCosasIncluso {
    public static void main(String[] args) {
        ArrayList<Integer> uno = new ArrayList<>();
        ArrayList<Integer> dos = new ArrayList<>();
        ArrayList<Integer> tres = new ArrayList<>();
        ArrayList[] numeros = {uno, dos, tres};
        for (ArrayList i : numeros) {
            for (int j = 0; j < 2; j++) {
                i.add((int)(Math.random()*2+1));
            }
        }
        for (ArrayList i : numeros){
            System.out.print(" - " + i.toString());
        }
        System.out.println(" - ");
        for (int i = 0; i < numeros.length; i++){
            for (int j = 0; j < numeros.length; j++) {
                if (i != j){
                    if (numeros[i].equals(numeros[j])){
                        System.out.println("El array " + (i+1) + " es igual a el array " + (j+1));
                    }
                }
            }
        }
        uno  = new ArrayList<>(Arrays.asList(1,2));
        dos  = new ArrayList<>(Arrays.asList(1,2));
        System.out.println(uno.equals(dos));
        int[] cosa1 = {1,2,3};
        int[] cosa2 = Arrays.copyOfRange(cosa1, 0 , 2);
        cosa2[1] = 3;
        System.out.println(Arrays.toString(cosa1));
        System.out.println(Arrays.toString(cosa2));

    }
}
