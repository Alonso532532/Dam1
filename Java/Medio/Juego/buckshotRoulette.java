package Java.Medio.Juego;
import java.util.Scanner;

public class buckshotRoulette {

    public static int balas, recamara, jugador;
    public static int[] tipo;
    public static boolean repetir;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int record = 0;
        String[] jugadoresN = {"iker","alon","pableras","Sin asignar"};

        while (true){

            System.out.println("El record de esta ejecución es de " + record + " partidas contra BOT.");

            //------------------------------------------------------------MENÚ--------------------------------------------------------

            System.out.print(" //<><><><><><><><><><><><>\\\\\n||   ¿Que quieres hacer?    ||\n \\\\<><><><><><><><><><><><>//\n1 - Contra BOT\n2 - Partida rapida\nS - Salir\n> ");

            String op = sc.nextLine();
            op = op.toLowerCase();

            if (op.equals("1")){

                record = partidaNormal();

            } else if (op.equals("2")) {
                    repetir = false;
                    int contJ = 0;
                    for (int i = 0; i < 4; i++){
                        if (jugadoresN[i].equals("Sin asignar"))contJ++;
                    }

                    op = "n";
                    if (contJ < 3){

                        do {
                            System.out.print(" ╭⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃╮\n │   ¿Quieres jugar con los mismos jugadores? (S/N)   │\n ╰⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃╯\n|");
                            for (int i = 0; i < 4; i++){
                                if (!jugadoresN[i].equals("Sin asignar")){
                                    System.out.print(" " + jugadoresN[i] + " |");
                                }
                            }
                            System.out.print("\n> ");
                            op = sc.nextLine();
                            op = op.toLowerCase();

                            if (!op.equals("s") && !op.equals("n")){

                                System.out.println("ERROR - Carácter invalido");

                            }

                        } while (!op.equals("s") && !op.equals("n"));

                    }

                    if (op.equals("n")) {

                        do {
                            int pos = 0;
                            repetir = true;
                            System.out.print(" ╭⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃╮\n │   ¿Quienes van a jugar?    │\n ╰⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃╯\n1 - Añadir jugador\n2 - Eliminar jugador\n3 - Empezar\nS - Salir\n|");
                            for (int i = 0; i < 4; i++) {
                                System.out.print(" " + jugadoresN[i] + " |");
                            }
                            System.out.print("\n> ");
                            op = sc.nextLine();
                            op = op.toLowerCase();

                            if (op.equals("1")) {
                                System.out.print("⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃\n▶ ¿Que posición? (1-4)\n- Cualquier otra posición para cancelar\n|");
                                for (int i = 0; i < 4; i++) {
                                    System.out.print(" " + jugadoresN[i] + " |");
                                }
                                System.out.print("\n> ");
                                try {

                                    pos = Integer.parseInt(sc.nextLine());
                                    if (pos < 4 && pos > 0){
                                        pos--;
                                        do {
                                            System.out.print("⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃\n▶ Nombre del jugador\n> ");
                                            op = sc.nextLine();
                                            if (op.length() < 3){
                                                System.out.println("ERROR - Minimo 3 carácteres");
                                            }
                                        } while (op.length() < 3);
                                        jugadoresN[pos] = op;
                                    } else {
                                        System.out.println("ERROR - Posición invalida");
                                    }

                                } catch (Exception e){

                                    System.out.println("ERROR - Carácter invalido");

                                }

                            } else if (op.equals("2")) {

                                System.out.print("⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃\n▶ ¿Que posición? (1-4)\n- Cualquier otra posición para cancelar\n|");
                                for (int i = 0; i < 4; i++) {
                                    System.out.print(" " + jugadoresN[i] + " |");
                                }
                                System.out.print("\n> ");
                                try {

                                    pos = Integer.parseInt(sc.nextLine());
                                    if (pos < 4 && pos > 0){
                                        pos--;
                                        jugadoresN[pos] = "Sin asignar";
                                    } else {
                                        System.out.println("ERROR - Posición invalida");
                                    }

                                } catch (Exception e){

                                    System.out.println("ERROR - Carácter invalido");

                                }

                            } else if (op.equals("3")) {
                                contJ = 0;
                                for (int i = 0; i < 4; i++){
                                    if (jugadoresN[i].equals("Sin asignar"))contJ++;
                                }

                                if (contJ < 3){

                                    PartidaRapida(jugadoresN);
                                    repetir = false;

                                } else {

                                    System.out.println("ERROR - Faltan jugadores");

                                }

                            } else if (op.equals("s")) {

                                break;

                            } else {

                                System.out.println("ERROR - Carácter invalido");

                            }

                        } while (repetir);

                    } else if (op.equals("s")){

                        PartidaRapida(jugadoresN);

                    }

            } else if (op.equals("s")) {

                return;

            } else {

                System.out.println("ERROR - Carácter invalido");

            }


        }

    }
    //==========================================================================================================================================================================
    //=============================================================================Partida Normal===============================================================================
    //==========================================================================================================================================================================
    public static int partidaNormal() throws InterruptedException {
        int partida = 0;
        boolean ganador = true;
        tipo = recargar();
        int ronda = 1, vidaJ = 3, vidaB = 3;
        jugador = 1;

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
                    salir = salir.toLowerCase();

                    if (salir.equals("n")) return partida;

                    if (!salir.equals("s")){
                        repetir = true;
                        System.out.println("ERROR - OPCIÓN INVALIDA");
                    }

                }while (repetir);

                tipo = recargar();
                ronda = 1;


            } else if (vidaJ <= 0) {

                ganador = false;

            } else {

                //Ronda
                recamara = 0;

                do {

                    do {
                        if (jugador == 1){


                            repetir = false;
                            //Mostrar vida
                            System.out.print("       /==TU==|==BOT=\\\n      | ");

                            for (int i = 1; i <= vidaJ; i++) System.out.print("▮");

                            for (int i = 3; i > vidaJ; i--) System.out.print("▯");

                            System.out.print(" | ");

                            for (int i = 1; i <= vidaB; i++) System.out.print("▮");

                            for (int i = 3; i > vidaB; i--) System.out.print("▯");

                            System.out.println(" |");

                            System.out.println( "       \\======|======/");

                            //Menú de disparo y tal
                            System.out.print(" //<><><><><><><><><><><><>\\\\\n||          ELIGE           ||\n \\\\<><><><><><><><><><><><>//\n1 - DISPARARTE\n2 - DISPARAR AL BOT\nRONDA " + ronda + " > ");
                            String op = sc.nextLine();
                            if (op.equals("1")){

                                vidaJ -= dispararBOT(op);

                            } else if (op.equals("2")) {

                                vidaB -= dispararBOT(op);

                            } else {

                                System.out.println("ERROR - Carácter invalido");
                                repetir = true;

                            }
                        } else {
                            int bot = dispararDeBOT();
                            if (bot < 2){

                                vidaJ -= bot;

                            } else {

                                vidaB -= bot-10;

                            }

                        }
                        System.out.print("===========================================");
                        Thread.sleep(2000);
                        System.out.println();
                    } while(repetir);

                }while (vidaJ > 0 && vidaB > 0 && recamara < balas);

                //Si en la ronda se han quedado sin balas se recarga
                if (recamara == balas && vidaJ > 0 && vidaB > 0 ){

                    tipo = recargar();
                    ronda++;

                }

            }

        }while (ganador);

        System.out.println("ⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘ\nⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘHASⵘPERDIDOⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘ\nⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘⵘ");
        System.out.print("PUNTUACION: " + partida + "\nENTER PARA CONTINUAR...");
        sc.nextLine();
        return partida;
    }

    public static int[] recargar(){
        //==========================================================================================================================================================================
        //=============================================================================RECARGA======================================================================================
        //==========================================================================================================================================================================
        balas = (int) (Math.random() * 5 + 3); // entre 3 y 7
        int[] balasArr = new int [balas];
        int cartucho, blanks = 0, reales = 0;


        //Itroduzco las balas en la escopeta
        for (int i = balas -1; i >= 0; i--){
            cartucho = (int) (Math.random() * 2);
            balasArr[i] = cartucho;
            if (cartucho == 1){reales++;} else {blanks++;}
            System.out.print("|" + balasArr[i]);
        }
        System.out.println();

        if (blanks == 0){
            System.out.println("lleno de reales");
            reales--;
            blanks++;
            balasArr[((int) (Math.random() * reales-1))] = 0;
        }
        if (reales == 0){
            System.out.println("lleno de blanks");
            reales++;
            blanks--;
            balasArr[((int) (Math.random() * blanks-1))] = 1;
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
        return balasArr;
    }

    public static int dispararBOT(String op) throws InterruptedException {
        //==========================================================================================================================================================================
        //=============================================================================DISPARAR DE MODO BOT=========================================================================
        //==========================================================================================================================================================================
        int recamaraDisparo = 0;

        jugador++;
        if (op.equals("2")){

            System.out.print("APUNTAS AL BOT");
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                Thread.sleep(700);
            }
            System.out.println();

            if (tipo[recamara] == 1){

                System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            } else {

                System.out.println("LA BALA ERA FALSA");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            }

            recamara++;

        } else if (op.equals("1")) {

            System.out.print("TE APUNTAS");
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                Thread.sleep(700);
            }
            System.out.println();

            if (tipo[recamara] == 1){

                System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            } else {

                System.out.println("LA BALA ERA FALSA, CONTINUAS EN TU TURNO");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;
                jugador--;

            }

            recamara++;

        }

        return recamaraDisparo;
    }

    public static int dispararDeBOT() throws InterruptedException {
        //==========================================================================================================================================================================
        //=============================================================================DISPARAR DE BOT==============================================================================
        //==========================================================================================================================================================================
        int recamaraDisparo = 0;
        System.out.println(" //<><><><><><><><><><><><>\\\\\n||       TURNO DEL BOT      ||\n \\\\<><><><><><><><><><><><>//");
        jugador--;
        Thread.sleep(700);

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
                    Thread.sleep(750);
                }
                System.out.println();

                if (tipo[recamara] == 1){

                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                    recamaraDisparo = tipo[recamara];
                    tipo[recamara] = 2;

                } else {

                    System.out.println("LA BALA ERA FALSA");
                    recamaraDisparo = tipo[recamara];
                    tipo[recamara] = 2;


                }

                recamara++;

            } else {

                System.out.print("EL BOT SE APUNTA A EL");
                for(int i = 0; i < 3; i++){
                    System.out.print(".");
                    Thread.sleep(750);
                }
                System.out.println();

                if (tipo[recamara] == 1){

                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                    recamaraDisparo = 11;
                    tipo[recamara] = 2;

                } else {

                    System.out.println("LA BALA ERA FALSA, CONTINUA SU TURNO");
                    recamaraDisparo = 10;
                    tipo[recamara] = 2;
                    jugador++;

                }

                recamara++;

            }

        } else if (real < fals && real > 0){

            if (accion == 1){

                System.out.print("EL BOT TE APUNTA");
                for(int i = 0; i < 3; i++){
                    System.out.print(".");
                    Thread.sleep(750);
                }
                System.out.println();

                if (tipo[recamara] == 1){

                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                    recamaraDisparo = tipo[recamara];
                    tipo[recamara] = 2;

                } else {

                    System.out.println("LA BALA ERA FALSA");
                    recamaraDisparo = tipo[recamara];
                    tipo[recamara] = 2;


                }

                recamara++;

            } else {

                System.out.print("EL BOT SE APUNTA A EL");
                for(int i = 0; i < 3; i++){
                    System.out.print(".");
                    Thread.sleep(750);
                }
                System.out.println();

                if (tipo[recamara] == 1){

                    System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                    recamaraDisparo = 11;
                    tipo[recamara] = 2;

                } else {

                    System.out.println("LA BALA ERA FALSA, CONTINUA SU TURNO");
                    recamaraDisparo = 10;
                    tipo[recamara] = 2;
                    jugador++;

                }

                recamara++;

            }

        } else if (fals == 0){

            System.out.print("EL BOT TE APUNTA");
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                Thread.sleep(750);
            }
            System.out.println();

            if (tipo[recamara] == 1){

                System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            } else {

                System.out.println("LA BALA ERA FALSA");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            }

            recamara++;

        } else {

            System.out.print("EL BOT SE APUNTA A EL");
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                Thread.sleep(750);
            }
            System.out.println();

            if (tipo[recamara] == 1){

                System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA EL BOT");
                recamaraDisparo = 11;
                tipo[recamara] = 2;

            } else {

                System.out.println("LA BALA ERA FALSA, CONTINUA SU TURNO");
                recamaraDisparo = 10;
                tipo[recamara] = 2;
                jugador++;

            }

            recamara++;
        }

        return recamaraDisparo;
    }
    //==========================================================================================================================================================================
    //=============================================================================Partida Rápida===============================================================================
    //==========================================================================================================================================================================
    /*
    Hacer
    - Si solo hay 2 jugadores en pie no se preguntará a quien disparar


    */
    public static int PartidaRapida(String[] jugadores) throws InterruptedException {
        int partida = 0, ronda = 1, turno = (int) (Math.random() * 4), ganador;
        String op;
        tipo = recargar();
        recamara = 0;
        int[] vida = {0,0,0,0};
        for (int i = 0; i < 4; i++){
            if (!jugadores[i].equals("Sin asignar")){
                vida[i] = 3;
            }
        }
        //===========================================================MOSTRAR VIDA==================================================================
        do {
            //Compruebo que a quien le toca esté capacitado y si es 4 pasa a 0
            boolean ok = false;
            do {

                if (turno == 4){
                    turno = 0;
                }

                if (vida[turno] == 0){
                    turno++;
                } else {
                    ok = true;
                }

            }while (!ok);

            repetir = false;
            System.out.println("⬤⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃[Turno de " + jugadores[turno] + " ]⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⊂⊃⬤");
            System.out.print(" /");
            for (int i = 0; i < 4; i++){
                if (!jugadores[i].equals("Sin asignar")){
                    if (i != 0){
                        System.out.print("|");
                    }

                    String ini = jugadores[i].substring(0,3);
                    System.out.print("==" + ini.toUpperCase() + "==");

                }
            }
            System.out.print("\\\n|  ");
            for (int i = 0; i < 4; i++){
                if (!jugadores[i].equals("Sin asignar")){
                    if (i != 0){
                        System.out.print(" | ");
                    }
                    if (vida[i] > 0){
                        for (int j = 1; j <= vida[i]; j++) System.out.print("▮");
                        for (int j = 3; j > vida[i]; j--) System.out.print("▯");
                    } else {
                        System.out.print(" ╳ ╳ ╳ ");
                    }
                }
            }
            System.out.print("  |\n \\");
            for (int i = 0; i < 4; i++){
                if (!jugadores[i].equals("Sin asignar")){
                    if (i != 0){
                        System.out.print("|");
                    }
                    System.out.print("=======");
                }
            }
            System.out.println("/");
            //===========================================================FIN MOSTRAR VIDA==================================================================
            System.out.print(" //<><><><><><><><><><><><>\\\\\n||          ELIGE           ||\n \\\\<><><><><><><><><><><><>//\n1 - DISPARARTE\n2 - DISPARAR A OTRO\nRONDA " + ronda + " > ");
            op = sc.nextLine();
            if (op.equals("1")){

                vida[turno] -= dispararsePVP(jugadores[turno]);
                if (vida[turno] == 0){
                    System.out.println("EL JUGADOR " + jugadores[turno] + " HA SIDO ELIMINADO");
                }
                turno++;

            } else if (op.equals("2")){

                int quien;
                System.out.print(" //<><><><><><><><><><><><>\\\\\n||          ¿A QUIEN? (1-4)          ||\n \\\\<><><><><><><><><><><><>//\n - OTRO CARÁCTER PARA CANCELAR\n> ");
                try {

                    quien = Integer.parseInt(sc.nextLine());
                    //Evito que se pueda disparar a sí mismo y a objetivos no válidos
                    quien--;
                    if (quien >= 0 && quien < 4) {

                        if (quien == turno){

                            System.out.println("ERROR - OBJETIVO INVALIDO");

                        } else if (vida[quien] > 0) {

                            vida[quien] -= dispararPVP(jugadores[quien]);
                            if (vida[quien] == 0){
                                System.out.println("EL JUGADOR " + jugadores[quien] + " HA SIDO ELIMINADO");
                            }
                            turno++;

                        }else {
                            System.out.println("ERROR - OBJETIVO INVALIDO");
                        }
                    } else {
                        System.out.println("OPERACIÓN CANCELADA");
                    }

                }catch (Exception e){

                    System.out.println("OPERACIÓN CANCELADA");

                }

            } else {
                System.out.println("ERROR - OPCIÓN INVALIDA");
                repetir = true;
            }

            //Recargo si ya no hay balas
            if (recamara == balas){

                recargar();
                ronda++;

            }

            //Comppruebo si seguir o no
            int vivos = 0;

            for (int i = 0; i < 4; i++){
                if (vida[i] > 0){
                    vivos++;
                }
            }

            if (vivos > 1){
                repetir = true;
            }

        } while (repetir);

        return partida;
    }

    public static int dispararPVP(String jugador) throws InterruptedException {
        //==========================================================================================================================================================================
        //=============================================================================DISPARAR DE MODO PVP=========================================================================
        //==========================================================================================================================================================================
        int recamaraDisparo = 0;

            System.out.print("APUNTAS A " + jugador);
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                Thread.sleep(700);
            }
            System.out.println();

            if (tipo[recamara] == 1){

                System.out.println("LA BALA ERA REAL\n-1 DE VIDA PARA " + jugador);
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            } else {

                System.out.println("LA BALA ERA FALSA");
                recamaraDisparo = tipo[recamara];
                tipo[recamara] = 2;

            }
            recamara++;

        return recamaraDisparo;
    }
    public static int dispararsePVP(String jugador) throws InterruptedException {
        //==========================================================================================================================================================================
        //=============================================================================DISPARAR DE MODO PVP=========================================================================
        //==========================================================================================================================================================================
        int recamaraDisparo = 0;
        System.out.print("TE APUNTAS");
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            Thread.sleep(700);
        }
        System.out.println();

        if (tipo[recamara] == 1){

            System.out.println("LA BALA ERA REAL\n-1 DE VIDA");
            recamaraDisparo = tipo[recamara];
            tipo[recamara] = 2;

        } else {

            System.out.println("LA BALA ERA FALSA, CONTINUAS EN TU TURNO");
            recamaraDisparo = tipo[recamara];
            tipo[recamara] = 2;

        }
        recamara++;
        return recamaraDisparo;
    }

}
