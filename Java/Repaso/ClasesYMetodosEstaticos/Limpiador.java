package Java.Repaso.ClasesYMetodosEstaticos;

import java.time.LocalDate;

public class Limpiador extends Empleado {
    public Limpiador(String dni, String nombre, int edad, String NUSS, double salario, LocalDate fechaDeContratacion) {
        super(dni, nombre, edad, NUSS, salario, fechaDeContratacion);
    }

    @Override
    public void indicarPuesto() {
        System.out.println("Soy un limpiador");
    }
}
