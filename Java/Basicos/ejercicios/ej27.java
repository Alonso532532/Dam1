package Java.Basicos.ejercicios;

import java.util.Scanner;

public class ej27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Dame un entero\n> ");
                System.out.println(darVuelta(Integer.parseInt(sc.nextLine())));
                break;
            } catch (Exception e){
                System.out.println("Formato inválido");
            }
        }while (true);
        System.out.print("Y una frase\n> ");
        String frase = sc.nextLine();
        System.out.println(frase.replace(" ", ""));
    }
    static int darVuelta(int num){
        String signo = "";
        if (num<0){signo = "-";}
        StringBuilder cadena = new StringBuilder(String.valueOf(num));
        if (cadena.charAt(0) == '-'){
            cadena.deleteCharAt(0);
        }
        cadena.reverse();

        return Integer.parseInt(signo + cadena);
    }
}
