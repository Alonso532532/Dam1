package Java.Basicos.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ej22 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Lleno el array con "vacio" para saber los que aún no están rellenos
        String[][] pueblos = new String[3][10];
        for (String[] pueblo : pueblos) {
            Arrays.fill(pueblo, "vacio");
        }
        do {
            int pro;
            do {
                System.out.print("¿Sobre que provincia quieres trabajar?\n" +
                        "| 1 - Zaragoza \n" +
                        "| 2 - Huesca \n" +
                        "| 3 - Teruel \n" +
                        "| 4 - Mostrar todos los pueblos\n" +
                        "| 5 - Salir \n> ");
                try {
                    pro = Integer.parseInt(sc.nextLine());
                    if (pro == 5)return;
                    if (pro == 4){mostrarTodo(pueblos);} else break;
                } catch (Exception e){
                    System.out.println("ERROR - Formato invalido");
                }
            } while (true);
            pro--;
            System.out.print("¿Que quieres hacer?\n" +
                    "| 1 - Mostrar pueblos por provincia  \n" +
                    "| 2 - Añadir pueblo\n" +
                    "| 3 - Buscar pueblo\n" +
                    "| s - Salir \n> ");
            String op = sc.nextLine();
            switch (op){
                case "1":
                    mostrarPueblos(pueblos[pro]);
                    break;
                case "2":
                    anadirPueblo(pueblos[pro]);
                    break;
                case "3":
                    buscarPueblo(pueblos[pro]);
                    break;
                case "s":
                    return;
                default:
                    System.out.println("ERROR - Opción invalida");
            }
        } while (true);

    }

    static void mostrarPueblos(String[] pueblos){
        int cont = 0;
        int j = 0;
        Arrays.sort(pueblos);
        for (String i : pueblos){
            if (!pueblos[j].equals("vacio")){
                cont++;
                System.out.println(cont + " - " + i);
            }
            j++;
        }
        System.out.print("Enter para continuar...");
        sc.nextLine();
    }

    static void mostrarTodo(String[][] pueblos){
        String[] provincias = {"Zaragoza","Huesca","Teruel"};
        for (int j = 0; j < pueblos.length; j++){
            Arrays.sort(pueblos[j]);
            System.out.print("|>>");
            for (int a = 0;a < provincias[j].length(); a++){
                System.out.print(">");
            }
            System.out.print(">>|\n");

            System.out.print("|< ");
            System.out.print(provincias[j]);
            System.out.print(" >|\n");

            System.out.print("|<<");
            for (int a = 0;a < provincias[j].length(); a++){
                System.out.print("<");
            }
            System.out.print("<<|\n");
            int cont = 0;
            for (String i : pueblos[j]){
                if (!pueblos[j][cont].equals("vacio")){
                    cont++;
                    System.out.println(cont + " - " + i);
                }

            }
        }
        System.out.print("Enter para continuar...");
        sc.nextLine();
    }

    static void anadirPueblo(String[] pueblos){
        System.out.print("¿Como se llama el pueblo?\n> ");
        String nombre = sc.nextLine();
        for (int i = 0; i < pueblos.length + 1; i++) {
            if (i == pueblos.length){
                System.out.println("El array está lleno");
            }else if (pueblos[i].equals("vacio")){
                pueblos[i] = nombre;
                break;
            }
        }
        mostrarPueblos(pueblos);
    }

    static void buscarPueblo(String[] pueblos){
        System.out.print("¿Que pueblo quieres buscar?\n> ");
        String nombre = sc.nextLine();
        boolean encontrado = false;
        int pos = 0;
        for (String i : pueblos){
            if (i.equalsIgnoreCase(nombre)){
                encontrado = true;
                break;
            }
            pos++;
        }
        if (encontrado){
            System.out.println("El pueblo " + pueblos[pos] + " está en la pos " + (pos+1));
        } else {
            System.out.println("El pueblo " + nombre + " no existe");
        }
        System.out.print("Enter para continuar...");
        sc.nextLine();
    }
}
