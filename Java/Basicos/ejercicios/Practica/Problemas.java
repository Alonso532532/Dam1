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
                    int ini = 0;
                    int fin = 49;
                    int acum = 50;
                    System.out.println();
                    while (tamano-acum>0){
                        System.out.println(i.substring(ini, fin));
                        acum+=50;
                        fin+=50;
                        if (ini == 0){
                            ini += 49;
                        } else {
                            ini += 50;
                        }
                    }
                    System.out.println(i.substring(ini));
                }
            }
        } else {
            System.out.println("No hay problemas relacionados");
        }
    }
}
