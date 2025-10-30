package Java.Basicos;
import java.util.*;
import java.math.*;

public class masPruebas {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //Declaro lo que se ha de declarar
        int conteo = 0;
        char resp;
        char resp2;
        int[] mejoras = {0, 0, 0, 0};
        System.out.println("Bienvenido, para empezar introduce un carácter (el intro no cuenta como carácter)\nPara abrir la tienda introduce \"t\" y para salir \"q\"");

        do {

            System.out.print(conteo + ">");
            resp = sc.next().charAt(0);

            if (resp == 't') {
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                do {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("¿Que desea?\nSalir = q");
                    if (mejoras[0] == 0) {
                        System.out.println("Comprar mejora1 (50) = \"1\"");
                    }
                    if (mejoras[1] == 0) {
                        System.out.println("Comprar mejora2 (300) = \"2\"");
                    }
                    if (mejoras[2] == 0) {
                        System.out.println("Comprar mejora3 (700) = \"3\"");
                    }
                    System.out.print("Fin, acaba el proceso (5000) = \"f\"\n> ");
                    resp2 = sc.next().charAt(0);

                    if (resp2 == 'q') {
                        System.out.println("Saliendo de la tienda");
                    } else if (resp2 == '1') {
                        if (conteo >= 50 && mejoras[0] == 0) {
                            System.out.println("Mejora comprada con exito");
                            mejoras[0] = 1;
                            conteo = conteo - 50;
                        } else {
                            System.out.println("Dinero insufuciente o ya la tenías implementada");
                        }
                    } else if (resp2 == '2') {
                        if (conteo >= 300 && mejoras[1] == 0) {
                            System.out.println("Mejora comprada con exito");
                            mejoras[1] = 1;
                            conteo = conteo - 300;
                        } else {
                            System.out.println("Dinero insufuciente o ya la tenías implementada");
                        }
                    } else if (resp2 == '3') {
                        if (conteo >= 700 && mejoras[2] == 0) {
                            System.out.println("Mejora comprada con exito");
                            mejoras[2] = 1;
                            conteo = conteo - 700;
                        } else {
                            System.out.println("Dinero insufuciente o ya la tenías implementada");
                        }
                    } else if (resp2 == 'f') {
                        if (conteo >= 5000) {
                            System.out.println("Mejora comprada con exito");
                            mejoras[3] = 1;
                            resp2 = 'q';
                            resp = 'q';
                        } else {
                            System.out.println("¿A donde vas tan rapido?");
                        }
                    }
                } while (resp2 != 'q');
            } else if (resp == 'q') {
                System.out.println("Saliendo del proceso");
            } else {
                conteo++;
                if (mejoras[0] == 1) {
                    conteo = conteo + 2;
                }
                if (mejoras[1] == 1) {
                    conteo = conteo + 4;
                }
                if (mejoras[2] == 1) {
                    conteo = conteo + 8;
                }
            }
        } while (resp != 'q');
        System.out.println("El total de final de puntos es de " + conteo);
        if (mejoras[3] == 1) {
            System.out.println("Mis enhorabuenas has completado el proceso");
        }
    }
}
