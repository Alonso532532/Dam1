package Java.Basicos.ejercicios.Practica;

import Java.Basicos.ejercicios.Ej23.Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public class DemoCoches {
    public static void main(String[] args) {
        Propietario carlengues = new Propietario("Carlos", "18461701S");
        Coches seatLeon = new Coches(260,"Seat",1200.01, LocalDate.parse("2025-03-05"), carlengues);
        Propietario chilli = new Propietario("Jorje", "09818462S");
        Coches cupraE15 = new Coches(340,"Cupra",2200.01, LocalDate.parse("2023-03-07"), chilli);
        System.out.println(seatLeon.toString());
        System.out.println("El vehiculo lleva " + seatLeon.uso() + " días en uso");
        System.out.println(cupraE15.toString());
        System.out.println("El vehiculo lleva " + cupraE15.uso() + " días en uso");
        ArrayList<Coches> arrayList = new ArrayList<>();
        arrayList.add(seatLeon);
        arrayList.add(cupraE15);
        Concesionario hecproll = new Concesionario(arrayList);
        hecproll.mostrarTodo();
    }
}
