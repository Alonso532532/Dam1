package Java.Basicos;
import java.util.Scanner;



public class Pruebas {
    public static Scanner sc = new Scanner(System.in);
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame un numero\n> ");
        int num = sc.nextInt();
        System.out.println(recursiva(num));
        int cont = 1;
        System.out.println(recursivaInversa(num, cont));
    }

    static int recursiva(int num){
        if (num == 1){
            System.out.print(num + " = ");
        } else {
            System.out.print(num + " + ");
            num += recursiva(num-1);
        }
        return num;
    }
    static int recursivaInversa(int num, int cont){
        if (cont < num){
            System.out.print(cont + " + ");
            cont += recursivaInversa(num, cont+1);
        } else {
            System.out.print(cont + " = ");
        }
        return cont;
    }

}
