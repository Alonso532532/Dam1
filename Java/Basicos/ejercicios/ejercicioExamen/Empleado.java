package Java.Basicos.ejercicios.ejercicioExamen;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Empleado {
    private String nombre;
    private String apellidos;
    private LocalDate fechaDeContratacion;
    private String DNI;
    private double salario;
    private String puesto;

    //=================Getter & Setter=================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaDeContratacion() {
        return fechaDeContratacion;
    }

    public void setFechaDeContratacion(LocalDate fechaDeContratacion) {
        this.fechaDeContratacion = fechaDeContratacion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    //=================Constructor=================

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, LocalDate fechaDeContratacion) {
        this.nombre = nombre;
        this.fechaDeContratacion = fechaDeContratacion;
    }

    public Empleado(String nombre, String apellidos, LocalDate fechaDeContratacion, String DNI, double salario, String puesto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaDeContratacion = fechaDeContratacion;
        this.DNI = DNI;
        this.salario = salario;
        this.puesto = puesto;
    }

    public void trabajar(){
        System.out.println("Estoy trabajando como " + puesto);
    }

    @Override
    public String toString() {
        return "<===== Empleado =====>" +
                "\n| nombre: " + nombre +
                "\n| apellidos: " + apellidos +
                "\n| fechaDeContratacion: " + fechaDeContratacion +
                "\n| DNI: " + DNI +
                "\n| salario: " + salario +
                "\n| puesto: " + puesto;
    }

    public int antiguedad(){
        if (fechaDeContratacion == null) return 0;
        return (int) ChronoUnit.DAYS.between(fechaDeContratacion, LocalDate.now());
    }
}
