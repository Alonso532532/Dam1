package Java.Basicos;

public class contadores {

    public static void main(String[] args) {
        int a = 0;
        System.out.print("Contador While:");
        while (a < 10) {
            a++;
            System.out.print(" " + a);
        }
        System.out.print("\nContador for:");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.print("\nContador al reves do-while:");
        do {
            System.out.print(" " + a);
            a--;
        } while (a > 0);
    }
}
