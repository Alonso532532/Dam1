package Java.Repaso.ClasesYMetodosEstaticos;

import java.time.LocalDate;

public class Gerente extends Profesor{
    public Gerente(String dni, String nombre, int edad, String NUSS, double salario, LocalDate fechaDeContratacion, String clase) {
        super(dni, nombre, edad, NUSS, salario, fechaDeContratacion, clase);
    }

    @Override
    public void indicarPuesto() {
        super.indicarPuesto();
        System.out.println("Además soy gerente");
    }
}
