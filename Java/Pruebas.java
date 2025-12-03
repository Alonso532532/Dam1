package Java;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Dame una multiplicación para realizarla con recursividad ej\"2x4\" (s - Salir): ");
                String op = sc.nextLine();
                if (op.equalsIgnoreCase("s"))break;
                System.out.println("Resultado: " + multiplicar(sacarPrim(op), sacarMult(op)));
            }catch (Exception e){
                System.out.println("ERROR - Formato invalido");
            }
        }while (true);
    }

    public static int sacarPrim(String mult){
        mult = mult.toLowerCase();
        return Integer.parseInt(mult.substring(mult.indexOf("x")+1));
    }
    public static int sacarMult(String mult){
        mult = mult.toLowerCase();
        return Integer.parseInt(mult.substring(0, mult.indexOf("x")));
    }


    public static int multiplicar(int num, int veces){
        if (veces == 0){
            return 0;
        }
        return num + multiplicar(num, veces-1);
    }

}
