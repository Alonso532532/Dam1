package Java.Medio.Practica.Cosas.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class filtros {
    public static void main(String[] args) {
        comprobar("");
    }
    static void comprobar(String patron){
        try (BufferedReader leer = new BufferedReader(new FileReader("Java/Medio/Practica/Cosas/regex/texto.txt"))){
            String texto;
            int cont = 0;
            while ((texto = leer.readLine()) != null){
                Matcher comprobar = Pattern.compile(patron).matcher(texto);
                while (comprobar.find()){
                    System.out.println(comprobar.group());
                    cont++;
                }
            }
            System.out.println("\nCoincidencias: "+cont);
        } catch (IOException e){
            System.out.println("FALLACO HISTORICO");
        }
    }
}
