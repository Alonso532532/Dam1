package Java.Basicos.ejercicios;
import java.util.*;


public class ej6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamano;
        String op;
        int cont;

        do{
            System.out.print("¿Que forma quieres que haga?\nTriangulo - t\nTriangulo al revés - tr\nCuadrado - c\nSalir - s\n> ");
            op = sc.next();
            sc.nextLine();

            switch (op) {
                case "T","t":

                    do {
                        System.out.print("¿Que tamaño quieres que tenga?, tiene que ser impar\n> ");
                        while (!sc.hasNextInt()){
                            System.out.println("Error");
                            System.out.print("¿Que tamaño quieres que tenga?, tiene que ser impar\n> ");
                            sc.nextLine();
                        }
                        tamano = sc.nextInt();
                        if (tamano <= 0){
                            System.out.println("No puede ser 0 o inferior");
                        } else if (tamano% 2 == 0){
                            System.out.println("No es impar");
                        }
                    } while (tamano % 2 == 0 || tamano <= 0);
                    cont = 1;
                    tamano = tamano + 2;
                    for (int j = 1; j != tamano; j = j + 2){
                        for (int i = 0; i != tamano/2-cont; i++){
                            System.out.print(" ");
                        }
                        for (int i = 0; i != j; i++){
                            System.out.print("*");
                        }
                        System.out.println("");
                        cont++;
                    }
                    sc.nextLine();
                    System.out.print("Introduce una letra para continuar\n> ");
                    String b = sc.nextLine();

                    break;
                case "Tr","tr":

                    do {
                        System.out.print("¿Que tamaño quieres que tenga?, tiene que ser impar\n> ");
                        while (!sc.hasNextInt()){
                            System.out.println("Error");
                            System.out.print("¿Que tamaño quieres que tenga?, tiene que ser impar\n> ");
                            sc.nextLine();
                        }
                        tamano = sc.nextInt();

                        if (tamano <= 0){
                            System.out.println("No puede ser 0 o inferior");
                        } else if (tamano% 2 == 0){
                            System.out.println("No es impar");
                        }
                    } while (tamano % 2 == 0);

                    for (int j = 0; tamano > 0; j++){
                        for (int i = 0; i != j; i++){
                            System.out.print(" ");
                        }
                        for (int i = tamano; i != 0; i--) {
                            System.out.print("*");
                        }
                        System.out.println("");
                        tamano = tamano - 2;
                    }
                    sc.nextLine();
                    System.out.print("Introduce una letra para continuar\n> ");
                    String a = sc.nextLine();

                    break;
                case "C","c":
                    int alt;
                    int anch;

                    do {
                        System.out.print("¿Que altura quieres que tenga?\n> ");
                        while (!sc.hasNextInt()){
                            System.out.println("Error");
                            System.out.print("¿Que altura quieres que tenga?\n> ");
                            sc.nextLine();
                        }
                        alt = sc.nextInt();
                        if (alt <= 0){
                            System.out.println("El numero no puede ser 0 o inferior");
                        }
                    } while(alt <= 0);

                    do {
                        System.out.print("¿Que anchura quieres que tenga?\n> ");
                        while (!sc.hasNextInt()){
                            System.out.println("Error");
                            System.out.print("¿Que anchura quieres que tenga?\n> ");
                            sc.nextLine();
                        }
                        anch = sc.nextInt();
                        if (anch <= 0){
                            System.out.println("El numero no puede ser 0 o inferior");
                        }
                    } while(anch <= 0);

                    for(int al = 0; al != alt; al++){
                        for (int an = 0; an != anch; an++){
                            if (al == 0){
                                System.out.print("*");
                            } else if (an == 0){
                                System.out.print("*");
                            } else if (an == anch-1){
                                System.out.print("*");
                            } else if (al == alt-1){
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                    sc.nextLine();
                    System.out.print("Introduce una letra para continuar\n> ");
                    String c = sc.nextLine();

                    break;
                case "S","s":
                    return;
                default:
                    System.out.println("No es una opción");
                    break;
            }
        } while (op != "s");
    }
}
