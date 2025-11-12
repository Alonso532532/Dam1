package Java.Medio.Juego;
import java.util.Scanner;
import java.math.*;

public class buckshotRoulette {

    public static boolean repetir;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int record = 0;

        while (true){

            do {
                repetir = false;
                System.out.println("El record de esta ejecución es de " + record + " rondas.");

                //------------------------------------------------------------MENÚ--------------------------------------------------------

                System.out.print(" //<><><><><><><><><><><><>\\\\\n||   ¿Que quieres hacer?    ||\n \\\\<><><><><><><><><><><><>//\n1 - Contra BOT\n2 - Partida rapida\nS - Salir\n> ");

                String op = sc.nextLine();
                op = op.toLowerCase();

                if (op.equals("1")){

                    partidaNormal();

                } else if (op.equals("2")) {



                } else if (op.equals("s")) {

                    return;

                }else {

                    System.out.println("ERROR - Carácter invalido");
                    repetir = true;

                }

            } while (repetir);

        }

    }

    public static int partidaNormal(){
        int partida = 1;
        boolean ganador = true;

        int balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
        int[] tipo = recargar(balas);
        int ronda = 1;
        int vidaJ = 3;
        int vidaB = 3;
        int turno = 1;


        //Partida
        do {

            //Si ha perdido el BOT
            if (vidaB <= 0){

                if (vidaJ < 3) {vidaJ = 3;}
                vidaB = 3;

                ronda = 1;
                partida++;

            } else if (vidaJ <= 0) {

                ganador = false;

            } else {

                //Ronda
                int recamara = 0;

                do {


                    do {
                        if (turno == 1){
                            //zona de desarrollo
                            System.out.println("<");
                            for (int i = 0; i < balas; i++){
                                System.out.print("|" + tipo[i]);
                            }
                            System.out.println();
                            System.out.println(recamara);
                            System.out.println(">");

                            repetir = false;
                            //Mostrar vida
                            System.out.print(" //<><><><><><><><><><><><>\\\\\n||          ELIGE          ||\n \\\\<><><><><><><><><><><><>//\n1 - DISPARAR AL BOT\n2 - DISPARARTE\nRonda " + ronda + " > ");


                            System.out.print(" //<><><><><><><><><><><><>\\\\\n||          ELIGE          ||\n \\\\<><><><><><><><><><><><>//\n1 - DISPARAR AL BOT\n2 - DISPARARTE\nRonda " + ronda + " > ");
                            String op = sc.nextLine();
                            if (op.equals("1")){

                                if (tipo[recamara] == 1){

                                    System.out.println("La bala era real\n-1 de vida para el BOT");
                                    vidaB--;
                                    tipo[recamara] = 2;

                                } else {

                                    System.out.println("La bala era falsa");
                                    tipo[recamara] = 2;

                                }

                                recamara++;

                            } else if (op.equals("2")) {

                                if (tipo[recamara] == 1){

                                    System.out.println("La bala era real\n-1 de vida");
                                    vidaJ--;
                                    tipo[recamara] = 2;

                                } else {

                                    System.out.println("La bala era falsa, continuas en tu turno");
                                    tipo[recamara] = 2;

                                }

                                recamara++;

                            } else {

                                System.out.println("ERROR - Carácter invalido");
                                repetir = true;

                            }
                        } else {
                            turno--;
                        }
                    } while(repetir);

                }while (vidaJ > 0 && vidaB > 0 && recamara < balas);

                //Si en la ronda se han quedado sin balas se recarga
                if (recamara == balas){

                    balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
                    tipo = recargar(balas);
                    ronda++;

                }

            }

        }while (ganador);

        return partida;
    }

    public static int[] recargar(int cant){

        int[] balas = new int [cant];
        System.out.println(cant);
        cant--;
        System.out.println(cant);
        for (; cant >= 0; cant--){
            balas[cant] = (int) (Math.random() * 2);
        }
        return balas;
    }

}
