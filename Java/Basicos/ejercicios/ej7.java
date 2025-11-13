package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repetir;

        do {
            repetir = false;
            System.out.print("Dame un numero\n> ");
            try {
                double num = Double.parseDouble(sc.nextLine());
                sc.close();
                System.out.println("Signo: " + signo(num));

            } catch (Exception e){

            }
        } while (repetir);

    }

    public static int signo(double numero){

        int resp;

        if (numero < 0){
            resp = -1;
        } else if (numero > 0) {
            resp = 1;
        } else {resp = 0;}

        return resp;
    }

}
