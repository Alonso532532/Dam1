package Java.Medio.Practica.Cosas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    static int num = 0;
    public static void main(String[] args) {
        String texto = "1500";
        Matcher numero = Pattern.compile("1500|1[0-4]\\d{2}|\\d{1,3}").matcher(texto);
        comprobar(numero);
        String texto2 = "lHao";
        Matcher hola = Pattern.compile("(?=.*[hH])(?=.*[oO])(?=.*[lL])(?=.*[aA]).{4,}").matcher(texto2);
        comprobar(hola);
        String texto3 = "Un flujo es un mecanismo que permite realizar operaciones de entrada y salida de datos (I/O), " +
                "de manera secuencial, " +
                "entre un origen de datos (data source) y un destino de datos (data sink).\n";
        Matcher palabras = Pattern.compile("\\b\\S+").matcher(texto3);
        comprobar(palabras);
        Matcher empieza = Pattern.compile("\\bm\\S*").matcher(texto3);
        comprobar(empieza);

    }
    static void comprobar(Matcher regex){
        System.out.println("<==============| "+(++num)+" |==============>");
        int cont = 0;
        while(regex.find()){
            cont++;
            System.out.println(regex.group());
        }
        System.out.println("Encontradas: "+cont);
        if (cont==0){
            System.out.println("No coincide");
        }
    }
}
