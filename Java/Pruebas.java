package Java;


import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Dame un numero y te daré su mínimo común divisor\n> ");
                int num = Integer.parseInt(sc.nextLine());
                int num2 = num/2;
                if (MaxCD(num, num2) == 1){
                    System.out.println("El numero es primo");
                } else {
                    System.out.println(MaxCD(num, num2));
                }
                break;
            } catch (Exception e){
                System.out.println("Malo");
            }
        }while (true);
    }
    static int MaxCD(int num, int num2){
        if (num2 == 1){
            return 1;
        } else if (num%num2 != 0){
            num2 = MaxCD(num, num2-1);
        }
        return num2;
    }
}
