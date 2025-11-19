package Java.Basicos.ejercicios;
import java.util.Scanner;

public class ej16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++){
            nums[i] = (int) (100 * Math.random());
        }

        do {
            System.out.print("Dame un numero\n> ");
            int numu = sc.nextInt();
            if (numu < 0)break;
            for (int valor : nums){
                if (numu == valor){break;}
            }
        }while (true);

    }
}
