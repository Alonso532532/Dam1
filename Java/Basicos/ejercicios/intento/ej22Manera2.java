package Java.Basicos.ejercicios.intento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej22Manera2 {
    //Creo el array list
    static ArrayList<provincias> provinciasArray = new ArrayList<provincias>();
    static Scanner sc = new Scanner(System.in);
    static void main() {
        //Añado varias provincias
        provinciasArray.add(new provincias("Zaragoza"));
        provinciasArray.add(new provincias("Huesca"));
        provinciasArray.add(new provincias("Teruel"));
        // Y pueblos
        provinciasArray.get(0).pueblos.add("pueblo1");
        provinciasArray.get(0).pueblos.add("pueblo2");
        provinciasArray.get(0).pueblos.add("pueblo3");
        provinciasArray.get(0).pueblos.add("pueblo4");
        provinciasArray.get(0).pueblos.add("pueblo5");
        provinciasArray.get(0).pueblos.add("pueblo6");

        provinciasArray.get(1).pueblos.add("pueblo1");
        provinciasArray.get(1).pueblos.add("pueblo2");


        //muestro de forma numerada las provincias para el menú
        System.out.println("¿Con que provincia quieres trabajar?");
        mostrarProvincias();
        System.out.print("\n| s - Salir\n| m - Mostrar todos los pueblos\n> ");
        String op = sc.nextLine();
        op = op.toLowerCase();
        if (op.equals("s")){
            return;
        } else if (op.equals("m")) {
            mostrarPueblos();
        } else {
            if (transformarAEntero(op) == -1){
                System.out.println("ERROR - Carácter invalido");
            } else {
                System.out.println(transformarAEntero(op));
                System.out.println("PROGRAMA AQUI");
            }
        }



    }
    static void mostrarProvincias(){
        //Cada 30 caracteres se salta de línea
        int cont = 0;
        System.out.print("| ");
        for (int i = 0; i < provinciasArray.toArray().length; i++){
            cont += provinciasArray.get(i).nombre.length();
            if (cont >= 30){
                System.out.print("\n| ");
                cont = 0;
            }
            System.out.print(i+1 + " - " + provinciasArray.get(i).nombre + " | ");
        }
    }

    static void mostrarPueblos(){
        //Muestro bonito las provincias
        for (provincias i : provinciasArray){
            System.out.print("|>>");
            for (int a = 0;a < i.nombre.length(); a++){
                System.out.print(">");
            }
            System.out.println(">>|");

            System.out.print("|< ");
            System.out.print(i.nombre);
            System.out.println(" >|");

            System.out.print("|<<");
            for (int a = 0;a < i.nombre.length(); a++){
                System.out.print("<");
            }
            System.out.println("<<|");

            //Cada 30 caracteres se salta de línea
            int cont = 0;
            // En caso de que no esté vacío
            if (!i.pueblos.isEmpty()) System.out.print("| ");
            for (int j = 0; j < i.pueblos.size(); j++){
                cont += i.pueblos.get(j).length();
                if (cont >= 30){
                    System.out.print("\n| ");
                    cont = 0;
                }
                System.out.print(j+1 + " - " + i.pueblos.get(j) + " | ");
            }
            System.out.println("\n");
        }
    }

    static int transformarAEntero(String op){
        //Transformo una cadena de uno o vários caracteres transformándola a un array de caracteres para transformarlos 1 a 1 en su equivalente en ascii -48
        // haciendo que si hay algún carácter que no sea un número devuelva un -1, finalmente voy sumando los resultados para obtener el resultado, peero me he dado cuenta
        // de que se puede hacer más fácil asiq a la basura el bloque
        /*
        char[] car = op.toCharArray();
        int cont = car.length - 1;
        int pos = 0;
        for (char i : car){
            int num = i - 48;
            if (num < 0 || num > 9)return - 1;
            pos += (int) (num * Math.pow(10, cont));
            cont--;
        }
        pos--;
        return pos;
         */
        try {
            Integer pos = Integer.parseInt(op);
            return pos-1;
        } catch (Exception e){
            return -1;
        }
    }


}
