package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean repetir;

        do {

            repetir = false;
            System.out.print("Dame un numero\n> ");

            try {

                int num = Integer.parseInt(sc.nextLine());
                sc.close();
                tabla(num);


            } catch (Exception e) {

                System.out.println("Error");
                repetir = true;

            }

        } while (repetir);

    }

    public static void tabla(int numero){
        for (int i = 1; i <= 10; i++){
            System.out.println(numero + " * " + i + " = " + numero*i);
        }
    }
}
