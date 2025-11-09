package Java.Medio;
import java.util.Scanner;
import static java.lang.Math.random;


public class memoria {
    static void main() {
        Scanner sc = new Scanner(System.in);

        boolean repetir;



        //Pido el modo y la cantidad de carácteres, el modo lo almaceno en "op" 1-4 y la cantidad de carácteres en "ncar"
        do {

            repetir = true;
            char car;
            int ncar = 0, azar;
            String op, memorizar = "", resp = "";

            do {
                System.out.print("-------------------------------\n¿Como quieres intentarlo?\n-------------------------------\n1 - Todos los carácteres\n2 - Números\n3 - Letras\nS - Salir\n> ");
                op = sc.nextLine();
                op = op.toLowerCase();
                if (op.equals("s")){

                    System.out.println("Saliendo...");
                    return;

                }else if (!op.equals("1") && !op.equals("2") && !op.equals("3")){

                    System.out.println("- ERROR: Carácter invalido");

                }
            } while (!op.equals("1") && !op.equals("2") && !op.equals("3"));


            do {
                System.out.print("¿Cuantos carácteres?\n> ");
                try {

                    ncar = Integer.parseInt(sc.nextLine());
                    if (ncar <= 0){
                        System.out.println("- ERROR: El número es inferior a 1");
                    } else {repetir = false;}

                } catch (NumberFormatException e){

                    System.out.println("- ERROR: La respuesta no es un número");

                }

            }while (repetir);
            if (op.equals("1")){
                for (int i = 0; i < ncar; i++){

                    car = (char) (Math.random() * 94 + 33);
                    memorizar += car;

                }
                System.out.println(memorizar);
            } else if (op.equals("2")){
                for (int i = 0; i < ncar; i++){

                    car = (char) (Math.random() * 10 + 48);
                    memorizar += car;

                }
                System.out.println(memorizar);
            } else if (op.equals("3")){
                for (int i = 0; i < ncar; i++){
                    azar = (int) (Math.random() * 2);
                    if (azar == 0){
                        car = (char) (Math.random() * 26 + 65);
                        memorizar += car;
                    }else{
                        car = (char) (Math.random() * 26 + 97);
                        memorizar += car;
                    }
                }
                System.out.println(memorizar);
            }

            System.out.print("Memorizalo, cuando estés preparado presiona enter\n> ");
            sc.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            int intentos = 0;
            do {
                intentos++;
                System.out.print("intento - " + intentos + "/3 > ");
                resp = sc.nextLine();
                if (!memorizar.equals(resp)){
                    azar = (int) (Math.random() * 3);
                    if (azar == 0) {
                        System.out.println("Fallo");
                    } else if (azar == 1){
                        System.out.println("Mal");
                    } else {
                        System.out.println("No");
                    }
                }
            }while (!memorizar.equals(resp) && intentos < 3);
            if (intentos == 3 && !memorizar.equals(resp)){
                System.out.println("Te has quedado sin intentos");
            } else {
                azar = (int) (Math.random() * 3);
                if (azar == 0) {
                    System.out.println("Perfecto");
                } else if (azar == 1){
                    System.out.println("Correcto");
                } else {
                    System.out.println("Exacto");
                }
            }
            repetir = true;
            do {
                System.out.print("¿Quieres repetir? (s/n)\n> ");
                op = sc.nextLine();
                op = op.toLowerCase();
                if (op.equals("s") && op.equals("n")){
                    System.out.println("- ERROR: Opción no valida");
                }
            } while (op.equals("s") && op.equals("n"));
            if (op.equals("n")){
                repetir = false;
            }


        } while (repetir);

    }
}
