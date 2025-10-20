package Java.Basicos;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] cad = {{0,1,3},{4,5,6,}};

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(cad[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("Dame un texto\n> ");

    }
}
