package Java.Medio.Ejercicios.Tema11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            numeros.add((int) (Math.random()*10+1));
        }
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
            if (op==0)break;
            final int opcion = op;
            long cont = numeros.stream().filter(a -> a==opcion).count();
            // UNGA UNGA ⬇️⬇️
//            List<Integer> busqueda = new ArrayList<>(numeros);
//            while (busqueda.contains(op)){
//                busqueda.remove(busqueda.indexOf(op));
//                cont ++;
//            }
            System.out.println("El numero "+op+" aparece "+cont+" veces");
        }
    }
}
