package Java.Medio.Ejercicios.Tema6.Ej2;

public class Fijo extends Empleado{
    public Fijo(Double salario, String nombre) {
        this.salario = salario;
        this.nombre = nombre;
    }
    @Override
    Double calcularSalario() {
        return super.calcularSalario();
    }
}
