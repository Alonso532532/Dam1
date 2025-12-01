package Java.Basicos.ejercicios.Ej23;

import java.time.LocalDate;

public class Persona {
    private static int contador = 0;
    private final int id;
    private String nombre;
    private String apellidos;
    private String DNI;
    private char sexo;
    private LocalDate fechaDeNacimiento;

    //============================================Constructores============================================
    public Persona(String nombre) {
        this.nombre = nombre;
        id = ++contador;
    }

    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        id = ++contador;
    }

    public Persona(String nombre, String apellidos, String DNI, char sexo, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.sexo = sexo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        id = ++contador;
    }

    //============================================Getter y setter============================================

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public char getSexo() {
        return sexo;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    //============================================To string============================================

    @Override
    public String toString() {
        return "< Datos sobre la persona " + id + " >" +
                "\n| nombre: " + nombre +
                "\n| apellidos: " + apellidos +
                "\n| DNI: " + DNI +
                "\n| sexo: " + sexo +
                "\n| fechaDeNacimiento: " + fechaDeNacimiento;
    }

    //============================================Cosas============================================
    public void saludar(){
        System.out.println("Hola, soy " + nombre + " y tengo " + edad() + " años");
    }

    public int edad(){
        return LocalDate.now().compareTo(fechaDeNacimiento);
    }

}
