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
                fin = true;
            } while(!fin);

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
        int as = 0; // <--------

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

        if (as == 0) {
            System.out.println("< Total: " + cont + " >");
        }

        return;
    }
}
