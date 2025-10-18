package Java.Basicos;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame un texto\n> ");
        String textn = sc.nextLine();
        System.out.print("Dame otro texto\n> ");
        String textl = sc.next();

        System.out.println("El texto con next es ->" + textn);
        System.out.println("El texto con next es ->" + textl);
    }
}
