package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame dos numeros reales\n> ");
        double num1 = sc.nextDouble();

        System.out.print("> ");
        double num2 = sc.nextDouble();

        System.out.println("El mayor es: " + mayor(num1,num2));

    }

    public static double mayor(double numero1, double numero2){

        if (numero1 > numero2){

            return numero1;

        }else{

            return numero2;

        }

    }
}