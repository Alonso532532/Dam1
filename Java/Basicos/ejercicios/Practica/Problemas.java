package Java.Basicos.ejercicios.Practica;

import java.util.ArrayList;

public class Problemas {
    ArrayList<String> problemas;
    int numSerie;

    public Problemas(int numSerie) {
        this.numSerie = numSerie;
    }

    public Problemas(ArrayList<String> problemas, int numSerie) {
        this.problemas = problemas;
        this.numSerie = numSerie;
    }

    public void mostrarProblemas(){
        if (!problemas.isEmpty()){
            System.out.println("<== Los problemas del coche " + numSerie + " son ==>");
            for (String i : problemas){
                if (!i.isEmpty()){
                    int tamano = i.length();
                    int ini = -1;
                    int fin = 50;
                    int acum = 51;
                    System.out.println();
                    while (tamano-acum>0){
                        System.out.println(i.substring(ini+1, fin));
                        acum+=50;
                        fin+=50;
                        ini += 50;

                    }
                    System.out.println(i.substring(ini+1));
                } else {
                    System.out.println("El problema está vacío");
                }
            }
        } else {
            System.out.println("No hay problemas relacionados");
        }
    }
    public void anadirProblema(String pr){
        problemas.add(pr);
    }
}
