package Java.Basicos.ejercicios;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ej24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Dame la ruta de un archivo o directorio: ");
            StringBuilder recurso = new StringBuilder(sc.nextLine());
            if (recurso.lastIndexOf(".") == recurso.length() - 4){
                System.out.println("Es el archivo: " + recurso.substring(recurso.lastIndexOf("\\")+1, recurso.length()-4));
                System.out.println("Que está en: " + recurso.substring(0,recurso.lastIndexOf("\\")+1));
                System.out.println("Y es de tipo: " + recurso.substring(recurso.lastIndexOf(".")+1,recurso.length()));
            } else {
                System.out.println("Es el directorio: " + recurso.substring(recurso.lastIndexOf("\\")+1, recurso.length()));
                System.out.println("Que está en: " + recurso.substring(0,recurso.lastIndexOf("\\")+1));
            }
        } while (true);
    }
}
