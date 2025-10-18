package Java.Basicos;
import java.math.*;
import java.util.*;

public class ej5 {
    public static void main(String[] args) {
        Scanner iker = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        double a = iker.nextDouble();
        System.out.println("El resultado con raíz cuadrada es: " + Math.sqrt(a));
        System.out.println("El resultado con raíz cubica es: " + Math.cbrt(a));
        //public static double sqrt(double a)
    }

}
