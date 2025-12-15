package Java.Medio;
import java.util.Scanner;

public class Laberinto {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int[][] tablaLogica = new int[8][8];
        inicializacionLogica(tablaLogica);
        mostrarTabla(tablaLogica);
    }

    public static void mostrarTabla(int[][] tabla){
        for (int i = 0; i < tabla.length; i++){
            for (int j: tabla[i]){
                System.out.print(" " + j + " ");
            }
            System.out.println();
        }
    }

    public static void inicializacionLogica(int[][] tabla){
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
    }
}
