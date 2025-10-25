package Java.Basicos;
import java.util.*;
import java.math.*;


public class funciones {
    static char palabra(int ifu, String palabraf) {
        char letra = palabraf.charAt(ifu);
        return letra;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una texto \n>  ");
        String palabrau = sc.nextLine();

        System.out.print("La palabra al revés es: \n- ");
        String palabara2 = "";
        for (int i = palabrau.length() - 1; i >= 0; i--) {
            palabara2 = palabara2 + palabra(i, palabrau);
        }
        System.out.print(palabara2);

        System.out.print("\nDame dos palabras (separadas por un espacio): \n> ");
        String uno = sc.next();
        String dos = sc.next();
        String res = uno + " " + dos;
        System.out.print("Las uno \n- " + res);
    }
}
