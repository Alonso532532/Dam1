package Java.Basicos.ejercicios.Ej23;

import java.time.LocalDate;
import java.util.ArrayList;

public class ej23 {
    public static void main(String[] args) {
        Persona transeunte = new Persona("Pablo", "Ramirez", "1723712S", 'H', LocalDate.parse("2020-11-01"));
        Persona calvo = new Persona("Andrew", "vape", "17452912S", 'H', LocalDate.parse("0001-11-01"));
        Persona dalek = new Persona("Jef", "Jepherson", "3897612S", 'H', LocalDate.parse("1999-11-01"));
        System.out.println(transeunte.toString());
        transeunte.saludar();
        System.out.println(calvo.toString());
        calvo.saludar();


        calvo.setFechaDeNacimiento(LocalDate.parse("2000-11-01"));
        ArrayList<Persona> grupo = new ArrayList<>();
        grupo.add(transeunte);
        grupo.add(calvo);
        Personas list = new Personas(grupo);
        list.addPersonas(dalek);

        list.toString();
    }
}
