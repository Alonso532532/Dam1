package Java.Medio.Ejercicios.Tema8.Ej10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej10P {
    public static void main(String[] args) {
        buscar("");
    }
    public static void buscar(String regex){
        try (BufferedReader leer = new BufferedReader(new FileReader("Java/Medio/Ejercicios/Tema8/Ej10/DATA.csv"))){
            String linea;
            int contador = 0;
            while ((linea = leer.readLine()) != null){
                Matcher matcher = Pattern.compile(regex).matcher(linea);
                if (matcher.find()) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }

    }
}
