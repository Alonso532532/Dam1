package Java.Medio.Ejercicios.Tema8.ej4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ej4LecturaEescritura {
    public static void main(String[] args) {

        try {
            Path archivo = Paths.get("Java/Medio/Ejercicios/Tema8/ej4/textoMayusc.txt");
            Files.createFile(archivo);
        } catch (IOException e){
            System.out.println("El archivo ya existe");
        }


        try (FileInputStream lectura = new FileInputStream("Java/Medio/Ejercicios/Tema8/ej4/textoLectura.txt")){
            System.out.println("<========================== Por carácter ===========================>");

            int car;
            String mayus = "";
            while ((car = lectura.read()) != -1){
                mayus += (char) car;
            }
            mayus = mayus.toUpperCase();
            System.out.println(mayus);
            FileOutputStream escritura = new FileOutputStream("Java/Medio/Ejercicios/Tema8/ej4/textoMayusc.txt");
            escritura.write(mayus.getBytes());

        }catch (IOException e){
            System.out.println("Ha ocurrido un error");
        }

        try (RandomAccessFile raw = new RandomAccessFile("Java/Medio/Ejercicios/Tema8/ej4/textoLectura.txt", "rw")){
            System.out.println("<========================== Por línea ===========================>");

            String linea;
            while ((linea = raw.readLine()) != null){
                System.out.println(linea.toUpperCase());
            }

        } catch (IOException e){
            System.out.println("Ha ocurrido un error");
        }

    }
}
