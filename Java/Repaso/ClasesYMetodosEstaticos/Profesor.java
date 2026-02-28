package Java.Repaso.ClasesYMetodosEstaticos;

import java.time.LocalDate;

public class Profesor extends Empleado {
    private String clase;

    public Profesor(String dni, String nombre, int edad, String NUSS, double salario, LocalDate fechaDeContratacion, String clase) {
        super(dni, nombre, edad, NUSS, salario, fechaDeContratacion);
        this.clase = clase;
    }

    @Override
    public void indicarPuesto() {
        System.out.println("Soy un profesor y doy clase en: "+ clase);
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
