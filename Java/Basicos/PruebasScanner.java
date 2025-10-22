package Java.Basicos;
import java.util.*;
import java.math.*;

public class PruebasScanner {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entero\n> ");
        if (sc.hasNextInt()) {
            System.out.println("Has introducido un numero entero");
        } else  {
            System.out.println("No has introducido un numero entero");
        }
    }
}
