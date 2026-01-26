package Java.Medio.Ejercicios.Tema10.Ej1;

public class Ej1 {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Carlos", 2500.34);
        Gerente gerente = new Gerente("Juan", 2532.34, 500);
        System.out.println(empleado.mostrarInfo());
        System.out.println(gerente.mostrarInfo());
    }
}
