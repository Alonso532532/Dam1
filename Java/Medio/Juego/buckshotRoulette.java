package Java.Medio.Juego;
import java.util.Scanner;
import java.math.*;

public class buckshotRoulette {

    public static boolean repetir;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int record = 0;

        while (true){

            System.out.println("El record de esta ejecución es de " + record + " partidas contra BOT.");

            //------------------------------------------------------------MENÚ--------------------------------------------------------

            System.out.print(" //<><><><><><><><><><><><>\\\\\n||   ¿Que quieres hacer?    ||\n \\\\<><><><><><><><><><><><>//\n1 - Contra BOT\n2 - Partida rapida\nS - Salir\n> ");

            String op = sc.nextLine();
            op = op.toLowerCase();

            if (op.equals("1")){

                record = partidaNormal();

            } else if (op.equals("2")) {



            } else if (op.equals("s")) {

                return;

            }else {

                System.out.println("ERROR - Carácter invalido");

            }

        }

    }

    public static int partidaNormal() throws InterruptedException {
        int partida = 0;
        boolean ganador = true;
        int balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
        int[] tipo = recargar(balas);
        int ronda = 1, vidaJ = 3, vidaB = 3, turno = 1;

        //Partida
        do {

            //Si ha perdido el BOT
            if (vidaB <= 0){

                if (vidaJ < 3) {vidaJ = 3;}
                vidaB = 3;
                partida++;

                do {
                    repetir = false;
                    System.out.print("HAS GANADO UNA PARTIDA, ¿QUIERES CONTINUAR? (S/N)\n> ");
                    String salir = sc.nextLine();
                    salir.toLowerCase();

                    if (salir.equals("n")) return partida;

                    if (!salir.equals("s")){
                        repetir = true;
                        System.out.println("ERROR - OPCIÓN INVALIDA");
                    }

                }while (repetir);

                balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
                tipo = recargar(balas);
                ronda = 1;


            } else if (vidaJ <= 0) {

                ganador = false;

            } else {

                //Ronda
                int recamara = 0;

                do {

                    do {
                        if (turno == 1){
                            /*zona de desarrollo
                            System.out.println("<");
                            for (int i = 0; i < balas; i++){
                                System.out.print("|" + tipo[i]);
                            }
                            System.out.println();
                            System.out.println(recamara);
                            System.out.println(">");
                            */

                            turno++;
                            repetir = false;
                            //Mostrar vida
                            System.out.print("       /==TU==|==BOT=\\\n      | ");

                            for (int i = 1; i <= vidaJ; i++) System.out.print("▮");

                            for (int i = 3; i > vidaJ; i--) System.out.print("▯");

                            System.out.print(" | ");

                            for (int i = 1; i <= vidaB; i++) System.out.print("▮");

                            for (int i = 3; i > vidaB; i--) System.out.print("▯");

                            System.out.println(" |");

                            System.out.println( "       \\=============/");

                            //Menú de disparo y tal
                            System.out.print(" //<><><><><><><><><><><><>\\\\\n||          ELIGE           ||\n \\\\<><><><><><><><><><><><>//\n1 - DISPARARTE\n2 - DISPARAR AL BOT\nRONDA " + ronda + " > ");
                            String op = sc.nextLine();
                            if (op.equals("2")){

                                System.out.print("APUNTAS AL BOT");
                                for(int i = 0; i < 3; i++){
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                }
                                System.out.println();

                                if (tipo[recamara] == 1){

                                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                                    vidaB--;
                                    tipo[recamara] = 2;

                                } else {

                                    System.out.println("LA BALA ERA FALSA");
                                    tipo[recamara] = 2;


                                }

                                recamara++;

                            } else if (op.equals("1")) {

                                System.out.print("TE APUNTAS");
                                for(int i = 0; i < 3; i++){
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                }
                                System.out.println();

                                if (tipo[recamara] == 1){

                                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                                    vidaJ--;

                                } else {

                                    System.out.println("LA BALA ERA FALSA, CONTINUAS EN TU TURNO");
                                    tipo[recamara] = 2;
                                    turno--;

                                }

                                recamara++;

                            } else {

                                System.out.println("ERROR - Carácter invalido");
                                repetir = true;
                                turno--;

                            }
                        } else {

                            System.out.println(" //<><><><><><><><><><><><>\\\\\n||       TURNO DEL BOT      ||\n \\\\<><><><><><><><><><><><>//");
                            turno--;
                            Thread.sleep(1000);

                            int real = 0, fals = 0, accion;

                            for (int i = 0; i < balas; i++){
                                if (tipo[i] == 1){

                                    real++;

                                } else if (tipo[i] == 0){

                                    fals++;

                                }
                            }

                            accion = (int) (Math.random() * 4 + 1);

                            if (real >= fals && fals > 0){

                                if (accion >= 2){

                                    System.out.print("EL BOT TE APUNTA");
                                    for(int i = 0; i < 3; i++){
                                        System.out.print(".");
                                        Thread.sleep(1000);
                                    }
                                    System.out.println();

                                    if (tipo[recamara] == 1){

                                        System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                                        vidaJ--;
                                        tipo[recamara] = 2;

                                    } else {

                                        System.out.println("LA BALA ERA FALSA");
                                        tipo[recamara] = 2;


                                    }

                                    recamara++;

                                } else {

                                    System.out.print("EL BOT SE APUNTA A EL");
                                    for(int i = 0; i < 3; i++){
                                        System.out.print(".");
                                        Thread.sleep(1000);
                                    }
                                    System.out.println();

                                    if (tipo[recamara] == 1){

                                        System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                                        vidaB--;

                                    } else {

                                        System.out.println("LA BALA ERA FALSA, CONTINUA SU TURNO");
                                        tipo[recamara] = 2;
                                        turno++;

                                    }

                                    recamara++;

                                }

                            } else if (real < fals && real > 0){

                                if (accion == 1){

                                    System.out.print("EL BOT TE APUNTA");
                                    for(int i = 0; i < 3; i++){
                                        System.out.print(".");
                                        Thread.sleep(1000);
                                    }
                                    System.out.println();

                                    if (tipo[recamara] == 1){

                                        System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                                        vidaJ--;
                                        tipo[recamara] = 2;

                                    } else {

                                        System.out.println("LA BALA ERA FALSA");
                                        tipo[recamara] = 2;


                                    }

                                    recamara++;

                                } else {

                                    System.out.print("EL BOT SE APUNTA A EL");
                                    for(int i = 0; i < 3; i++){
                                        System.out.print(".");
                                        Thread.sleep(1000);
                                    }
                                    System.out.println();

                                    if (tipo[recamara] == 1){

                                        System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                                        vidaB--;

                                    } else {

                                        System.out.println("LA BALA ERA FALSA, CONTINUA SU TURNO");
                                        tipo[recamara] = 2;
                                        turno++;

                                    }

                                    recamara++;

                                }

                            } else if (fals == 0){

                                System.out.print("EL BOT TE APUNTA");
                                for(int i = 0; i < 3; i++){
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                }
                                System.out.println();

                                if (tipo[recamara] == 1){

                                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                                    vidaJ--;
                                    tipo[recamara] = 2;

                                } else {

                                    System.out.println("LA BALA ERA FALSA");
                                    tipo[recamara] = 2;

                                }

                                recamara++;

                            } else {

                                System.out.print("EL BOT SE APUNTA A EL");
                                for(int i = 0; i < 3; i++){
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                }
                                System.out.println();

                                if (tipo[recamara] == 1){

                                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                                    vidaB--;

                                } else {

                                    System.out.println("LA BALA ERA FALSA, CONTINUA SU TURNO");
                                    tipo[recamara] = 2;
                                    turno++;

                                }

                                recamara++;
                            }

                        }
                        System.out.print("===========================================");
                        Thread.sleep(2000);
                        System.out.println();
                    } while(repetir);

                }while (vidaJ > 0 && vidaB > 0 && recamara < balas);

                //Si en la ronda se han quedado sin balas se recarga
                if (recamara == balas && vidaJ > 0 && vidaB > 0 ){

                    balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
                    tipo = recargar(balas);
                    ronda++;

                }

            }

        }while (ganador);

        System.out.println("ⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘ\nⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘHASⵘPERDIDOⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘ\nⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘ");
        System.out.print("PUNTUACION: " + partida + "\nENTER PARA CONTINUAR...");
        sc.nextLine();
        return partida;
    }

    public static int[] recargar(int cant){
        int[] balas = new int [cant];
        int cartucho, blanks = 0, reales = 0;

        //Itroduzco las balas en la escopeta
        cant--;
        for (; cant >= 0; cant--){
            cartucho = (int) (Math.random() * 2);
            balas[cant] = cartucho;
            if (cartucho == 1){reales++;} else {blanks++;}
        }

        if (blanks == 0){
            System.out.println("lleno de reales");
            reales--;
            blanks++;
            balas[((int) (Math.random() * reales-1))] = 0;
        }
        if (reales == 0){
            System.out.println("lleno de blanks");
            reales++;
            blanks--;
            balas[((int) (Math.random() * blanks-1))] = 1;
        }

        //Muestro la cantidad de balas de cada tipo
        System.out.print("⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹|RECARGA|⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹\n           /");
        for (int i = 1;i <= blanks + reales; i++) System.out.print("--");;
        System.out.print("-\\\nCARTUCHOS <  ");
        for (int i = 1;i <= reales; i++) System.out.print("◉ ");
        for (int i = 1;i <= blanks; i++) System.out.print("○ ");
        System.out.print(" >\n           \\");
        for (int i = 1;i <= blanks + reales; i++) System.out.print("--");;
        System.out.print("-/\n⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸⧹⧸\nENTER PARA CONTINUAR...");
        sc.nextLine();
        return balas;
    }

}
