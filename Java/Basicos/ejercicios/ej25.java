package Java.Basicos.ejercicios;

import java.util.Scanner;

public class ej25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame un texto\n> ");
        StringBuilder palabra = new StringBuilder(sc.nextLine());

        for (int i = 0; i < palabra.length(); i++) {

            if (palabra.charAt(i) == 255){
                palabra.replace(i, i+1, "a");
            } else if (palabra.charAt(i) == 233){
                palabra.replace(i, i+1, "e");
            } else if (palabra.charAt(i) == 237){
                palabra.replace(i, i+1, "i");
            } else if (palabra.charAt(i) == 243){
                palabra.replace(i, i+1, "o");
            } else if (palabra.charAt(i) == 250){
                palabra.replace(i, i+1, "u");
            }

            if (palabra.charAt(palabra.length()-1-i) == 225){
                palabra.replace(palabra.length()-1-i, palabra.length()-i, "a");
            } else if (palabra.charAt(palabra.length()-1-i) == 233){
                palabra.replace(palabra.length()-1-i, palabra.length()-i, "e");
            } else if (palabra.charAt(palabra.length()-1-i) == 237){
                palabra.replace(palabra.length()-1-i, palabra.length()-i, "i");
            } else if (palabra.charAt(palabra.length()-1-i) == 243){
                palabra.replace(palabra.length()-1-i, palabra.length()-i, "o");
            } else if (palabra.charAt(palabra.length()-1-i) == 250){
                palabra.replace(palabra.length()-1-i, palabra.length()-i, "u");
            }

            if (palabra.charAt(i) != palabra.charAt(palabra.length()-1-i)){System.out.println("No es polindroma"); return;}
        }
        System.out.println("Es polindroma");
    }
}

