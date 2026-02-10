package Java.Medio.Ejercicios.Tema11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ej6 {
    public static void main(String[] args) {
        List numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            numeros.add((int)(Math.random()*10+1));
        }
        numeros.stream().distinct().sorted().forEach(System.out::println);
    }
}
