package Java.Medio.EidtorDeTexto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Editor {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Path archivo = Path.of("ad");
        do {
            System.out.print("<== Dame la ruta de un archivo ==>\n> ");
            try {
                archivo = Path.of(sc.nextLine());
            }catch (Exception e){}
            if (!Files.exists(archivo) || archivo.toString().isEmpty()){
                System.out.println("El archivo no existe");
            }
        } while (!Files.exists(archivo) || archivo.toString().isEmpty());
        String op;
        do {
            System.out.print("¿Que quieres hacer?\n| 1 - Escribir\n| 2 - Leer contenido \n| 3 - Borrar todo el contenido\n| 4 - Borrar líneas\n| S - Salir\n└> ");
            op = sc.nextLine();
            switch (op){
                case "1":
                    System.out.println("Escribir \"salir.\" para dejar de escribir\n<====================>");
                    leerContenido(archivo);
                    boolean repetir = true;
                    do {
                        String texto = sc.nextLine();
                        if (texto.contains(" salir.") || texto.contains("salir.")){
                            System.out.println("<====================>\nSaliendo...");
                            repetir = false;
                            texto = texto.replace(" salir.", "");
                            texto = texto.replace("salir.", "");
                            if (!texto.isEmpty()){
                                anadirAlTexto(texto, archivo);
                            }
                        } else {
                            anadirAlTexto(texto, archivo);
                        }

                    } while (repetir);
                    break;
                case "2":
                    System.out.println("<====================>");
                    leerContenido(archivo);
                    System.out.println("<====================>");
                    break;
                case "3":
                    try (FileWriter borrar = new FileWriter(archivo.toString())){
                        borrar.write("");
                    }catch (IOException e){
                        System.out.println("No se ha encontrado el archivo");
                    }
                    break;
                case "4":
                    leerContenidoNumerado(archivo);
                    break;
                default:
                    if (!op.equalsIgnoreCase("s")){
                        System.out.println("Opción invalida");
                    }
            }
        } while (!op.equalsIgnoreCase("s"));
    }
    static void leerContenido(Path archivo){
        try (BufferedReader leer = new BufferedReader( new FileReader(archivo.toString()))){
            String linea;
            while ((linea = leer.readLine()) != null){
                System.out.println(linea);
            }
        }catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
    static void anadirAlTexto(String texto, Path archivo){
        try (FileWriter escribir = new FileWriter(archivo.toString(), true)){
            escribir.write(texto.concat("\n"));
        }catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
    static void leerContenidoNumerado(Path archivo){
        try (BufferedReader leer = new BufferedReader( new FileReader(archivo.toString()))){
            System.out.println("<====================>");
            String acum = "";
            String linea;
            int cont = 0;
            while ((linea = leer.readLine()) != null){
                System.out.print(++cont);
                int ocupa = 1;
                int contActual = cont;
                while (contActual /10 > 0){
                    contActual /= 10;
                    ocupa++;
                }
                for (int i = 6-ocupa; i > 0; i--){
                    System.out.print(" ");
                }
                System.out.print(">");
                System.out.println(linea);
                acum = acum.concat(linea + "\n");
            }
            System.out.println("<====================>");
            String[] lineas = acum.split("\n");
            System.out.print("¿Que líneas quieres borrar? (Formato ej: 1,3,4)\n> ");
            String resp = sc.nextLine().concat(",");
            while (resp.contains(",")){
                int pos = Integer.parseInt(resp.substring(0,resp.indexOf(",")))-1;
                if (pos+1 > lineas.length || pos < 0){
                    System.out.println("Posición " + (pos+1) + " invalida");
                } else {
                    lineas[pos] = "\n";
                }
                resp = resp.replace(resp.substring(0,resp.indexOf(",")+1), "");
            }
            String nuevoTexto = "";
            for (int i = 0; i < lineas.length; i++){
                if (!lineas[i].contains("\n")){
                    nuevoTexto = nuevoTexto.concat(lineas[i]+"\n");
                } else if (i != lineas.length-1){
                    nuevoTexto = nuevoTexto.concat("");
                }
            }
            try (FileWriter escribir = new FileWriter(archivo.toString())){
                System.out.println("<==RESULTADO==>\n"+nuevoTexto+"<============>");
                escribir.write(nuevoTexto);
            } catch (IOException e){
                System.out.println("No se ha encontrado el archivo");
            }
        }catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
}
