package Java.Basicos;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        boolean seguir = true;
        do {
            System.out.print("Dame un entero entre 0 y 9: ");
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num > 10) {
                    System.out.println("El numero es superior a 9");
                } else if (num < 0) {
                    System.out.println("El numero es negarivo");
                } else {
                    seguir = false;
                    System.out.println("El numero " + num + " es valido");
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato invalido");
            }
        } while (seguir);
    }
}
