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
                do {
                    int recamara = 0;

                    repetir = false;
                    do {
                        System.out.print(" //<><><><><><><><><><><><>\\\\\n||   ELIGE    ||\n \\\\<><><><><><><><><><><><>//\n1 - DISPARAR AL BOT\n2 - DISPARARTE\nRonda " + ronda + " > ");
                        String op = sc.nextLine();
                        if (op.equals("1")){



                        } else if (op.equals("2")) {



                        } else {

                            System.out.println("ERROR - Carácter invalido");
                            repetir = true;
                        }

                    } while(repetir);

                }while (vidaJ > 0 && vidaB > 0 && balas > 0);

                //Si en la ronda se han quedado sin balas se recarga
                if (balas <= 0){

                    balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
                    tipo = recargar(balas);
                    ronda++;

                }

            }

        }while (ganador);

        return partida;
    }

    public static int[] recargar(int cant){

        int[] balas = {cant};

        cant--;
        for (; cant >= 0; cant--){
            balas[cant] = (int) (Math.random() * 2);
            System.out.println("|" + balas[cant]);
        }
        return balas;
    }

    public static int[] disparar(int pos, int balasF){

    }

    public static int[] autoDisparar(int pos, int balasF){

    }
}
