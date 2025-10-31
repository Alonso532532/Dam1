package Java.Basicos;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame un num \n> ");
        double num = sc.nextDouble();
        if (num % 1 == 0){
            System.out.println("Es entero");
        } else {
            System.out.println("No es entero");
        }
    }
}
