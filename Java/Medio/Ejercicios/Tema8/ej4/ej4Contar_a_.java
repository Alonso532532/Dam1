package Java.Medio.Ejercicios.Tema8.ej4;

import java.io.FileReader;
import java.io.IOException;

public class ej4Contar_a_ {
    public static void main(String[] args) {
        try (FileReader leer = new FileReader("Java\\Medio\\Ejercicios\\Tema8\\ej4\\textoLectura.txt")){
            int car;
            int contador=0;
            while ((car = leer.read()) != -1){
                if (car == 'a' || car == 'A'){
                    contador++;
                }
            }
            System.out.println("El archivo tiene "+contador+" veces la letra \"a\"");
        }catch (IOException e){
            System.out.println("No se ha ecnontrado el archivo");
        }
    }
}
