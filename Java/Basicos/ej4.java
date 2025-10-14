package Java.Basicos;
import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame un carácter ");
        String car = sc.nextLine();
        int num = (int) car.charAt(0);
        if (num == 65 || num == 69 || num == 73 || num == 79 || num == 85 || num == 97 || num == 101 || num == 105 || num == 111 || num == 117) {
            System.out.println(car + " es uan vocal"); 
        } else {
            System.out.println(car + " no es uan vocal");
        }
    }
}
