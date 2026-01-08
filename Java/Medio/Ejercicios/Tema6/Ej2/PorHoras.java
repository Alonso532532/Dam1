package Java.Medio.Ejercicios.Tema6.Ej2;

public class PorHoras extends Empleado{
    int horas;
    public PorHoras(Double salario, String nombre, int horas) {
        this.salario = salario;
        this.nombre = nombre;
        this.horas = horas;
    }
    @Override
    Double calcularSalario() {
        super.salario *= horas;
        return super.calcularSalario();
    }
}
