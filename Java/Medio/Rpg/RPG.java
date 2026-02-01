package Java.Medio.Rpg;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RPG {
    static Sala[][] salas = new Sala[9][3];
    static String[] mapa = new String[14];
    static String[] pantalla = """
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
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String op;
        // 102x25 parte externa
        // 100x23 parte interna
        // 100x12 combate
        // 100x10 cartas
        pantalla[6] = pantalla[6].replace("                                                                                                    ", "                                       -*- PRESIONA ENTER -*-                                       ");
        for (String i : pantalla){
            System.out.println(i);
        }
        generarMapa();
        mostrarMapa();
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
    static void generarMapa() {
        // <---------- | Genero el mapa vacío | ----------> \\
        for (int i = 0; i < 14; i++) {
            if (i == 0) {
                mapa[i] = "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓";
            } else if (i == 13) {
                mapa[i] = "┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫";
            } else if (i == 1 || i == 12) {
                mapa[i] = "┃▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░         ⮘    ⮚        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒┃";
            } else if (i == 2 || i == 11) {
                mapa[i] = "┃▒▒▒▒░░░░░░░░░░░                                                                      ░░░░░░░░░░░▒▒▒▒┃";
            } else if (i == 3 || i == 10) {
                mapa[i] = "┃▒▒▒░░░░░░                                                                                  ░░░░░░▒▒▒┃";
            } else if (i == 4 || i == 9) {
                mapa[i] = "┃▒▒░░░░                                                                                        ░░░░▒▒┃";
            } else if (i == 5 || i == 8) {
                mapa[i] = "┃▒░░                                                                                              ░░▒┃";
            } else {
                mapa[i] = "┃░                                                                                                  ░┃";
            }
        }
        // <---------- | Genero en todas las columnas (cada 10 carácteres) de 1 a 3 salas y las añado al mapa | ----------> \\
        salas[0][1] = new Sala(10, ((int) (Math.random()*2+6)), "Inicio: ◇");
        salas[8][1] = new Sala(90, ((int) (Math.random()*2+6)), "Boss: ◆");
        for (int i = 1; i <= 7; i += 1){
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
                        if (i == 1){
                            tipo = "Combate: □";
                        } else if (i == 2){
                            switch ((int)(Math.random()*4)) {
                                case 0,1,2:
                                    tipo = "Combate: □";
                                    break;
                                case 3:
                                    tipo = "Curio: ?";
                                    break;
                            }
                        } else {
                            switch ((int)(Math.random()*4)) {
                                case 0,1:
                                    tipo = "Combate: □";
                                    break;
                                case 2:
                                    tipo = "Elite: ■";
                                    break;
                                case 3:
                                    tipo = "Curio: ?";
                                    break;
                            }
                        }
                        if (i == 4) tipo = "Tienda: ◈";
                        salas[i][j] = new Sala((i+1)*10, (j+1)*3+1-((int) (Math.random() * 2)), tipo, caminos);
                    }
                }
                for (Sala[] j : salas){
                    for (Sala a : j){
                        if (a != null){
                            Matcher icono = Pattern.compile(": .").matcher(a.getTipo());
                            if (icono.find()){
                                mapa[a.getFila()] = new StringBuilder(mapa[a.getFila()]).replace(a.getColumna(), a.getColumna()+1, icono.group().replace(": ", "")).toString();
                            }
                        }
                    }
                }
            }
        }
    }
    static void mostrarMapa(){
        for (int i = 0; i < 25; i++){
            if (i < 14){
                System.out.println(mapa[i]);
            } else {
                System.out.println(pantalla[i]);
            }
        }
    }
}

