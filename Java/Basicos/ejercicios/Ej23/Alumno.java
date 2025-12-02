package Java.Basicos.ejercicios.Ej23;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona{
    private String grupo;
    private int curso;
    private ArrayList<String> asignaturas = new ArrayList<>();

    //========================Constructores========================
    public Alumno(String nombre, String grupo, int curso, ArrayList<String> asignaturas) {
        super(nombre);
        this.grupo = grupo;
        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    public Alumno(String nombre, LocalDate fechaDeNacimiento, String grupo, int curso, ArrayList<String> asignaturas) {
        super(nombre, fechaDeNacimiento);
        this.grupo = grupo;
        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    public Alumno(String nombre, String apellidos, String DNI, char sexo, LocalDate fechaDeNacimiento, String grupo, int curso, ArrayList<String> asignaturas) {
        super(nombre, apellidos, DNI, sexo, fechaDeNacimiento);
        this.grupo = grupo;
        this.curso = curso;
        this.asignaturas = asignaturas;
    }
    //========================Setters y getters========================

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    //========================Cosas========================
    public void verEstudios(){
        System.out.println("El alumno " + getNombre() + " estudia:");
        for (String i : asignaturas){
            System.out.println("- " + i);
        }
    }
}
