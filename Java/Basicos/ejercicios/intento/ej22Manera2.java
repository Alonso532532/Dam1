package Java.Basicos.ejercicios.intento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ej22Manera2 {
    //Creo el array list
    static ArrayList<provincias> provinciasArray = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Añado varias provincias
        provinciasArray.add(new provincias("Zaragoza"));
        provinciasArray.add(new provincias("Huesca"));
        provinciasArray.add(new provincias("Teruel"));
        // Y pueblos
        provinciasArray.get(0).pueblos.add("pueblo1");
        provinciasArray.get(0).pueblos.add("pueblo4");
        provinciasArray.get(0).pueblos.add("pueblo3");
        provinciasArray.get(0).pueblos.add("pueblo2");
        provinciasArray.get(0).pueblos.add("pueblo5");
        provinciasArray.get(0).pueblos.add("pueblo6");

        provinciasArray.get(1).pueblos.add("pueblo1");
        provinciasArray.get(1).pueblos.add("pueblo2");
        do {

            //muestro de forma numerada las provincias para el menú
            System.out.println("<=====================================================>");
            System.out.println("¿Con que provincia quieres trabajar?");
            mostrarProvincias();
            System.out.print("\n| e - Eliminar provincia\n| m - Mostrar todos los pueblos\n| a - Añadir provincia\n| s - Salir\n└> ");
            String op = sc.nextLine();
            //Compruebo si la opción es una letra que sea una opción
            if (op.equalsIgnoreCase("s")){
                return;
            } else if (op.equalsIgnoreCase("m")) {
                mostrarPueblos();
            } else if (op.equalsIgnoreCase("a")) {
                anadirProvincia();
            } else if (op.equalsIgnoreCase("e")) {
                eliminarProvincia();
            } else {
                //si es un numero compruebo que sea una opción valida
                int pos = transformarAEntero(op);
                if (pos == -11 && op.length()!=3){
                    System.out.println("ERROR - Opción invalida");
                } else if (pos >= provinciasArray.size() || pos < 0) {
                    System.out.println("ERROR - Posición invalida");
                } else {
                    do {
                        System.out.println("<------------------------------------------------------>");
                        System.out.print("¿Que quieres hacer con " + provinciasArray.get(pos).nombre + "?\n| 1 - Mostrar pueblos\n| 2 - Buscar pueblos\n| 3 - Aañadir pueblos\n| 4 - Borrar pueblos\n| s - Salir\n└> ");
                        String accion = sc.nextLine();
                        if (accion.equalsIgnoreCase("s")){
                            break;
                        } else if (accion.equals("1")){
                            mostrarPueblosDeProvincia(provinciasArray.get(pos).pueblos, 1);
                        } else if (accion.equals("2")) {
                            buscarPueblo(provinciasArray.get(pos).pueblos);
                        } else if (accion.equals("3")) {
                            anadirPueblo(provinciasArray.get(pos).pueblos);
                        } else if (accion.equals("4")) {
                            eliminarPueblo(provinciasArray.get(pos).pueblos);
                        } else {
                            System.out.println("ERROR - Opción invalida");
                        }
                    } while (true);
                }
            }
        } while (true);
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
        System.out.println();
        //Muestro bonito las provincias
        for (provincias i : provinciasArray){
            Collections.sort(i.pueblos);
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

            mostrarPueblosDeProvincia(i.pueblos, 0);
        }
        System.out.print("Enter para continuar...");
        sc.nextLine();
        System.out.println();
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
            int pos = Integer.parseInt(op);
            return pos-1;
        } catch (Exception e){
            return -11;
        }
    }

    static void mostrarPueblosDeProvincia(ArrayList<String> pueblos, int pausa){
        System.out.println();
        Collections.sort(pueblos);
        int cont = 0;
        if (!pueblos.isEmpty()) System.out.print("| ");
        for (int j = 0; j < pueblos.size(); j++){
            cont += pueblos.get(j).length();
            if (cont >= 30){
                System.out.print("\n| ");
                cont = 0;
            }
            System.out.print(j+1 + " - " + pueblos.get(j) + " | ");
        }
        if (!pueblos.isEmpty())System.out.println("\n");
        if (pausa == 1){
            System.out.print("Enter para continuar...");
            sc.nextLine();
            System.out.println();
        }
    }

    static void anadirProvincia(){
        System.out.print("- Nombre: ");
        String nombre = sc.nextLine();
        ArrayList<String> nombreProvincias = new ArrayList<>();
        for (provincias i : provinciasArray){
            nombreProvincias.add(i.nombre);
        }
        if (nombreProvincias.contains(nombre)){
            System.out.println("ERROR - El nombre ya existe");
        } else {
            provinciasArray.add(new provincias(nombre));
            System.out.println("- Provincia \"" + nombre + "\" añadida");
        }
    }

    static void eliminarProvincia(){
        System.out.print("- Nombre: ");
        String nombre = sc.nextLine();
        int pos = -1;
        for (int i = 0; i < provinciasArray.size(); i++ ){
            if (provinciasArray.get(i).nombre.equals(nombre)){
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            System.out.println("ERROR - El nombre no existe");
        } else {
            provinciasArray.remove(pos);
            System.out.println("- Provincia \"" + nombre + "\" eliminada");
        }
    }

    static void anadirPueblo(ArrayList<String> pueblos){
        System.out.println("<------------------------------------------------------>");
        do {
            System.out.print("0 - para salir\n> Nombre: ");
            String nombre = sc.nextLine();
            if (nombre.equals("0")){
                return;
            } else if (pueblos.contains(nombre)){
                System.out.println("ERROR - El nombre ya existe");
            } else {
                pueblos.add(nombre);
                System.out.println("- Pueblo \"" + nombre + "\" añadido");
            }
        }while (true);

    }

    static void buscarPueblo(ArrayList<String> pueblos){
        do {
            Collections.sort(pueblos);
            System.out.println("<------------------------------------------------------>");
            System.out.print("0 - para salir\n> Nombre: ");
            String nombre = sc.nextLine();
            if (nombre.equals("0")){
                return;
            } else if (pueblos.contains(nombre)){
                System.out.println("Encontrado en la posición " + (1 + Collections.binarySearch(pueblos, nombre)) );
            } else {
                do {
                    System.out.print("No se a encontrado el elemento, ¿Quieres añadirlo? (s/n)\n> ");
                    String op = sc.nextLine();
                    if (op.equalsIgnoreCase("s")){
                        pueblos.add(nombre);
                        break;
                    } else if (op.equalsIgnoreCase("n")){
                        break;
                    } else {
                        System.out.println("ERROR - Opción inválida");
                    }
                }while (true);
            }
        }while (true);
    }

    static void eliminarPueblo(ArrayList<String> pueblos){
        do {
            System.out.println("<------------------------------------------------------>");
            mostrarPueblosDeProvincia(pueblos, 0);
            System.out.print("0 - para salir\n> Posición: ");
            try {
                int pos = Integer.parseInt(sc.nextLine());
                if (pos == 0){
                    return;
                } else if (pos < 1 || pos > pueblos.size()){
                    System.out.println("ERROR - Opción invalida");
                } else {
                    pueblos.remove(pos-1);
                    System.out.println("- Pueblo \"" + pos + "\" eliminado");
                }
            } catch (Exception e){
                System.out.println("ERROR - Carácter invalido");
            }
        }while (true);
    }
}
