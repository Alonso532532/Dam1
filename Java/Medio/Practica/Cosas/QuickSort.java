package Java.Medio.Practica.Cosas;

import java.util.ArrayList;
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
    }

    static List<Integer> ordenar(List<Integer> lista){
        if (lista.size()>0) {
            final int primero = lista.getFirst();
            List<Integer> inferiores = ordenar(lista.stream().filter(a -> a < primero).toList());
            List<Integer> superiores = ordenar(lista.stream().filter(a -> a > primero).toList());
            return lista;
        }
    }
}
