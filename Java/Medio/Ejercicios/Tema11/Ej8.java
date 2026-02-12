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
        for (int i = 0; i < cars.size(); i++){
            char eliminar = cars.firstKey();
            System.out.println("La letra " + eliminar + " aparece " + cars.get(eliminar) + " veces ");
            cars.remove(eliminar);
        }
    }
}
