package Java.Medio.Rpg;

import Java.Medio.Rpg.Cartas.Ataque.Corte;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class RPG {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
//        impInicio();
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("Java/Medio/Rpg/Pantalla.txt"))){
            String inicio = """
                    ╔════════════════╗
                    ║ Presiona ENTER ║
                    ╚════════════════╝
                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┃                                                                                           ┃
                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                    """;
            escribir.write(inicio);
        }catch (IOException e){
            System.out.println("Pantalla no encontrada");
        }
        System.out.println("Introduce las acciónes por la linea de comandos");
        System.out.print("└─> ");
        sc.nextLine();

    }

    static void impInicio(){
//        try (BufferedWriter escribir = new BufferedWriter(new FileWriter("Java/Medio/Rpg/Pantalla.txt"))){
//            String inicio = """
//                    ╔════════════════╗
//                    ║ Presiona ENTER ║
//                    ╚════════════════╝
//                    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┃                                                                                           ┃
//                    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
//                    """;
//            escribir.write(inicio);
//        }catch (IOException e){
//            System.out.println("Pantalla no encontrada");
//        }
    }
}
