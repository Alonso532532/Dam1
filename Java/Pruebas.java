package Java;


import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String textaco = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus euismod, ligula sed euismod elementum, urna elit mattis sem, eu pulvinar libero nibh ut risus.";
        String a = "iker";
        String b = "lozano";
        String c = a + " ";
        c = c.concat(b);
        System.out.println("Texto concatenado" + c);

        System.out.printf("El texto es: %s, que es la suma de \"%s\" y \"%s\"\n", c, a, b);

        System.out.println(a.contains("iker"));

        System.out.println("La primera \"e\" está en la posición: " + a.indexOf("e"));

        String[] separado = textaco.split(",");
        // Ignora el carácter que se usa para separar
        System.out.print("Separo la frase por cada: \",\" \n| ");
        for (String i : separado){
            System.out.print(i + " | ");
            //El .trim elimina espacios innecesarios
        }
        System.out.println("\n");
        System.out.print("Lo mismo pero eliminando espacios innecesarios: \n| ");
        for (String i : separado){
            System.out.print(i.trim() + " | ");
            //El .trim elimina espacios innecesarios
        }
        System.out.println("\n");

        System.out.print("Reemplazo las \",\" por \"|\"\n| ");
        System.out.println(textaco.replace(","," |"));
        System.out.println();

        System.out.println("La diferencia entre dos cadenas es de: " + "Hola".compareTo("Adios"));
        System.out.println();

        System.out.println("Compruebo si la cadena empieza con algo: " + "Hola".startsWith("Ho"));
        System.out.println();

        StringBuilder cosa1 = new StringBuilder(32);
    }

}
