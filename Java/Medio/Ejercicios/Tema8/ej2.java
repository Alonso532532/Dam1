package Java.Medio.Ejercicios.Tema8;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame la ruta de un archivo\n> ");
        Path ruta = Paths.get(sc.nextLine());
        File archivo = new File(ruta.toString());
        System.out.println("La ruta del padre es " + ruta.getParent());
        if (archivo.exists()){
            System.out.println("El elemento existe");
            if (ruta.getFileName().toString().contains(".")){
                System.out.println("Es un archivo");
            } else {
                System.out.println("Es un directorio");
                for (File e : archivo.listFiles()) {
                    System.out.println(e.toString());
                }
            }
        }else {
            System.out.println("El elemento no existe");
        }
    }
}
