package Java.Medio.Ejercicios.Tema8.ej4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ej4Lectura {
    public static void main(String[] args) {
        System.out.println("<========================== Por carácter ===========================>");
        try (FileReader lectura = new FileReader("Java\\Medio\\Ejercicios\\Tema8\\ej4\\textoLectura.txt")){
            int charTexto;
            while ((charTexto = lectura.read()) != -1){
                System.out.print((char) charTexto);
            }
        }catch (IOException e){
            System.out.println("Ha ocurrido un error");
        }
        System.out.println("<========================== Por línea ===========================>");
        try (BufferedReader buffer = new BufferedReader( new FileReader("Java\\Medio\\Ejercicios\\Tema8\\ej4\\textoLectura.txt"))){

            String linea;
            while ((linea = buffer.readLine()) != null){
                System.out.println(linea);
            }

        } catch (IOException e){
            System.out.println("Ha ocurrido un error");
        }
    }
}
