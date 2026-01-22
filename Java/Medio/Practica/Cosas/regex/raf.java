package Java.Medio.Practica.Cosas.regex;

import java.io.IOException;
import java.io.RandomAccessFile;

public class raf {
    public static void main(String[] args) {
        try (RandomAccessFile manipular = new RandomAccessFile("Java/Medio/Practica/Cosas/regex/texto.txt", "rw")){
            String linea;
            while ((linea = manipular.readLine()) != null){
                System.out.print(linea);
            }
            manipular.seek(0);
            System.out.println();
            int car;
            while ((car = manipular.read()) != -1){
                System.out.print(linea);
            }
        } catch (IOException e){
            System.out.println("No se ha encontrado ");
        }
    }
}
