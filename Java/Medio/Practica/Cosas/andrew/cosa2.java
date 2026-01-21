package Java.Medio.Practica.Cosas.andrew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cosa2 {
    public static void main(String[] args) {
        try (BufferedReader leer = new BufferedReader( new FileReader("Java/Medio/Practica/Cosas/andrew/texto"))){
            String linea;
            while ((linea = leer.readLine()) != null){
                Matcher regex = Pattern.compile("\\|(12[0-3]|1[01][0-9]|\\d{1,2})(?=.{2,4})(?=(?:.*x){2,}).*\\|").matcher(linea);
                while (regex.find()){
                    System.out.println(regex.group());
                }
            }


        } catch (IOException e){

        }


    }
}
