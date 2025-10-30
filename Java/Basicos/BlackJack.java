package Java.Basicos;

import java.util.*;

public class BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char repetir = 'n';

        do {
            int[][] mano = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};

            int[] baraja = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};

            int jugador = 1;
            int manoP1 = 0;
            boolean fin = false;
            boolean pasado = false;


            for (int i = 0; i != 4; i++){
                sacarCarta(baraja, jugador, mano);
                if (jugador == 1){
                    jugador++;
                }else {
                    jugador--;
                }
            }

            do {
                mostrarMano(mano);

                char op;
                boolean as = false;
                int cont = 0;

                for (int i = 0; i != 9; i++){
                    if (mano[0][i] == 1) {
                        cont++;
                        as = true;
                    }else if (mano[0][i] != 0) {
                        cont = cont + mano[0][i];
                    }
                }
                if (as && cont < 11){
                    cont = cont + 10;
                }

                if (cont == 21){
                    System.out.println("Has alcanzado 21");
                    fin = true;
                } else if (cont > 21){
                    System.out.println("Te has pasado");
                    pasado = true;
                    fin = true;
                } else {
                    do {
                        System.out.print("¿Que quieres hacer?\n1- Pedir carta\n2- Plantarse\n> ");
                        op = sc.nextLine().charAt(0);
                        if (op != '1' && op != '2') {
                            System.out.println("Carácter inválido");
                        }
                    } while (op != '1' && op != '2');
                    if (op == '1'){
                        sacarCarta(baraja, jugador, mano);
                    } else if (op == '2'){
                        fin = true;
                    }
                }
            } while(!fin);

            if (pasado){
                System.out.println("Has perdido");
            }

            do {
                System.out.print("¿Quieres repetir? (s/n)\n> ");
                repetir = sc.nextLine().charAt(0);
                if (repetir != 'n' && repetir != 's' && repetir != 'N' && repetir != 'S') {
                    System.out.println("Carácter erroneo");
                }
            } while(repetir != 'n' && repetir != 's' && repetir != 'N' && repetir != 'S');
        } while (repetir == 's' || repetir == 'S');
    }

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

        if (jugadorf == 1){
            cambio = false;
            for (int i = 0;cambio == false; i++){
                if (manof[0][i] == 0){
                    manof[0][i] = carts;
                    cambio = true;
                }
            }
        } else {
            cambio = false;
            for (int i = 0;cambio == false; i++){
                if (manof[1][i] == 0){
                    manof[1][i] = carts;
                    cambio = true;
                }
            }
        }
        return carts;
    }

    static void mostrarMano(int[][] verdadera) {
        int cont = 0;
        int contg = 4;
        boolean as = false; // <--------

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
}
