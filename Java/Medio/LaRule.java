package Java.Medio;
import java.util.Scanner;
import java.math.*;

public class LaRule {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String op;
            boolean repetir = true, tirar = false;
            int dinero = 1000;

            //--------------------TIRADA---------------------
            do {

                int[][] apuestas = new int[100][3];
                int napuesta = 0, num;

                //--------------------FASE DE APUESTA---------------------
                do{

                    //Le pregunto en que quiere apostar
                    do {
                        System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃   ◈ ¿En que quieres apostar? ◈    ┃\n┣━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━┫\n┃    1 - Color    ┃   2 - Número    ┃\n┣━━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━┫\n┃ 3 - Par o impar ┃ 4 - Grupo de 12 ┃\n┣━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━┫\n┃    5 - Para tirár de la ruleta    ┃\n┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n[ Saldo actual: " + dinero + "€ ]\n▶ ");

                        op = sc.nextLine();

                        if (!op.equals("1") && !op.equals("2") && !op.equals("3") && !op.equals("4") && !op.equals("5")) {
                            System.out.println("\n\n\n\n\n\n\n\n\n");
                            System.out.println("▷ ERROR: Opción invalida");
                        } else {
                            repetir = false;
                        }

                    } while (repetir);
                    System.out.println("\n\n\n\n\n\n\n\n\n");

                    if (op.equals("1")){
                        String opap;
                        repetir = true;
                        do {
                            //Le pregunto que color quiere, este se almacenará como un entero verde 42, negro 41 y rojo 40
                            System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃       ░▒▓█ ¿Que color? █▓▒░        ┃\n┣━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━┫\n┃██████████┃             ┃░░░░░░░░░░░┃\n┃ 1 - Rojo ┃  2 - Negro  ┃ 3 - Verde ┃\n┃██████████┃             ┃░░░░░░░░░░░┃\n┗━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━┛\n▶ ");
                            opap = sc.nextLine();
                            opap = opap.toLowerCase();
                                //Rojo 40
                            if (opap.equals("1")) {

                                apuestas[napuesta][0] = 40;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                //Negro 41
                            } else if (opap.equals("2")) {

                                apuestas[napuesta][0] = 41;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                //Verde 42
                            } else if (opap.equals("3")) {

                                apuestas[napuesta][0] = 42;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                            } else {
                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                System.out.println("▷ ERROR: Opción invalida");
                            }
                        } while (repetir);
                    } else if (op.equals("2")){

                        int opap;
                        repetir = true;
                        do {
                            //Le pregunto que número quiere, este se almacenará como un entero entre 0 y 36
                            System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃ ⑱⓫① ¿Que numero? ⓱⑨⓴ ┃\n┣━━━━━━━━━━━━━━━━━━━━━━━━┫\n┃███████         ░░░░░░░░┃\n┃█████ Entre 0 - 36 ░░░░░┃\n┃███████         ░░░░░░░░┃\n┗━━━━━━━━━━━━━━━━━━━━━━━━┛\n▶ ");
                            try {

                                opap = Integer.parseInt(sc.nextLine());
                                if (opap > 36) {

                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                    System.out.println("▷ ERROR: El numero debe ser entre 0 y 36");

                                } else if (opap < 0) {

                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                    System.out.println("▷ ERROR: El numero debe ser entre 0 y 36");

                                }else {

                                    apuestas[napuesta][0] = opap;
                                    repetir = false;
                                    System.out.println("\n\n\n\n\n\n\n\n\n");

                                }

                            } catch (NumberFormatException e){

                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                System.out.println("▷ ERROR: Formato erroneo");

                            }

                        } while (repetir);

                    } else if (op.equals("3")) {
                        String opap;
                        repetir = true;
                        do {
                            //Le pregunto si quiere par o impar
                            System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃ ❶②❸ ¿Par o impar? ④❺⑥ ┃\n┣━━━━━━━━━━━┳━━━━━━━━━━━━━┫\n┃ 1 - Par   ┃  2 - Impar  ┃\n┗━━━━━━━━━━━┻━━━━━━━━━━━━━┛\n▶ ");
                            opap = sc.nextLine();
                            //Par
                            if (opap.equals("1")) {

                                apuestas[napuesta][0] = 50;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                                //Impar
                            } else if (opap.equals("2")) {

                                apuestas[napuesta][0] = 51;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                            } else {
                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                System.out.println("▷ ERROR: Opción invalida");
                            }
                        }while (repetir);

                    } else if (op.equals("4")) {
                        String opap;
                        repetir = true;
                        do {
                            //Le pregunto si quiere par o impar
                            System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃         ▭▭▭ ¿Que grupo de 12? ▭▭▭         ┃\n┣━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┫\n┃  1 - 1 al 12  ┃ 2 - 13 al 24  ┃ 3 - 25 al 36  ┃\n┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┛\n▶ ");
                            opap = sc.nextLine();

                            if (opap.equals("1")) {

                                apuestas[napuesta][0] = 60;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                            } else if (opap.equals("2")) {

                                apuestas[napuesta][0] = 61;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                            } else if (opap.equals("3")) {

                                apuestas[napuesta][0] = 62;
                                repetir = false;
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                            } else {
                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                System.out.println("▷ ERROR: Opción invalida");
                            }
                        } while (repetir);
                    }

                    if (!op.equals("5")){
                        repetir = true;
                        do {
                            //Le pregunto que color quiere, este se almacenará como un entero verde 40, negro 41 y rojo 42

                            System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃ ◌◎◉◍ ¿Cuanto dinero? ◍◉◎◌ ┃\n┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n0 - Para cancelar\n[ Saldo actual: " + dinero + "€ ]\n▶ ");
                            try {
                                apuestas[napuesta][1] = Integer.parseInt(sc.nextLine());
                                if (apuestas[napuesta][1] > dinero){

                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                    System.out.println("▷ ERROR: La apuesta es superior al dinero disponible");

                                } else if (apuestas[napuesta][1] < 0) {

                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                    System.out.println("▷ ERROR: La apuesta no puede ser negativa");

                                }else {

                                    dinero -= apuestas[napuesta][1];
                                    repetir = false;
                                    System.out.println("\n\n\n\n\n\n\n\n\n");

                                }
                            } catch (NumberFormatException e){
                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                System.out.println("▷ ERROR: Formato invalido");
                            }
                        } while (repetir);
                        //Introduzco la ganancia en la fila o la borro si es 0
                        if (apuestas[napuesta][1] != 0){

                            //si es menor de 40 es un numero especifico
                            if (apuestas[napuesta][0] < 40){
                                apuestas[napuesta][2] = 35;

                                //si es menor de 50 es un color
                            }else if (apuestas[napuesta][0] < 50){

                                if (apuestas[napuesta][0] == 42){
                                    apuestas[napuesta][2] = 35;
                                }else {
                                    apuestas[napuesta][2] = 2;
                                }
                                //si es menor de 60 es par o impar
                            }else if (apuestas[napuesta][0] < 60){
                                apuestas[napuesta][2] = 2;

                                //si es mayor o igual a 60 es grupo de 12
                            }else {
                                apuestas[napuesta][2] = 3;
                            }

                            napuesta++;
                        } else {

                            apuestas[napuesta][0] = 0;
                            apuestas[napuesta][1] = 0;

                        }

                        repetir = true;
                        do {
                            //Le pregunto si quiere hacer otra apuesta si tiene dinero
                            if (dinero > 0){
                                System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃ ◎ ¿Quieres hacer otra apuesta? ◎ ┃\n┣━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┫\n┃      S - Si     ┃     N - No     ┃\n┗━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┛\n[ Saldo actual: " + dinero + "€ ]\n▶ ");

                                op = sc.nextLine();
                                op = op.toLowerCase();

                                if (!op.equals("s") && !op.equals("n")) {
                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                    System.out.println("▷ ERROR: Opción invalida");

                                } else {
                                    repetir = false;
                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                }
                            }else { repetir = false; }
                        } while (repetir);

                        //Si dice q si ps se repite que quieres que te diga pamplinas
                        if (op.equals("s")){
                            repetir = true;
                        }
                    }
                } while (repetir);

            //--------------------FASE DE RULEEE---------------------
                //hago el array con las posiciónes de las posibilidades y su color, rojo 40, negro 41 y verde 42
                int[][] rule =  {{0 ,32,15,19, 4,21, 2,25,17,34, 6,27,13,36,11,30, 8,32,10, 5,24,16,33, 1,20,14,31, 9,22,18,29, 7,28,12,35, 3,26},
                                 {42,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41,40,41}};
                //Divido el tiempo qiue va a tardar en cambiar de casilla entre un número al azar dando así la sensación de "fuerza" y voy sumando un 10% para que cada vez se frene más hasta que tarde 1s
                //Las posiciones las muestro con un array y un iterador, el iterador se inicializa con un número entre 0 y 36 y cuandollega a 36 se establece en 0 ortra vez
                int fuerza = (int) (Math.random() * 42 + 12), tiempo = 1250 / fuerza, i = (int) (Math.random() * 37), luz = 0;
                for (;tiempo < 1500;tiempo = (int) (tiempo * 1.1), i++){
                    System.out.println("\n\n\n\n\n\n\n\n\n");
                    if (luz == 0){
                        System.out.print(" ▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭ ⇘  ⇓  ⇙ ▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬\n");
                    } else {
                        System.out.print(" ▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬ ⇘  ⇓  ⇙ ▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭\n");
                    }
                    System.out.print("┏━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┳━━━━━━━┓\n┃");
                    //Calculo los numeros que se tienen de mostrar mostrando el numero de i sus 8 anteriores
                    for (int j = 9;j > 0; j--) {
                        int p = i - j;
                        if (p < 0) {p += 37;}

                        if (rule[1][p] == 40) {
                               System.out.print("███████┃");
                        } else if (rule[1][p] == 41) {
                            System.out.print("       ┃");
                        } else {
                            System.out.print("░░░░░░░┃");
                        }
                    }
                    System.out.print("\n|");
                    for (int j = 9;j > 0; j--) {
                        int p = i - j;
                        int num1, num2 = 0;
                        if (p < 0) {p += 37;}
                        //saco el primer y segundo carácter
                        num1 = rule[0][p] % 10;
                        if (rule[0][p] > 9) {
                            num2 = (rule[0][p] - num1) / 10;
                        }
                        //Los imprilmo de forma que no se corrompe la estructura
                        if (rule[0][p] > 9) {
                            if (rule[1][p] == 40) {
                                System.out.print("█ " + num2 + " " + num1 + " █┃");
                            } else if (rule[1][p] == 41) {
                                System.out.print("  " + num2 + " " + num1 + "  ┃");
                            } else {
                                System.out.print("░ " + num2 + " " + num1 + " ░┃");
                            }
                        } else {
                            if (rule[1][p] == 40) {
                                System.out.print("██ " + num1 + " ██┃");
                            } else if (rule[1][p] == 41) {
                                System.out.print("   " + num1 + "   ┃");
                            } else {
                                System.out.print("░░ " + num1 + " ░░┃");
                            }
                        }
                    }
                    System.out.print("\n|");
                    for (int j = 9;j > 0; j--) {
                        int p = i - j;
                        if (p < 0) {p += 37;}

                        if (rule[1][p] == 40) {
                            System.out.print("███████┃");
                        } else if (rule[1][p] == 41) {
                            System.out.print("       ┃");
                        } else {
                            System.out.print("░░░░░░░┃");
                        }
                    }
                    System.out.print("\n┗━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┻━━━━━━━┛\n");
                    if (luz == 0){
                        System.out.print(" ▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭ ⇗  ⇑  ⇖ ▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭\n");
                        luz = 1;
                    } else {
                        System.out.print(" ▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬ ⇗  ⇑  ⇖ ▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬▭▬\n");
                        luz = 0;
                    }
                    Thread.sleep(tiempo);

                    if (i >= 36){
                        i = -1;
                    }
                }
                //consigo la posición del vector y la almaceno en "i"
                i -= 6;
                if (i < 0){
                    i += 37;
                }
                int j = 0, cont = 0;
                while (apuestas[j][1] > 0) {

                    //si el numero es igual que por el que se ha apostado se lleva el premio
                    if (apuestas[j][0] == rule[0][i]){
                        cont += apuestas[j][1] * apuestas[j][2];
                        System.out.println("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar al " + apuestas[j][0]);

                        //si el color es igual que el de la posición del numero que ha tocado se lleva el premio
                    }else if (apuestas[j][0] == rule[1][i]){

                        cont += apuestas[j][1] * apuestas[j][2];
                        System.out.print("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar al ");
                        //Compruebo q color es
                        if (rule[1][i] == 40){
                            System.out.println("rojo");
                        } else if (rule[1][i] == 41) {
                            System.out.println("negro");
                        } else {
                            System.out.println("verde");
                        }

                        //si es 50 o 51 se a apostado por par o impar
                    }else if ((apuestas[j][0] == 50 && rule[0][i]%2 == 0) && rule[0][i] != 0){

                        cont += apuestas[j][1] * apuestas[j][2];
                        System.out.println("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar a los pares");


                    }else if ((apuestas[j][0] == 51 && rule[0][i]%2 == 1) && rule[0][i] != 0){

                        cont += apuestas[j][1] * apuestas[j][2];
                        System.out.println("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar a los impares");

                        //Compruebo los grupos de 12
                    }else {
                        if (apuestas[j][0] == 60 && rule[0][i] > 0 && rule[0][i] < 13){

                            cont += apuestas[j][1] * apuestas[j][2];
                            System.out.println("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar al primer grupo de 12");

                        } else if (apuestas[j][0] == 61 && rule[0][i] > 12 && rule[0][i] < 25){

                            cont += apuestas[j][1] * apuestas[j][2];
                            System.out.println("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar al segundo grupo de 12");

                        } else if (apuestas[j][0] == 62 && rule[0][i] > 24 && rule[0][i] < 37){

                            cont += apuestas[j][1] * apuestas[j][2];
                            System.out.println("▷ Has ganado " + (apuestas[j][1] * apuestas[j][2]) + " por apostar al tercer grupo de 12");

                            //Si no se cumple ninguna de las anteriores le digo cuanto a perdido y porque
                        } else {
                            System.out.print("▷ Has perdido " + apuestas[j][1] + " por apostar ");
                            if (apuestas[j][0] < 40){

                                System.out.println("al numero " + apuestas[j][0]);

                            }else if (apuestas[j][0] == 40){

                                System.out.println("al rojo");

                            } else if (apuestas[j][0] == 41) {

                                System.out.println("al negro");

                            } else if (apuestas[j][0] == 42){

                                System.out.println("al verde");

                            } else if (apuestas[j][0] == 50){

                                System.out.println("a los pares");

                            } else if (apuestas[j][0] == 51){

                                System.out.println("a los impares");

                            } else if (apuestas[j][0] == 60){

                                System.out.println("al primer grupo de 12");

                            } else if (apuestas[j][0] == 61){

                                System.out.println("al segundo grupo de 12");

                            } else if (apuestas[j][0] == 62){

                                System.out.println("al tercer grupo de 12");

                            }
                        }
                    }
                    j++;
                }
                dinero += cont;
                if (cont > 0) {
                    System.out.println("▷ En total has ganado " + cont + "€ ◁");
                }

                if (dinero != 0) {
                    System.out.println("[ Saldo actual: " + dinero + "€ ]");
                    tirar = false;
                    repetir = true;
                    do {
                        //Le pregunto si quiere volver a tirar si dice q si se repite toda la fase de apuestas y ruleta además de declararse apuestas, napuestas para evitar fallos
                        System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃ ◌ ◉ ¿Quieres volver a tirar? ◉ ◌ ┃\n┣━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┫\n┃     S - Si      ┃     N - No     ┃\n┗━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┛\n▶ ");
                        op = sc.nextLine();
                        op = op.toLowerCase();

                        if (!op.equals("s") && !op.equals("n")) {
                            System.out.println("\n\n\n\n\n\n\n\n\n");
                            System.out.println("▷ ERROR: Opción invalida");

                        } else {
                            repetir = false;
                            System.out.println("\n\n\n\n\n\n\n\n\n");
                            if (op.equals("s")) {
                                tirar = true;
                            }
                        }
                    } while (repetir);
                } else {
                    System.out.println("[ Te has quedado sin dinero ]");
                }
            }while (tirar);

            //--------------------FASE DE REPETICIÓN---------------------
            repetir = true;

            do {
                //Le pregunto si quiere repetir si dice q si se repite todo, incluyendo la declaración de variables
                System.out.print("┏━━━━━━━━━━━━━━━━━━━━━━━━┓\n┃ ⟳ ¿Quieres repetir? ⟲ ┃\n┣━━━━━━━━━━━┳━━━━━━━━━━━━┫\n┃  S - Si   ┃   N - No   ┃\n┗━━━━━━━━━━━┻━━━━━━━━━━━━┛\n▶ ");
                op = sc.nextLine();
                op = op.toLowerCase();

                if (!op.equals("s") && !op.equals("n")) {
                    System.out.println("\n\n\n\n\n\n\n\n\n");
                    System.out.println("▷ ERROR: Opción invalida");

                } else {
                    repetir = false;
                    if (op.equals("n")){
                        return;
                    }
                    System.out.println("\n\n\n\n\n\n\n\n\n");
                }

            } while (repetir);
        }
    }
}
