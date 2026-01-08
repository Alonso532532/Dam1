package Java.Medio.Ejercicios.Tema6.Ej2;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Empleado emp1 = new Fijo(1350.0, "Elias");
        Empleado emp3 = new Fijo(1550.0, "Juan");
        Empleado emp2 = new PorHoras(10.2, "Pedro", 160);
        ArrayList<Empleado> empresa = new ArrayList<>(Arrays.asList(emp1,emp2,emp3));
        Double aPagar = 0.0;
        for (Empleado i : empresa){
            Double salario = i.calcularSalario();
            System.out.println(i.getNombre()+" --> "+salario);
            aPagar += salario;
        }
        System.out.println("Total: "+aPagar);
    }
}
