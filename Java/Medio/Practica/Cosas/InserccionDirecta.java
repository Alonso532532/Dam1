package Java.Medio.Practica.Cosas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InserccionDirecta {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i<12;i++){
            Random j = new Random();
            numeros.add(j.nextInt(1,12));
        }
        System.out.println(ordenar(numeros));
    }

    static List<Integer> ordenar(List<Integer> lista){
        for (int i = 0; i < lista.size(); i++) {
            int j = i;

            while ( j>0 && lista.get(j)<lista.get(j-1)){
                int temp = lista.get(j);
                lista.set(j, lista.get(j-1));
                lista.set(j-1, temp);
                j--;
            }

        }
        return lista;
    }
}
