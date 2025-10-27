package Java.Basicos.ejercicios;
import java.util.*;

public class ej2 {
    public static void main(String[] args) {
        Scanner lozano = new Scanner(System.in);
        System.out.print("¿Que texto tengo que poner primero?\n> ");
        String t1 = lozano.nextLine();
        System.out.print("¿Y después?\n> ");
        String t2 = lozano.nextLine();
        System.out.println(t1 + "\n" + t2);
    }
}
