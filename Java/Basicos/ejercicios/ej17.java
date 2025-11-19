package Java.Basicos.ejercicios;

import java.util.ArrayList;

public class ej17 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < Math.random()*10+10;i++){
            numeros.add((int)(Math.random()*22-11));
        }
        System.out.print("|");
        int contp = 0;
        for (int i:numeros){
            if (i >= 0){
                contp++;
                System.out.print(" ");
            }
            System.out.print(i + "|");
        }
        System.out.println("\nHay " + contp + " positivos y " + (numeros.size()-contp) + " negatvos\nLo transformo");
        System.out.print("|");
        for (int i = 0; i < numeros.size(); i++){
            if (numeros.get(i) < 0){
                numeros.set(i,Math.abs(numeros.get(i)));
            }
        }
        for (int i:numeros){
            if (i >= 0) {
                contp++;
                System.out.print(" ");
            }
            System.out.print(i + "|");
        }
    }
}
