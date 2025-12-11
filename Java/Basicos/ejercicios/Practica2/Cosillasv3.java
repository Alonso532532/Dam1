package Java.Basicos.ejercicios.Practica2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Cosillasv3 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(10);
        System.out.print("-");
        for (int i = 0; i < 5; i++){
            numeros.add((int) (Math.random()*5+1))  ;
            System.out.print(numeros.get(i)+"-");
        }
        Collections.sort(numeros);
        System.out.print("\n-");
        for (int i : numeros){
            System.out.print(i+"-");
        }
        System.out.println("\nEl numero a sido encontrado en la pos: "+Collections.binarySearch(numeros, 2)+" y su maximo es: "+Collections.max(numeros));
        String num1 = "2.5";
        Double num2 = Double.parseDouble(num1);
        int num3 = num2.intValue();
        System.out.println(num3);

    }
}
