package Java.Medio.Practica.Cosas;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class Bytes {
    public static void main(String[] args) {
        try (BufferedInputStream leer = new BufferedInputStream( new FileInputStream("Java/Medio/Practica/Cosas/texto.txt"))) {
            byte[] array = leer.readAllBytes();
            for (byte i : array){
                if (i>=0){
                    System.out.print((char)i);
                }
            }
        }catch (IOException e){
            System.out.println("Mal");
        }
        System.out.println("\n===========================================");
        try (FileInputStream leer = new FileInputStream("Java/Medio/Practica/Cosas/texto.txt")){
            byte[] array = leer.readAllBytes();
            for (byte i : array){
                if (i>=0){
                    System.out.print((char)i);
                }
            }
        } catch (IOException e){
            System.out.println("Mal2");
        }
        System.out.println("\n===========================================");
        try (FileOutputStream escribir = new FileOutputStream("Java/Medio/Practica/Cosas/texto.txt", true)){
            escribir.write((int) (Math.random()*256));
        } catch (IOException e){
            System.out.println("Mal2");
        }
    }
}
