package Java.Basicos;
import java.util.*;
import java.math.*;

public class Jugo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String op;
        int opof;
        int sal = 0;
        char ap;
        int cant;
        double precio;
        String espera;

        int[][] ofertas = {{0,0}, {0,0}, {0,0}};
        do {

            System.out.print("----------------------------\n¿Que desea?\n----------------------------\nAñadir/Modificar una oferta -> o\nCalcular pedido -> c\nSalir -> s\n> ");
            op = sc.nextLine();

            if (op.equals("o")) {

                System.out.println("¿Que oferta quieres añadir? (1/2/3)");

                for (int i = 0; i < 3; i++) {
                    System.out.println("La oferta " + (i + 1) + " rebaja " + ofertas[i][0] + "€ por cada " + ofertas[i][1] + " productos");
                }

                System.out.print("> ");
                opof = sc.nextInt();

                if (opof <= 3 && opof >= 1) {

                    opof = opof - 1;
                    System.out.print("¿De cuanto qieres que sea la rebaja?\n> ");
                    ofertas[opof][0] = sc.nextInt();
                    System.out.print("¿Cada cuantos productos?\n> ");
                    ofertas[opof][1] = sc.nextInt();

                }

                espera = sc.nextLine();
            } else if (op.equals("c")) {

                    System.out.print("¿Quieres aplicar una ofreta? (s/n)\n> ");
                    ap = sc.nextLine().charAt(0);

                    if (ap == 's') {

                        System.out.print("¿Que oferta? (1/2/3)\n> ");
                        opof = sc.nextInt();

                        if (opof <= 3 && opof >= 1) {

                            opof = opof - 1;

                            if (ofertas[opof][0] > 0 || ofertas[opof][1] > 0) {

                                System.out.print("¿Cuantos productos se van a vender?\n> ");
                                cant = sc.nextInt();
                                System.out.print("¿A que precio?\n> ");
                                precio = sc.nextDouble();

                                System.out.println("Resultado: " + (precio * cant - ofertas[opof][0] * (cant / ofertas[opof][1])) + "€ Enter para contunuar");
                                espera = sc.nextLine();
                                espera = sc.nextLine();

                            } else {
                                System.out.println("error");
                            }


                        } else {
                            System.out.println("Error");
                        }
                    } else if (ap == 'n'){

                        System.out.print("¿Cuantos productos se van a vender?\n> ");
                        cant = sc.nextInt();
                        System.out.print("¿A que precio?\n> ");
                        precio = sc.nextDouble();
                        System.out.println("Resultado: " + precio * cant + " Enter para contunuar");
                        espera = sc.nextLine();
                        espera = sc.nextLine();

                    } else {
                        System.out.println("error");
                    }


            } else if (op.equals("s")) {

                System.out.println("Saliendo...");
                sal = 1;

            } else {

                System.out.println("error");

            }

        } while (sal == 0);
    }
}
