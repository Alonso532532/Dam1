package Java.Medio.Pruebas.Prueba1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Prueba {
    public static void main(String[] args) {
        System.out.println("Por caracteres forma 1");
        try (FileReader leer = new FileReader("Java/Medio/Pruebas/Prueba1/prueba.txt")){
            int caracter;
            while ((caracter = leer.read()) != -1){
                System.out.print((char) caracter);
            }
        } catch (IOException e){
            System.out.println("El archivo no ha sido encontrado");
        }
        System.out.println("\nPor caracteres forma 2");
        try (FileInputStream leer = new FileInputStream("Java/Medio/Pruebas/Prueba1/prueba.txt")){
            int car;
            while ((car = leer.read()) != -1){
                System.out.print((char) car);
            }
        } catch (IOException e){
            System.out.println("No encontrado");
        }
        System.out.println("\nPor líneas");
        try (BufferedReader buffer = new BufferedReader(new FileReader("Java/Medio/Pruebas/Prueba1/prueba.txt"))){
            String linea;
            while ((linea = buffer.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
