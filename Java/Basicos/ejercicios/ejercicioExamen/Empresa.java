package Java.Basicos.ejercicios.ejercicioExamen;

import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.Collections;

public class Empresa {
    private ArrayList<Empleado> trabajadores;

    public ArrayList<Empleado> getTrabajadores() {
        return trabajadores;
    }

    public Empresa() {
        trabajadores = new ArrayList<>();
    }

    public Empresa(ArrayList<Empleado> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void mostrarEmpleados() {
        if (trabajadores.isEmpty()){
            System.out.println("No hay empleados");
        } else {
            for (Empleado i : trabajadores){
                System.out.println(i.toString());
            }
        }
    }

    public double salarioPromedio(){
        if (trabajadores.isEmpty()) return 0.0;
        double acum = 0;
        for (Empleado i : trabajadores){
            acum += i.getSalario();
        }
        return acum/trabajadores.size();
    }

    public Empleado empleadoMasAntiguo(){
        if (trabajadores.isEmpty()) return null;
        Empleado empleado = trabajadores.get(0);
        for (Empleado i : trabajadores){
            if (empleado.antiguedad() < i.antiguedad()){
                empleado = i;
            }
        }
        return empleado;
    }

    public void buscarEmpleado(String empleado){
        if (trabajadores.isEmpty()){
            System.out.println("No hay empleados");
            return;
        }
        for (Empleado i : trabajadores){
            if (i.getNombre().equalsIgnoreCase(empleado) || i.getPuesto().equalsIgnoreCase(empleado)){
                System.out.println("Empleado encontrado\n" + i.toString());
            }
        }
    }
}
