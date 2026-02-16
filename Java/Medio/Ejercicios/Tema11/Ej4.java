package Java.Medio.Ejercicios.Tema11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        List<String> fila1 = new ArrayList<>(Arrays.asList("Hecproll", "Alon", "Pableras", "Eker"));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(fila1);
            System.out.print("¿Que quieres hacer?\n| S - Salir | Q - Eliminar | C - Cambiar | A - Añadir |\n> ");
            String accion = sc.nextLine();
            if (accion.equalsIgnoreCase("S")) break;
            accion = accion.toUpperCase();
            switch (accion){
                case "Q":
                    System.out.print("¿Que elemento quieres eliminar?\n> ");
                    String opq = sc.nextLine();
                    if (fila1.contains(opq)) {
                        fila1.remove(opq);
                    } else System.out.println("No contiene "+ opq);
                    break;

                case "C":
                    System.out.print("¿Que elemento quieres sustituir?\n> ");
                    String opc = sc.nextLine();
                    if (fila1.contains(opc)) {
                        System.out.print("¿Por que elemento?\n> ");
                        String cosa = sc.nextLine();
                        int index = fila1.indexOf(opc);
                        fila1.set(index, cosa);
                    } else System.out.println("No contiene "+ opc);
                    break;

                case "A":
                    System.out.print("¿Que elemento quieres añadir?\n> ");
                    String opa = sc.nextLine();
                    if (!fila1.contains(opa)) {
                        try {
                            System.out.print("¿En que posición?\n> ");
                            int index = Integer.parseInt(sc.nextLine());
                            fila1.add(index, opa);
                        } catch (Exception e){
                            System.out.println("Posición imposible");
                        }
                    } else System.out.println("Ya contiene "+ opa);
                    break;

            }
        }
    }
}
