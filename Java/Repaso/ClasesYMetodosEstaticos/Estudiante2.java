package Java.Repaso.ClasesYMetodosEstaticos;

public class Estudiante2 extends Estudiar {
    String nombre;

    public Estudiante2(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    void estudiar() {
        System.out.println("Ha estudiado "+ ++hDeEstudio + " horas");
    }
}
