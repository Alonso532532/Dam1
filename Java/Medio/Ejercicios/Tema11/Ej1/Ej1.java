package Java.Medio.Ejercicios.Tema11.Ej1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
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
        System.out.println("1- Los registros del pahís FR");
        // Esto elimina todos los que no sean FR pero modifica la lista
//        registros.removeIf(registros -> !registros.contains(",FR,"));
        // Aplica un filtro que busca ",FR," y muestra el resultado
        registros.stream().filter(registros -> registros.contains(",FR,")).forEach(System.out::println);
        System.out.println("<==========================>\n<==========================>\n<==========================>\n<==========================>\n<==========================>");
        System.out.println("2- Los registros con email de yahoo ordenados por nombre");
        registros.stream().filter(registros -> registros.contains("@yahoo")).sorted().forEach(System.out::println);
    }
}
