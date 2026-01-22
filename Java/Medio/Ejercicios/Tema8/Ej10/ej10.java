package Java.Medio.Ejercicios.Tema8.Ej10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej10 {
    public static void main(String[] args) {

        System.out.println("<================>\nPor país\n<================>");
        buscar("\\bES\\b|\\bPT\\b");
        System.out.println("<================>\nPor dominio \".edu\" de email\n<================>");
        buscar("@\\w+\\.edu");
        System.out.println("<================>\nPor email \"yahoo\"\n<================>");
        buscar("@yahoo\\.");
        System.out.println("<================>\nPor ultimo login\n<================>");
        buscar("2015-0[5-9]|2015-1[0-2]|2016-[0-9]{2}|2016-1[0-2]|2017-0[1-2]");
        System.out.println("<================>\nPor nombre\n<================>");
        buscar("\\d+,Clem");
    }
    static void buscar(String rejex){
        try (BufferedReader br = new BufferedReader(new FileReader("Java/Medio/Ejercicios/Tema8/Ej10/DATA.csv"))){
            String linea;
            while ((linea = br.readLine()) != null){
                Matcher filtro = Pattern.compile(rejex).matcher(linea);
                while (filtro.find()){
                    System.out.println(linea);
                }
            }
        }catch (IOException e){
            System.out.println("El documento no se ha encontrado");
        }

    }
}
