package Java.Repaso.ClasesYMetodosEstaticos;

import java.util.ArrayList;

public class Centro {
    private ArrayList<Persona> personas;

    public Centro() {
        personas = new ArrayList<>();
    }

    public Centro(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    Empleado empMasAntiguo(){
        Empleado antiguo = null;
        boolean primero = true;
        for (Persona i: personas){
            if (i instanceof Empleado){
                if (primero){
                    antiguo = (Empleado) i;
                    primero = false;
                } else {
                    Empleado emp = (Empleado) i;
                    if (antiguo.antiguedad()<emp.antiguedad()){
                        antiguo=emp;
                    }
                }
            }
        }
        return antiguo;
    }

    ArrayList<Estudiante> sacarEstudiantes(){
        ArrayList<Estudiante> resp = new ArrayList<>();
        for (Persona i: personas){
            if (i instanceof Estudiante){
                resp.add((Estudiante) i);
            }
        }
        return resp;
    }
}
