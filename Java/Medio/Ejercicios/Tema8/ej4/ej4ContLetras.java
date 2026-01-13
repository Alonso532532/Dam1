package Java.Medio.Ejercicios.Tema8.ej4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ej4ContLetras {
    public static void main(String[] args) {
        try (FileReader leer = new FileReader("Java\\Medio\\Ejercicios\\Tema8\\ej4\\textoLectura.txt")){
            int car;

            ArrayList<Integer> cant = new ArrayList<>();
            ArrayList<Character> tipo = new ArrayList<>();

            while ((car = leer.read()) != -1){
                if (car >= 65 && car <= 90){
                    car += 32;
                }
                if (car >= 97 && car <= 122){
                    if (!tipo.contains((char) car)){
                        tipo.add((char) car);
                        cant.add(1);
                    } else {
                        for (int i = 0; i < tipo.size(); i++) {
                            if (tipo.get(i) == car){
                                cant.set(i, cant.get(i)+1);
                                break;
                            }
                        }

                    }
                }
            }
            if (!tipo.isEmpty()){
                for (int i = 0; i < tipo.size(); i++) {
                    System.out.println("El carácter "+tipo.get(i)+" aparece "+cant.get(i)+" veces.");
                }
            }else {
                System.out.println("No hay caracteres del abecedario en el archivo");
            }
        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
