package Java.Medio.Ejercicios.Tema10.Ej1;

public class Empleado {
    String nombre;
    double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String mostrarInfo(){
        return "Nombre: "+nombre+", Salario: "+salarioBase;
    }

}
