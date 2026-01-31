package Java.Medio.Rpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RPG {
    static Sala[][] salas = new Sala[9][3];
    static String[] mapa;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String op;
        // 102x25 parte externa
        // 100x23 parte interna
        // 100x12 combate
        // 100x10 cartas
        String[] pantalla = """
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┃                                                                                                    ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                    """.split("\n");
        pantalla[6] = pantalla[6].replace("                                                                                                    ", "                                       -*- PRESIONA ENTER -*-                                       ");
        for (String i : pantalla){
            System.out.println(i);
        }
        for (String i : pantalla){
            System.out.println(i);
        }
        System.out.print("┗─> ");
        sc.nextLine();
    }

    // <================================== | BORRAR | ==================================> \\
    static void vaciarCombate(String[] pantalla){
        for (int i = 1; i < 13; i++){
            pantalla[i] = "┃                                                                                                    ┃";
        }
    }
    static void vaciarMano(String[] pantalla){
        for (int i = 14; i < 24; i++){
            pantalla[i] = "┃                                                                                                    ┃";
        }
    }
    static void vaciarPantalla(String[] pantalla){
        vaciarCombate(pantalla);
        vaciarMano(pantalla);
    }

    // <================================== | MAPA | ==================================> \\
    static void mostrarMapa(String[] pantalla) {
        // <---------- | Genero el mapa vacío | ----------> \\
        for (int i = 1; i < 13; i++) {
            if (i == 1 || i == 12) {
                pantalla[i] = "┃▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░         ⮘    ⮚        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒┃";
            } else if (i == 2 || i == 11) {
                pantalla[i] = "┃▒▒▒▒░░░░░░░░░░░                                                                      ░░░░░░░░░░░▒▒▒▒┃";
            } else if (i == 3 || i == 10) {
                pantalla[i] = "┃▒▒▒░░░░░░                                                                                  ░░░░░░▒▒▒┃";
            } else if (i == 4 || i == 9) {
                pantalla[i] = "┃▒▒░░░░                                                                                        ░░░░▒▒┃";
            } else if (i == 5 || i == 8) {
                pantalla[i] = "┃▒░░                                                                                              ░░▒┃";
            } else {
                pantalla[i] = "┃░                                                                                                  ░┃";
            }
        }
    }

    static void generarMapa() {
        // <---------- | Genero en todas las columnas (cada 10 carácteres) de 1 a 3 salas y las añado al mapa | ----------> \\
        salas[0][1] = new Sala(10, ((int) (Math.random()*2+6)), "Inicio");
        for (int i = 1; i <= 8; i += 1){
            int[] generar = new int[3];
            boolean salir = false;
            while (!salir) {
                for (int j = 0; j < 3; j++) {
                    generar[j] = ((int) (Math.random() * 2));
                }
                for (int j = 0; j < 3; j++){
                    if (generar[j] == 1) {
                        salir = true;
                        boolean[] caminos = new boolean[3];
                        String tipo = "";
                        for (int a = 0; a < 3; a++){
                            if (((int)(Math.random()*2)) == 0){
                                caminos[a] = false;
                            } else {
                                caminos[a] = true;
                            }
                        }
                        switch ((int)(Math.random()*4)) {
                            case 0,1:
                                tipo = "Combate";
                                break;
                            case 2:
                                tipo = "Elite";
                                break;
                            case 3:
                                tipo = "Curio";
                                break;
                        }
                        salas[i][j] = new Sala((i+1)*10, (j+1)*3-((int) (Math.random() * 2)), tipo, caminos);
                    }
                }
            }
        }
//        int[][] salas = new int[9][3];
//        for (int i = 0; i < 9; i += 1){
//            if (i == 0 || i == 8){
//                salas[i][0] = (int) (Math.random()*2+6);
//            } else {
//                String repetidos = "";
//                for (int j = 0; j < ((int) (Math.random()*3+1)); j++){
//                    while (true) {
//                        int pos = (int) (Math.random() * 3+1);
//                        if (!repetidos.contains(String.valueOf(pos))) {
//                            repetidos = String.valueOf(pos);
//                            if (pos == 3) {
//                                salas[i][pos-1] = pos * 3 + ((int) (Math.random() * 3));
//                            } else if (pos == 2 || pos == 1) {
//                                salas[i][pos-1] = pos * 3 + 1 - ((int) (Math.random() * 2));
//                            }
//                            break;
//                        }
//                    }
//                }
//            }
//            for (int j = 0; j < 3; j++){
//                String sala = "□";
//                int tipo = (int) (Math.random()*4);
//                if (i > 2 && tipo == 0) sala = "■";
//                if (i > 1 && tipo == 1) sala = "?";
//                if (i == 4) sala = "◈";
//                if (i == 8) sala = "◆";
//                if (salas[i][j] != 0) {
//                    pantalla[salas[i][j]] = new StringBuilder(pantalla[salas[i][j]]).replace((i+1)*10, (i+1)*10+1, sala).toString();
//                }
//            }
//            System.out.println("-------------");
    }
}

