package Java.Medio.Ejercicios.Tema8.Ej5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class contarPalabras {
    public static void main(String[] args) {
        try (BufferedReader leer = new BufferedReader(new FileReader("Java\\Medio\\Ejercicios\\Tema8\\Ej5\\texto.txt"))){
            String linea;
            int lineas = 0;
            int cont = 0;
            System.out.println("<==== TEXTO ====>");
            while ((linea = leer.readLine()) != null){
                System.out.println(linea);
                ArrayList<String> palabras = new ArrayList<>(Arrays.asList(linea.split(" ")));
                cont += palabras.size();
                lineas++;
            }
            System.out.println("El archivo tiene " + cont + " palabras y " + lineas + " lineas");
        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
            e.printStackTrace();
        }
    }
}
