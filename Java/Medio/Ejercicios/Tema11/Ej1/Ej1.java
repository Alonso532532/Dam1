package Java.Medio.Ejercicios.Tema11.Ej1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ej1 {
    static List<String> registros = new ArrayList<>();
    public static void main(String[] args) {

        try (BufferedReader leer = new BufferedReader( new FileReader("Java/Medio/Ejercicios/Tema11/Ej1/DATA.csv"))){
            String linea;
            while ((linea = leer.readLine()) != null){
                registros.add(linea);
            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
        registros.removeFirst();
        for (String i : registros){
            System.out.println(i);
        }
    }
}
