package Java.Medio.Ejercicios.Tema8.ej4;

import java.io.*;
import java.nio.charset.StandardCharsets;
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


        try (FileReader lectura = new FileReader("Java/Medio/Ejercicios/Tema8/ej4/textoLectura.txt");
             FileOutputStream escritura = new FileOutputStream("Java/Medio/Ejercicios/Tema8/ej4/textoMayusc.txt")){
            System.out.println("<========================== Por carácter ===========================>");

            escritura.write("Añado el texto con caracteres: \n\n".getBytes());
            int car;
            String mayus = "";
            while ((car = lectura.read()) != -1){
                mayus += (char) car;
            }
            mayus = mayus.toUpperCase();
            System.out.println("Añado el siguiente texto:\n\n" + mayus);

            escritura.write(mayus.getBytes());

        }catch (IOException e){
            System.out.println("Ha ocurrido un error");
        }

        try (BufferedReader texto = new BufferedReader( new FileReader("Java/Medio/Ejercicios/Tema8/ej4/textoLectura.txt"));
            FileWriter escribir = new FileWriter("Java/Medio/Ejercicios/Tema8/ej4/textoMayusc.txt", true)){

            System.out.println("<========================== Por línea ===========================>");

            escribir.write("Añado el texto con líneas:\n\n");
            String linea;
            System.out.println("Añado el siguiente texto:\n");
            while ((linea = texto.readLine()) != null){
                System.out.println(linea.toUpperCase());
                escribir.write(linea.concat("\n").toUpperCase());
            }

        } catch (IOException e){
            System.out.println("Ha ocurrido un error");
        }

    }
}
