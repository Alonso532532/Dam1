package Java.Basicos;
import java.util.Scanner;


public class TresEnRaya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean seguir = true;
        char [][] tabla = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        int jugador = 1;
        int cambios = 0;
        boolean ganado = false;

        do {

            int j = 0;
            for (int i = 1; i < 8 ; i++) {

                if (i % 2 == 1) {
                    System.out.println("-------------");
                    j++;
                } else if (i % 2 == 0) {
                    System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                }

            }
            System.out.println("Jugador " + jugador);
            System.out.print("En que posición quieres\n> ");
            while (!sc.hasNextInt()){
                j = 0;
                for (int a = 1; a < 8 ; a++) {

                    if (a % 2 == 1) {
                        System.out.println("-------------");
                        j++;
                    } else if (a % 2 == 0) {
                        System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                    }

                }
                System.out.println("No es un número entero");
                System.out.print("Introduce un número entero\n> ");
                sc.nextLine();
            }
            int pos = sc.nextInt() + 48;

            boolean cambio = false;

            for (int i = 0; i < 3 ; i++){
                for (j = 0; j < 3 ; j++){
                    if (tabla[i][j] == pos && jugador == 1){
                        tabla[i][j] = 'O';
                        jugador = 2;
                        cambio = true;
                        cambios++;
                    } else if (tabla[i][j] == pos && jugador == 2){
                        tabla[i][j] = 'X';
                        jugador = 1;
                        cambio = true;
                        cambios++;
                    }
                }
            }
            if (pos > 57) {
                System.out.println("Posición incorrecta");
            } else if (cambio == false){
                System.out.println("Posición ya ocupada");
            }
            for (int i = 0; i < 3 ; i++){

                if (tabla[i][0] == tabla[i][1] && tabla[i][1] == tabla[i][2] && ganado == false){
                    seguir = false;
                    ganado = true;
                    if (tabla[i][0] == 'O'){
                        System.out.println("Ha ganado el jugador 1");
                    } else {
                        System.out.println("Ha ganado el jugador 2");
                    }

                    j = 0;
                    for (int a = 1; a < 8 ; a++) {

                        if (a % 2 == 1) {
                            System.out.println("-------------");
                            j++;
                        } else if (a % 2 == 0) {
                            System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                        }

                    }
                }

                if (tabla[0][i] == tabla[1][i] && tabla[1][i] == tabla[2][i] && ganado == false){
                    seguir = false;
                    ganado = true;
                    if (tabla[i][0] == 'O'){
                        System.out.println("Ha ganado el jugador 1");
                        ganado = true;
                    } else {
                        System.out.println("Ha ganado el jugador 2");
                        ganado = true;
                    }
                    j = 0;
                    for (int a = 1; a < 8 ; a++) {

                        if (a % 2 == 1) {
                            System.out.println("-------------");
                            j++;
                        } else if (a % 2 == 0) {
                            System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                        }

                    }
                }
            }

            if (tabla[0][0] == tabla[1][1] && tabla[1][1] == tabla[2][2] && ganado == false){
                seguir = false;
                ganado = true;
                if (tabla[0][0] == 'O'){
                    System.out.println("Ha ganado el jugador 1");
                } else {
                    System.out.println("Ha ganado el jugador 2");
                }
                j = 0;
                for (int a = 1; a < 8 ; a++) {

                    if (a % 2 == 1) {
                        System.out.println("-------------");
                        j++;
                    } else if (a % 2 == 0) {
                        System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                    }

                }
            } else if (tabla[0][2] == tabla[1][1] && tabla[1][1] == tabla[2][0] && ganado == false){
                seguir = false;
                ganado = true;
                if (tabla[2][0] == 'O'){
                    System.out.println("Ha ganado el jugador 1");
                } else {
                    System.out.println("Ha ganado el jugador 2");
                }
                j = 0;
                for (int a = 1; a < 8 ; a++) {

                    if (a % 2 == 1) {
                        System.out.println("-------------");
                        j++;
                    } else if (a % 2 == 0) {
                        System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                    }

                }
            }

        } while (seguir && cambios < 9);
        if (cambios == 9 && seguir == true){

            int j = 0;
            for (int a = 1; a < 8 ; a++) {

                if (a % 2 == 1) {
                    System.out.println("-------------");
                    j++;
                } else if (a % 2 == 0) {
                    System.out.println("| " + tabla[j-1][0] + " | " + tabla[j-1][1] + " | " + tabla[j-1][2] + " |");
                }

            }
            System.out.println("No hay más espacios");
        }
    }
}

