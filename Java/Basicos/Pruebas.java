package Java.Basicos;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        int altura = (int) (Math.random() * 10 + 3), anchura = (int) (Math.random() * 10 + 3);
        if (altura%2 == 0){
            altura++;
        }
        String[][] cubo = new String [altura][anchura];

        System.out.println(altura + " " + anchura);

        for (int i = 0; i < altura; i++){
            for (int j = 0; j < anchura; j++){
                if (j == 0 || i == 0){
                    cubo[i][j] = "* ";
                }else if (j == anchura-1 || i == altura-1){
                    cubo[i][j] = "* ";
                }else if (altura/2 == i){
                    System.out.println("Iker Lozano Romero");
                }else {
                    cubo[i][j] = "  ";
                }
            }
        }

        for (int i = 0; i < altura; i++){
            for (int j = 0; j < anchura; j++){
                System.out.print(cubo[i][j]);
            }
            System.out.println();
        }

    }
}
