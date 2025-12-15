package Java.Medio.Ejercicios.Tema8;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame la ruta de un archivo\n> ");
        Path ruta = Paths.get(sc.nextLine());
        File archivo = new File(ruta.toString());
        if (archivo.exists()){
            System.out.println("El directorio raíz es " + ruta.getRoot());
            System.out.println("El directorio padre es " + ruta.getParent().toString().substring(ruta.getParent().toString().lastIndexOf("\\") + 1));
            System.out.println("El nombre del archivo es " + ruta.getFileName().toString().substring(0, ruta.getFileName().toString().lastIndexOf(".")));
            System.out.println("El extensión es " + ruta.getFileName().toString().substring(ruta.getFileName().toString().lastIndexOf(".")));
        }else {
            System.out.println("El archvio no existe");
        }
    }
}
