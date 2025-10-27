package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nom;
        System.out.print("Dime tu nombre: ");
        nom = sc.nextLine();
        System.out.println("Hola " + nom);
    }
}
