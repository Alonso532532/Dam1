package Java.Basicos;
import java.util.*;
import java.math.*;

public class PruebasScanner {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdice un numero\n> ");
        while (!sc.hasNextLine()) {
            System.out.println("Error");
            System.out.print("Introdice un numero\n> ");
            sc.nextLine();
        }
        String numero = sc.nextLine();
        System.out.println("Perfe --> " + numero);
    }
}

