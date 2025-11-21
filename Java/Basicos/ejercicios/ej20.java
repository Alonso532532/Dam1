package Java.Basicos.ejercicios;
import java.util.ArrayList;
import java.util.Arrays;

public class ej20 {
    public static void main(String[] args) {
        int[] numeros = new int[21];

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = 11;
        }

        for (int i = 0; i < numeros.length; i++){
            int num;
            boolean repetir;

            do {
                repetir = false;
                num = (int) (Math.random() * 22 - 11);
                for (int j : numeros){
                    if (j == num){
                        repetir = true;
                    }
                }
            } while (repetir);
            numeros[i] = num;
        }

        for (int i : numeros){
            System.out.print("| " + i + " ");
        }
    }
}
