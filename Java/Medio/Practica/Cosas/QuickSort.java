package Java.Medio.Practica.Cosas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i<12;i++){
            Random j = new Random();
            numeros.add(j.nextInt(1,12));
        }
        System.out.println(ordenar(numeros));
        System.out.println(numeros);
    }

    static List<Integer> ordenar(List<Integer> lista){
        if (lista.size()>1) {
            final int primero = lista.getFirst();
            List<Integer> inferiores = new ArrayList<>(lista.stream().filter(a -> a < primero).toList());
            List<Integer> superiores = new ArrayList<>(lista.stream().filter(a -> a > primero).toList());
            List<Integer> iguales = new ArrayList<>(lista.stream().filter(a -> a == primero).toList());
            inferiores = ordenar(inferiores);
            superiores = ordenar(superiores);
            inferiores.addAll(iguales);
            inferiores.addAll(superiores);
            return inferiores;
        }
        return lista;
    }
}
