package Java.Medio.Ejercicios.Tema8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej10 {
    public static void main(String[] args) {
        String texto = " hola  buenas   tardes     ";
        texto = texto.trim();
        texto = texto.replaceAll(" {2,}", " ");
        System.out.println(texto);
    }
}
