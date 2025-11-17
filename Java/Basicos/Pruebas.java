package Java.Basicos;
import java.util.Scanner;



public class Pruebas {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int[] nums = new int[(int) (Math.random() * 10)];
        System.out.print("Tiene una longitud de: " + nums.length + "\nY sus valores son\n> ");
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int) (Math.random() * 10);
        }
        for (int d : nums){
            System.out.print(" " + d);
        }

    }
}
