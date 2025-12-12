package Java.Medio.Excepciones;

import java.util.Scanner;

public class pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Dame un DNI\n> ");
            String dni = sc.nextLine();
            if (dni.length() == 9) {
                try {
                    int numeros = Integer.parseInt(dni.substring(0, 8));
                    if (dni.charAt(8) >= 65 && dni.charAt(8) <= 90) {
                        System.out.println(dni);
                        break;
                    }
                    System.out.println("La letra no es correcta");
                } catch (Exception e) {
                    System.out.println("La sintaxis no es correcta");
                }
            } else {
                System.out.println("Tamaño inválido");
            }
        } while (true);

    }
}
