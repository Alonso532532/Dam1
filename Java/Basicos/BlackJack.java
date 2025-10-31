package Java.Basicos;

import java.math.*;
import java.util.*;

public class BlackJack {

    //-------------------------CALCULAR VALOR DE MANO--------------------------
    static int calcularMano(int[][] manof, int quien) {
        int contf = 0;
        boolean as = false;

        for (int i = 0; i != 9; i++){
            if (manof[quien][i] == 1) {
                contf++;
                as = true;
            }else if (manof[quien][i] != 0) {
                contf = contf + manof[quien][i];
            }
        }
        if (as && contf < 11){
            contf = contf + 10;
        }
        return contf;
    }

    //-------------------------SACAR CARTA--------------------------
    public static int sacarCarta(int[] barajaf, int jugadorf,int[][] manof) {
        boolean cambio = false;
        int carts;
        do {
            carts = (int)(Math.random()*13);
            carts++;

            for (int i = 0; cambio == false && i != 52; i++){
                if (barajaf[i] == carts){
                    cambio = true;
                    barajaf[i] = 0;
                }
            }
        } while (!cambio);

        cambio = false;
        for (int i = 0;cambio == false; i++){
            if (manof[jugadorf][i] == 0){
                manof[jugadorf][i] = carts;
                cambio = true;
            }
        }

        return carts;
    }

    //-------------------------MOSTRAR MANO--------------------------
    static void mostrarMano(int[][] verdadera) {
        int cont = 0;
        int contg = 4;
        boolean as = false;

        for (int i = 0; i != 9; i++){
            if (verdadera[0][i] == 1) {
                contg = contg + 14;
            } else if (verdadera[0][i] == 10) {
                contg = contg + 5;
            } else if (verdadera[0][i] != 0) {
                contg = contg + 4;
            }
        }
        contg = contg - 3;
        for (int i = 0; i < contg; i++){
            System.out.print("-");
        }
        System.out.println();
        System.out.print("| ");
        for (int i = 0; i != 9; i++){
            if (verdadera[0][i] == 1) {
                System.out.print("As - 1 o 11");
                cont++;
                as = true;
            }else if (verdadera[0][i] != 0) {
                System.out.print(verdadera[0][i]);
                cont = cont + verdadera[0][i];
            }

            if (verdadera[0][i+1] != 0 && i < 9) {
                System.out.print(" | ");
            }
        }
        System.out.println(" |");
        for (int i = 0; i < contg; i++){
            System.out.print("-");
        }
        System.out.println();

        if (as && cont - 1 < 11) {
            System.out.println("< Total: " + (cont + 10) + " >");
        } else {
            System.out.println("< Total: " + cont + " >");
        }

        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String repetir = "n";

        do {
            int dinero = 100;
            int apuesta;
            do {
                apuesta = 0;
                boolean valido = false;

                while (!valido) {
                    System.out.print("Tienes " + dinero + "€, ¿Cuánto quieres apostar?\n> ");

                    try {
                        apuesta = Integer.parseInt(sc.nextLine());

                        if (apuesta <= 0) {
                            System.out.println("Debes apostar un número positivo");
                        } else if (apuesta > dinero) {
                            System.out.println("No tienes suficiente dinero");
                        } else {
                            valido = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada invalida");
                    }
                }

                dinero -= apuesta;

                int[][] mano = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};

                int[] baraja = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

                int jugador = 0;
                int manoP1 = 0;
                boolean fin = false;
                boolean pasadou = false;
                boolean pasadoc = false;
                int cont;

                //-------------------------REPARTO DE 2--------------------------
                for (int i = 0; i != 4; i++){
                    sacarCarta(baraja, jugador, mano);
                    if (jugador == 0){
                        jugador++;
                    }else {
                        jugador--;
                    }
                }
                //-------------------------CRUPIER--------------------------
                jugador = 1;
                boolean rep;
                do {
                    rep = false;
                    cont = calcularMano(mano, jugador);

                    if (cont < 17){
                        rep = true;
                        sacarCarta(baraja, jugador, mano);
                    } else if (cont > 21){
                        pasadoc = true;
                    }

                }while(rep);
                jugador = 0;
                //-------------------------JUGADOR--------------------------
                do {
                    mostrarMano(mano);

                    String op;

                    cont = calcularMano(mano, jugador);

                    if (cont == 21){
                        System.out.println("21 EXACTOS!!");
                        fin = true;
                    } else if (cont > 21){
                        pasadou = true;
                        fin = true;
                    } else {
                        do {
                            System.out.print("¿Que quieres hacer?\n1- Pedir carta\n2- Plantarse\n> ");
                            op = sc.nextLine();
                            if (!op.equals("1") && !op.equals("2")) {
                                System.out.println("Carácter inválido");
                                mostrarMano(mano);
                            }
                        } while (!op.equals("1") && !op.equals("2"));
                        if (op.equals("1")){
                            sacarCarta(baraja, jugador, mano);
                        } else{
                            fin = true;
                        }
                    }
                } while(!fin);

                //-------------------FINAL------------------
                int ganador = 1;
                System.out.println("------------------------------------------------------------------------");
                if (pasadou && pasadoc){
                    System.out.println("- Os habéis pasado los dos, tú con un " + calcularMano(mano, jugador) + " y el crupier con un " + calcularMano(mano, jugador = 1));
                    ganador = 0;
                } else if (pasadou && !pasadoc){
                    System.out.println("- Te has pasado con un " + calcularMano(mano, jugador) + " y el crupier ha sacado un " + calcularMano(mano, jugador = 1));
                    ganador = 0;
                } else if (!pasadou && pasadoc){
                    System.out.println("- Has ganado con un " + calcularMano(mano, jugador) + " y el crupier se ha pasado con un " + calcularMano(mano, jugador = 1));
                    ganador = 2;
                } else {
                    int jug = calcularMano(mano, 0);
                    int crup = calcularMano(mano, 1);

                    if (jug < crup) {
                        System.out.println("- Ha ganado el crupier con un " + crup + " frente a tu " + jug);
                        ganador = 0;
                    } else if (jug > crup) {
                        System.out.println("- Has ganado al crupier con un " + jug + " frente a su " + crup);
                        ganador = 2;
                    } else {
                        System.out.println("- Empate de tus " + jug + " frente a sus " + crup + " puntos");
                    }
                }
                System.out.println("------------------------------------------------------------------------");
                if (ganador == 2){
                    System.out.println("+" + apuesta + "€!!");
                } else if (ganador == 0){
                    System.out.println("-" + apuesta + "€!!");
                }
                apuesta = apuesta * ganador;
                dinero = dinero + apuesta;
            } while (dinero > 0);
            //-------------------REPETIR------------------
            do {
                System.out.print("¡Te has quedado sin dinero! ¿Quieres repetir? (s/n)\n> ");
                repetir = sc.nextLine();
                if (!repetir.equals("n") && !repetir.equals("s") && !repetir.equals("N") && !repetir.equals("S")) {
                    System.out.println("Carácter invalido");
                }
            } while(!repetir.equals("n") && !repetir.equals("s") && !repetir.equals("N") && !repetir.equals("S"));
        } while (repetir.equals("s") || repetir.equals("S"));
    }
}