package Java.Basicos.ejercicios;
import java.util.Arrays;
import java.util.Scanner;

public class ej21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuantos enteros quieres?\n> ");
        int tamano = sc.nextInt();
        System.out.print("Dame un minimo\n> ");
        int min = sc.nextInt();
        System.out.print("Y un maximo\n> ");
        int max = sc.nextInt();

        if (min > max)return;

        int[] numeros = IntArray(tamano, min, max);
        showArray(numeros);

        System.out.print("Dame un numero que buscar\n> ");
        int buscar = sc.nextInt();

        if (find(numeros, buscar) < 0){
            System.out.println("El numero no está");
        } else {
            System.out.println("El numero " + buscar + " está en la posición " + find(numeros, buscar));
        }

        System.out.print("Dame otro numero que buscar\n> ");
        buscar = sc.nextInt();

        int pos;
        do {
            System.out.print("Desde que posición\n> ");
            pos = sc.nextInt();
            if (pos < numeros.length){

            }
        } while (pos > numeros.length);
    }

    static int[] IntArray(int tamano, int min, int max){
        int[] numeros = new int[tamano];
        for (int i = 0; i < numeros.length ; i++){
            numeros[i] = (int) (Math.random() * (max+1 - min) + min);
        }
        return numeros;
    }

    static void showArray(int[] numeros){
        for (int i : numeros){
            System.out.print("| " + i + " ");
        }
        System.out.println("|");
    }

    static int find(int[] numeros, int buscar){
        for (int i = 0; i < numeros.length; i++){
            if(numeros[i] == buscar){
                return i;
            }
        }
        return -1;
    }

    static int find(int[] numeros, int buscar, int desde){
        desde--;
        int[] nuevoNumeros = Arrays.copyOfRange(numeros, desde, numeros.length);
        return buscar;
    }

}