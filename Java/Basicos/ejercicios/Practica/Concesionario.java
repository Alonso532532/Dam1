package Java.Basicos.ejercicios.Practica;

import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Coches> registroCoches;
    private ArrayList<Problemas> problemas;

    public Concesionario() {
        registroCoches = new ArrayList<>();
        problemas = new ArrayList<>();
    }

    public Concesionario(ArrayList<Coches> registroCoches) {
        this.registroCoches = registroCoches;
        problemas = new ArrayList<>();
    }

    public ArrayList<Coches> getRegistroCoches() {
        return registroCoches;
    }

    public void setRegistroCoches(ArrayList<Coches> registroCoches) {
        this.registroCoches = registroCoches;
    }

    public void anadirCoche(Coches coche){
        registroCoches.add(coche);
    }

    public void anadirProblema(Problemas problema){
        problemas.add(problema);
    }

    public void mostratProblemas(){
        if (!problemas.isEmpty()){
            for (Problemas i : problemas){
                i.mostrarProblemas();
            }
        }else {
            System.out.println("No hay problemas");
        }
    }

    public void mostrarCoches(){
        if (!registroCoches.isEmpty()){
            System.out.println("<=  Coches del concesionario =>");
            for (Coches i : registroCoches){
                System.out.println(i.toString() + " El vehiculo lleva " + i.uso() + " días en uso");
            }
        } else {
            System.out.println("No hay coches");
        }

    }


}
