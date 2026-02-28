package Java.Repaso.ClasesYMetodosEstaticos;

public class Estudiante extends Persona{
    private String curso;

    public Estudiante(String dni, String nombre, int edad, String curso) {
        super(dni, nombre, edad);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
