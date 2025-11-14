package Java.Basicos.ejercicios;

import java.util.Scanner;

public class ej13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame un entero\n> ");
        int num1 = sc.nextInt();

        System.out.print("1 = " + recursividad(num1));

    }

    public static int recursividad(int numero1){
        int cont = 1;

        if (numero1 > 1){
            System.out.print(numero1 + "*");
            return cont = numero1 * recursividad(--numero1);
        }
        return cont;
    }

}
