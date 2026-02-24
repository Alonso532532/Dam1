package Java.Medio.Ejercicios.Tema11;

import java.util.*;

public class Ej8 {
    public static void main(String[] args) {
        SortedMap<Character, Integer> cars = new TreeMap<>();
        for (char i: "Hola Buenas HECPROLLL".toCharArray()){
            if (Character.isLetter(i)){
                cars.put(i, cars.get(i) != null ? cars.get(i)+1 : 1);
            }
        }
        for (Character i: cars.keySet()){

            System.out.println("La letra " + i + " aparece " + cars.get(i) + " veces ");

        }
    }
}
