package Java.Medio.Rpg;

import java.util.Scanner;

public class RPG {
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
        generarMapa(pantalla);
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
    static void generarMapa(String[] pantalla){
        // <---------- | Genero el mapa vacío | ----------> \\
        for (int i = 1; i < 13; i++){
            if (i == 1 || i == 12){
                pantalla[i] = "┃▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░         ⮘    ⮚        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒┃";
            } else if (i == 2 || i == 11) {
                pantalla[i] = "┃▒▒▒▒░░░░░░░░░░░                                                                      ░░░░░░░░░░░▒▒▒▒┃";
            } else if (i == 3 || i == 10) {
                pantalla[i] = "┃▒▒▒░░░░░░                                                                                  ░░░░░░▒▒▒┃";
            }  else if (i == 4 || i == 9) {
                pantalla[i] = "┃▒▒░░░░                                                                                        ░░░░▒▒┃";
            }  else if (i == 5 || i == 8) {
                pantalla[i] = "┃▒░░                                                                                              ░░▒┃";
            } else {
                pantalla[i] = "┃░                                                                                                  ░┃";
            }
        }
        // <---------- | Genero en todas las columnas de 1 a 3 salas y las añado al mapa | ----------> \\
        int[][] salas = new int[9][3];
        for (int i = 0; i < 9; i += 1){
            if (i == 0 || i == 8){
                salas[i][0] = (int) (Math.random()*2+6);
            } else {
                String repetidos = "";
                for (int j = 0; j < ((int) (Math.random()*3+1)); j++){
                    while (true) {
                        int pos = (int) (Math.random() * 3+1);
                        if (!repetidos.contains(String.valueOf(pos))) {
                            repetidos = String.valueOf(pos);
                            if (pos == 3) {
                                salas[i][pos-1] = pos * 3 + ((int) (Math.random() * 3));
                            } else if (pos == 2 || pos == 1) {
                                salas[i][pos-1] = pos * 3 + 1 - ((int) (Math.random() * 2));
                            }
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < 3; j++){
                String sala = "□";
                if (i == 4) sala = "◈";
                if (salas[i][j] != 0) {
                    pantalla[salas[i][j]] = new StringBuilder(pantalla[salas[i][j]]).replace((i+1)*10, (i+1)*10+1, sala).toString();
                }
            }
            System.out.println("-------------");
        }
    }

    // <================================== |  | ==================================> \\
}
