package Java;


import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        int cont = 0;
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

        System.out.println("Creo un StringBuilder de 32 carácteres de capacidad (esta capacidad varía en cuanto se le asigne un append), este tipo de variables permite ser modificado sin abandonar el puntero de memoria, se puede cambiar a tipo cadena con \".toString\"\n");
        StringBuilder cosa1 = new StringBuilder(32);
        cosa1.append("hola");
        System.out.print("Añado \"hola\" a la variable: \n|" + cosa1 + "|\n|");
        cont = 0;
        for (int i = 0; i < cosa1.length(); i++){
            if (cont==10){
                cont -= 10;
            }
            System.out.print(cont++);
        }
        System.out.println("|\n");

        cosa1.setCharAt(0, 'H');
        cosa1.append('!');
        System.out.print("Sustituyo la posición 0 por \"H\" y añado \"!\" al final: \n|" + cosa1 + "|\n|");
        cont = 0;
        for (int i = 0; i < cosa1.length(); i++){
            if (cont==10){
                cont -= 10;
            }
            System.out.print(cont++);
        }
        System.out.println("|\n");

        cosa1.insert(5, "world");
        cosa1.insert(5, "-");
        System.out.print("Añado en la posición 5 \"world\" y posteriormente un \"-\": \n|" + cosa1 + "|\n|");
        cont = 0;
        for (int i = 0; i < cosa1.length(); i++){
            if (cont==10){
                cont -= 10;
            }
            System.out.print(cont++);
        }
        System.out.println("|\n");

        cosa1.replace(5, 7," W");
        System.out.print("Sustituyo desde la posición 5 hasta la 7-1 por un \" W\": \n|" + cosa1 + "|\n|");
        cont = 0;
        for (int i = 0; i < cosa1.length(); i++){
            if (cont==10){
                cont -= 10;
            }
            System.out.print(cont++);
        }
        System.out.println("|\n");

        cosa1.deleteCharAt(4);
        cosa1.append("!");
        System.out.print("Muevo la exclamación al finál: \n|" + cosa1 + "|\n|");
        cont = 0;
        for (int i = 0; i < cosa1.length(); i++){
            if (cont==10){
                cont -= 10;
            }
            System.out.print(cont++);
        }
        System.out.println("|\n");

        cosa1.append(" <");
        cosa1.repeat("-", 5);
        cosa1.reverse();
        cosa1.append(" >");
        cosa1.repeat("-", 5);

        cosa1.reverse();
        System.out.print("Añado flechas: \n|" + cosa1 + "|\n|");
        cont = 0;
        for (int i = 0; i < cosa1.length(); i++){
            if (cont==10){
                cont -= 10;
            }
            System.out.print(cont++);
        }
        System.out.println("|\n");
    }

}
