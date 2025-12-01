package Java.Basicos.ejercicios.Ej23;

import java.util.ArrayList;

public class Personas {
    private ArrayList<Persona> personas = new ArrayList<>();

    //==============Constructor==============

    public Personas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    //==============Getter==============

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    //==============Setter==============

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void addPersonas(Persona a) {
        this.personas.add(a);
    }

    //==============Cosas==============

    @Override
    public String toString() {
        int edad = 0;
        int cont = 0;
        int maxEdad = 0;
        String nombre = "";
        System.out.println("<=========Muestro los elementos de la lista=======>");
        for (Persona i : personas){
            System.out.println(i.toString());
            System.out.println("<=====================>");
            cont++;
            edad += i.edad();
            if (maxEdad < i.edad()){
                maxEdad = i.edad();
                nombre = i.getNombre();
            }
        }
        System.out.println("La media de edad de las personas de la lista es de " + (edad/cont) + " años y la persona con más edad es " + nombre + " con " + maxEdad +  " años");
        return null;
    }
}
