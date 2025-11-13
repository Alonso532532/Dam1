package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean repetir;
        int num1 = 0;

        do {

            repetir = false;
            System.out.print("Dame un numero\n> ");

            try {

                num1 = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {

                System.out.println("Error");
                repetir = true;

            }

        } while (repetir);

        do {

            repetir = false;
            System.out.print("Dame otro numero\n> ");

            try {

                int num2 = Integer.parseInt(sc.nextLine());
                sc.close();
                System.out.println("El menor es : " + menor(num1, num2));


            } catch (Exception e) {

                System.out.println("Error");
                repetir = true;

            }

        } while (repetir);



    }

    public static int menor(int numero1,int numero2){
        int resp;

        if (numero1 > numero2){
            numero1 = numero2;
        }

        return numero1;
    }
}
