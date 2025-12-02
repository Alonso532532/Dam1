package Java.Basicos.ejercicios.ejercicioExamen;

import java.util.ArrayList;
import java.util.Collections;

public class Empresa {
    private ArrayList<Empleado> trabajadores = new ArrayList<>();

    public ArrayList<Empleado> getTrabajadores() {
        return trabajadores;
    }

    public Empresa(ArrayList<Empleado> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Empresa() {
    }

    public String toString() {
        for (Empleado i : trabajadores){
            System.out.println(i.toString());
        }
        return null;
    }

    public double salarioPromedio(){
        double acum = 0;
        int cont = 0;
        for (Empleado i : trabajadores){
            acum += i.getSalario();
            cont++;
        }
        return acum/cont;
    }

    public String empleadoMasAntiguo(){
        String nombre = "";
        int antiguedadMax = 0;
        for (Empleado i : trabajadores){
            if (i.antiguedad() > antiguedadMax){
                antiguedadMax = i.antiguedad();
                nombre = i.getNombre();
            }
        }
        return nombre;
    }

    public void buscarEmpleado(String empleado){
        for (Empleado i : trabajadores){
            if (i.getNombre().equals(empleado) || i.getPuesto().equals(empleado)){
                System.out.println("Empleado encontrado\n" + i.toString());
            }
        }
    }
}
