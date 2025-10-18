package Java.Basicos;
import java.math.*;
import java.util.*;

public class juegecillo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double azar;
        int resp = 2;
        int vez = 0;
        int azar2 = 1;
        char rep;

        do {
            while (azar2 != resp && vez != 5 && resp <= 10 && resp >= 1) {
                vez++;
                if (vez > 1) {
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("El anterior numero era " + azar2);
                }
                System.out.println("Quedan " + (6 - vez) + " vezes");

                System.out.print("Dime un numero entre el 1 y el 10\n> ");
                resp = sc.nextInt();

                azar = Math.random() * 10 + 1;
                azar2 = (int) azar;
            }

                if (resp == azar2) {
                    System.out.println("Te ha pillao pringao");
                } else if (resp > 10 || resp < 1) {
                    System.out.println("Tu vas de listo");
                } else {
                    System.out.println("Mis enhorabuenas su ultimo intento ha sido " + azar2);
                }
                System.out.print("¿Quieres repetir? (s/n)\n> ");
                rep = sc.next().charAt(0);
                if (rep == 's') {
                    resp = 1;
                    azar2 = 0;
                    vez = 0;

                }

        } while (rep == 's');
    }
}
