package Java.Medio.Practica.Modificación;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Modificar {
    public static void main(String[] args) {
        File archivo1 = new File("Java/Medio/Practica/Modificación/cosa1.txt");
        try {
            if (true){
                Files.delete(archivo1.toPath());
            }
            Files.createFile(archivo1.toPath());
            System.out.println(archivo1.toPath().getFileName().toString().substring(archivo1.toPath().getFileName().toString().lastIndexOf(".")+1));

            Files.write(archivo1.toPath(), ("Hola Þbuenas\nTardes").getBytes());
            System.out.println("Contenido del archivo");

            for (int i : Files.readAllBytes(archivo1.toPath())) {
                System.out.print((char)i);
            }

            System.out.println();
        } catch (IOException e){
            System.out.println("Archvo no encontrado en parte 1");
        }
        Path archivo2 = Paths.get("Java/Medio/Practica/Modificación/cosa2.txt");
        try {
            if (true){
                Files.createFile(archivo2);
            }
            System.out.println("Moviendo a " + archivo2.getParent().getParent());
            Files.move(archivo2, Paths.get(archivo2.getParent().getParent().toString()+"\\"+archivo2.getFileName()) );
        } catch (IOException e){
            System.out.println("Archvo no encontrado en parte 2");
        }
    }
}
