package Java.Basicos.ejercicios.Practica2;

import java.util.Arrays;
import java.util.Scanner;

public class Cosillasv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] numeros = new Integer[7];

        llenarArray(numeros);
        do {
            mostrarArray(numeros);
            System.out.print("┌ ¿Que quiere hacer?\n| 1 - Ordenar\n| 2 - Buscar (normal)\n| 3 - Buscar (binario, ordena)\n| 4 - Generar un nuevo array\n└> ");
            String op = sc.nextLine();
            switch (op){
                case "1":
                    ordenar(numeros);
                    break;
                case "2":
                    int buscarN = 0;
                    do {
                        try {
                            System.out.print("Dame un numero\n> ");
                            buscarN = Integer.parseInt(sc.nextLine());
                            break;
                        }catch (Exception e){
                            System.out.println("Bobo");
                            continue;
                        }
                    } while (true);
                    for (int i = 0; i < numeros.length; i++) {
                        if (buscarN == numeros[i]){
                            System.out.println("Numero encontrado en la pos " + (i+1));
                            buscarN = -1;
                            break;
                        }
                    }
                    if (buscarN!=-1){
                        System.out.println("El numero no ha sido encontrado");
                    }
                    break;
                case "3":
                    int buscarB = 0;
                    do {
                        try {
                            System.out.print("Dame un numero\n> ");
                            buscarB = Integer.parseInt(sc.nextLine());
                            break;
                        }catch (Exception e){
                            System.out.println("Bobo");
                            continue;
                        }
                    } while (true);

                    ordenar(numeros);
                    int busqueda = Arrays.binarySearch(numeros, buscarB)+1;
                    if (busqueda > 0){
                        System.out.println("Numero encontrado en la pos " + busqueda);
                    } else {
                        System.out.println("El numero no ha sido encontrado");
                    }
                    break;
                case "4":
                    llenarArray(numeros);
                    break;
            }
            if (!op.equals("4") && !op.equals("1")){
                System.out.print("Pulsa ENTER para continuar...");
                sc.nextLine();
            }
            System.out.println("<======================================>");
        }while (true);
    }
    public static void mostrarArray(Integer[] numeros){
        System.out.println(Arrays.toString(numeros));
    }
    public static void llenarArray(Integer[] numeros){
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = (int) (Math.random() * 10);
        }
    }
    public static void ordenar(Integer[] numeros){
        Arrays.sort(numeros);
    }
}
