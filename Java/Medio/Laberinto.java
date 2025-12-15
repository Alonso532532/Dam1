package Java.Medio;
import java.util.Scanner;

public class Laberinto {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int[][] tablaLogica = new int[20][20];
        inicializacionLogica(tablaLogica);
        mostrarTabla(tablaLogica);
    }

    public static void mostrarTabla(int[][] tabla){
        for (int[] i: tabla){
            for (int j: i){
                System.out.print(" " + j + " ");
            }
            System.out.println();
        }
    }

    public static void inicializacionLogica(int[][] tabla){
        for (int i = 0; i < tabla.length; i++){
            for (int j = 0; j < tabla[0].length; j++){
                tabla[i][j] = 1;
            }
        }
        int[] pos = {0, (int) (Math.random() * (tabla[0].length-2) +1)};
        tabla[pos[0]][pos[1]] = 2;
        pos[0] = 1;
        tabla[pos[0]][pos[1]] = 0;
        boolean terminar = false;
        int ultimoMovimiento;
        int proximoMovimiento = 5;

        while (true){
            switch ((int) (Math.random()*4)){
                case 0:
                    if (pos[0] != 1){
                        pos[0] -= 1;
                        tabla[pos[0]][pos[1]] = 0;
                    }
                    break;
                case 1:
                    if (pos[0] != tabla.length-2){
                        pos[0] += 1;
                        tabla[pos[0]][pos[1]] = 0;
                    } else {
                        terminar = true;
                        pos[0] += 1;
                        tabla[pos[0]][pos[1]] = 0;
                    }
                    break;
                case 2:
                    if (pos[1] != 1){
                        pos[1] -= 1;
                        tabla[pos[0]][pos[1]] = 0;
                    }
                    break;
                case 3:
                    if (pos[1] != tabla[0].length-2){
                        pos[1] += 1;
                        tabla[pos[0]][pos[1]] = 0;
                    }
                    break;
            }
            if (terminar){
                break;
            }
        }

    }
}
        /*
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < tabla[0].length; j++){
                tabla[0][j] = 1;
                tabla[tabla.length-1][j] = 1;
            }
            for (int j = 0; j < tabla.length; j++){
                tabla[j][0] = 1;
                tabla[j][tabla[0].length-1] = 1;
            }
        }
        */