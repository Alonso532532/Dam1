package Java.Basicos.ejercicios.Practica;

import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Coches> registroCoches;
    private ArrayList<String> problemas;
    private ArrayList<Character> reparar;

    public Concesionario() {
        registroCoches = new ArrayList<>();
    }

    public Concesionario(ArrayList<Coches> registroCoches) {
        this.registroCoches = registroCoches;
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

    public void mostrarTodo(){
        for (Coches i : registroCoches){
            System.out.println(i.toString() + " El vehiculo lleva " + i.uso() + " días en uso");
        }
    }
}
