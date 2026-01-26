package Java.Medio.Ejercicios.Tema10.Ej1;

public class Gerente extends Empleado {
    double bono;

    public Gerente(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()+", Bono: "+ bono;
    }
}
