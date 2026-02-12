package Java.Medio.Ejercicios.Tema11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ej3Manera2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> numeros = new HashMap<>();
        for (int i = 0; i < 10; i++){
            int num = (int) (Math.random()*10+1);
            numeros.put(num, numeros.containsKey(num) ? numeros.get(num)+1 : 1);
        }
        System.out.println(numeros);
        Scanner sc = new Scanner(System.in);
        int op = 1;
        while (true) {
            do {
                System.out.print("¿Que numero quieres comprobar? 0 salir\n> ");
                try {
                    op = Integer.parseInt(sc.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Mal");
                }
            } while (op < 0 || op > 10);
            if (op == 0)break;
            System.out.println(numeros.get(op)==null ? "El numero " + op + " no aparece": "El numero aparece " + numeros.get(op) + " veces");
        }
    }
}
