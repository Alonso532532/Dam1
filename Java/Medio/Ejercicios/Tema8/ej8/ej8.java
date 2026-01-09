package Java.Medio.Ejercicios.Tema8.ej8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej8 {
    public static void main(String[] args) {
        Pattern patron = Pattern.compile("\\b[\\S]+\\b");
        try (BufferedReader leer = new BufferedReader(new FileReader("Java\\Medio\\Ejercicios\\Tema8\\ej8\\texto"))){
            String linea;
            int cont = 0;
            while ((linea = leer.readLine()) != null){
                Matcher matcher = patron.matcher(linea);
                while (matcher.find()){
                    cont++;
                }
            }
            System.out.println("Hay "+cont+" palabras");
        } catch (IOException e){
            System.out.println("El archivo no existe");
        }
    }
}
