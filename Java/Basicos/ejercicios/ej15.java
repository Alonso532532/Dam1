package Java.Basicos.ejercicios;
import java.util.Scanner;


public class ej15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero\n> ");
        int num = sc.nextInt();

        System.out.println("0\nEl resultado es: " + sumaCifras(num));

    }

    public static int sumaCifras(int num){

        if (num != 0){
            System.out.print(num + " + ");

        }

        return num + sumaCifras(num-1);
    }

}