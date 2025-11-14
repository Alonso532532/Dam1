package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame un entero\n> ");
        int num1 = sc.nextInt();

        recursividad(num1);

    }

    public static void recursividad(int numero1){

        if (numero1 >= 0){
            System.out.println(numero1--);
            recursividad(numero1);
        }

    }

}