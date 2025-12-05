package Java.Basicos.ejercicios.Practica2;

import java.util.Scanner;

public class cosillas {
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
                    try {
                        System.out.print("Dame un numero\n> ");
                        buscarN = Integer.parseInt(sc.nextLine());
                    }catch (Exception e){
                        System.out.println("Bobo");
                        continue;
                    }
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
                    ordenar(numeros);
                    int buscarB = 0;
                    try {
                        System.out.print("Dame un numero\n> ");
                        buscarB = Integer.parseInt(sc.nextLine());
                    }catch (Exception e){
                        System.out.println("Bobo");
                        continue;
                    }
                    int ini = 0;
                    int fin = numeros.length-1;
                    while (ini <= fin){
                        int medio = (fin - ini) /2 +ini;
                        if (numeros[medio] == buscarB){
                            System.out.println("Numero " + buscarB + " encontrado en la posición " + (medio+1));
                            ini = -1;
                            break;
                        } else if (buscarB > numeros[medio]){
                            ini = medio+1;
                        } else {
                            fin = medio-1;
                        }
                    }
                    if (ini!=-1){
                        System.out.println("El numero no ha sido encontrado");
                    }
                    sc.nextLine();
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
        for (int i : numeros){
            System.out.print("| " + i + " ");
        }
        System.out.println("|");
    }
    public static void llenarArray(Integer[] numeros){
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = (int) (Math.random() * 10);
        }
    }
    public static void ordenar(Integer[] numeros){
        int cambios;
        do {
            cambios = 0;
            for (int i = 0; i < numeros.length-1; i++) {
                if (numeros[i] > numeros[i+1]){
                    cambios++;
                    int otro = numeros[i];
                    numeros[i] = numeros[i+1];
                    numeros[i+1] = otro;
                }
            }
        }while (cambios != 0);
    }
}
