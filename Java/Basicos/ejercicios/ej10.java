package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame dos numeros reales\n> ");
        double num1 = sc.nextDouble();

        System.out.print("> ");
        double num2 = sc.nextDouble();

        System.out.println("La media es: " + media(num1,num2));

    }

    public static double media(double numero1, double numero2){

        return numero1 + numero2 / 2;

    }
}