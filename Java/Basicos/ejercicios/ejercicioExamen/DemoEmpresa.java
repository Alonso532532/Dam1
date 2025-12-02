package Java.Basicos.ejercicios.ejercicioExamen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoEmpresa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado empleado1 = new Empleado("Dalek", "Ramirez", LocalDate.parse("2002-01-10"), "18424243S", 200.23, "Puesto-1");
        Empleado empleado2 = new Empleado("Dani", "Gomez", LocalDate.parse("2012-01-10"), "18424245345353543S", 500.23, "Puesto-2");
        Empleado empleado3 = new Empleado("Juanma", "Ramirez", LocalDate.parse("1990-01-10"), "18423243S", 230.23, "Puesto-4");
        Empleado empleado4 = new Empleado("Pableras", "Ramirez", LocalDate.parse("2012-01-10"), "184234535243S", 1200.23, "Puesto-3");
        Empleado empleado5 = new Empleado("Lidia", "Ramirez", LocalDate.parse("2024-01-10"), "184243453535243S", 280.23, "Puesto-5");
        System.out.println(empleado1.toString());
        System.out.println(empleado1.antiguedad());
        empleado1.trabajar();

        ArrayList<Empleado> array = new ArrayList<>();
        array.add(empleado1);
        array.add(empleado2);
        array.add(empleado3);
        array.add(empleado4);
        array.add(empleado5);

        Empresa marmoleriasManolo = new Empresa(array);
        marmoleriasManolo.toString();
        System.out.println("El empleado más antiguo es: " + marmoleriasManolo.empleadoMasAntiguo());
        System.out.println("El salario promedio: " + marmoleriasManolo.salarioPromedio());
        System.out.print("Dame un empleado para buscar \n> ");
        String resp = sc.nextLine();
        marmoleriasManolo.buscarEmpleado(resp);


    }

}
