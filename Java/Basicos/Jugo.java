package Java.Basicos;
import java.util.Scanner;
import java.math.*;

public class Jugo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char op;
        int opof;
        double[][] ofertas = {{0,0}, {0,0}, {0,0}};
        do {

            System.out.print("¿Que desea?\n----------------------------\nAñadir/Modificar una oferta -> o\nCalcular pedido -> c\nSalir -> s\n> ");
            op = sc.nextLine().charAt(0);

            if (op == 'o') {
                System.out.println("Que oferta quieres añadir?");

                for (int i = 0; i < 3; i++) {
                    System.out.println("La oferta " + (i + 1) + " rebaja " + ofertas[i][0] + "€ por cada " + ofertas[i][1] + " productos");
                }
                System.out.print("¿Que oferta? (1/2/3)\n> ");
                opof = sc.nextInt();
                if (opof <= 3 && opof >= 1) {

                    System.out.print("¿De cuanto qieres que sea la oferta?\n> ");
                    ofertas[opof - 1][0] = sc.nextDouble();
                    System.out.print("¿Cada cuantos productos?\n> ");
                    ofertas[opof - 1][1] = sc.nextDouble();

                }
            } else if (op == 'c') {
                if (ofertas[0][0] > 0 && ofertas[0][1] > 0) {

                } else {
                    System.out.println("La oferta no existe");
                }

            } else if (op == 's') {

                System.out.println("Saliendo...");

            }else {

                System.out.println("bobo o que");

            }

        } while (op != 's');
    }
}
