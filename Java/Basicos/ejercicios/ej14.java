package Java.Basicos.ejercicios;
import java.util.Scanner;


public class ej14 {

    static int a = 0, b = 1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Couantos numeros quieres que se muestren?\n> ");
        int limite = sc.nextInt();

        fibonacci(a, b, limite);

    }

    public static void fibonacci(int a, int b, int limite){

        if (limite > 0){

            if (limite == 1){

                System.out.print(a);

            } else {

                System.out.print(a + " " + b + " ");
                fibonacci(a = a + b, a + b, limite - 2);

            }

        }

    }

}
