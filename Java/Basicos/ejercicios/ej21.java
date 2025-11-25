package Java.Basicos.ejercicios;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Vector;

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

        int desde;
        do {
            System.out.print("Desde que posición\n> ");
            desde = sc.nextInt();
            if (desde < numeros.length){
                System.out.println("El numero " + buscar + " empezando desde la posición " + desde + " está en la posición " + find(numeros, buscar, desde));
            }
        } while (desde > numeros.length);

        System.out.println("\nEl valor más grande es: " + getMax(numeros));
        System.out.println("\nEl valor más pequeño es: " + getMin(numeros));
        System.out.println("\nLa suma de sus valores es de: " + getSum(numeros));
        System.out.print("\nLa media de sus valores es de: ");
        System.out.printf("%.2f\n", getAvg(numeros));

        double[] nuevo = getStats(numeros);
        System.out.print("--------------------------------\nAhora hecho en una sola función\nMáximo: " + (int) nuevo[0] + "\nMínimo: " + (int) nuevo[1] + "\nSuma: " + (int) nuevo[2] + "\nMedia: ");
        System.out.printf("%.2f", nuevo[3]);
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
        int[] nuevoNumeros = Arrays.copyOfRange(numeros, desde, numeros.length);
        for (int i = 0; i < nuevoNumeros.length; i++){
            if(nuevoNumeros[i] == buscar){
                return i + desde;
            }
        }
        return buscar;
    }
    static int getMin(int[] numeros){
        int min = numeros[0];
        for(int i : numeros){
            if(min > i){
                min = i;
            }
        }
        return min;
    }

    static int getMax(int[] numeros){
        int max = numeros[0];
        for(int i : numeros){
            if(max < i){
                max = i;
            }
        }
        return max;
    }

    static int getSum(int[] numeros){
        int resp = 0;
        for(int i : numeros){
            resp += i;
        }
        return resp;
    }

    static double getAvg(int[] numeros){
        return (double) getSum(numeros) /numeros.length;
    }

    static double[] getStats(int[] numeros){
        double[] resp = new double[4];
        int max = numeros[0];
        int min = numeros[0];
        int cont = 0;
        for(int i : numeros){
            if(max < i){
                max = i;
            }
            if(min > i){
                min = i;
            }
            cont += i;
        }
        resp[0] = max;
        resp[1] = min;
        resp[2] = cont;
        resp[3] = (double) cont/numeros.length;
        return resp;
    }
}