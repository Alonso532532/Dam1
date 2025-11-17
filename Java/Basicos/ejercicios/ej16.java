package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        boolean repetir = true;

        for (int i = 0; i < nums.length; i++){
            nums[i] = (int) (100 * Math.random());
        }

        do {
            System.out.print("Dame un numero\n> ");
            int numu = sc.nextInt();
            for (int valor : nums){
                if (numu == valor){repetir=false;}
            }
        }while (repetir);

    }
}
