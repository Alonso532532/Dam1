package Java.Basicos.Prueba1;
import java.util.*;

public class programa {
    pelota bola = new pelota();
    void mover(){

    }
    public static void impTabla(){
        int cont = 0;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 20; j++) {
                if (i == 0){
                    if (j == 0){
                        System.out.print("╔");
                    } else if (j == 20){
                        System.out.print("╗");
                    } else if (j%2 == 0){
                        System.out.print("╦");
                    } else {
                        System.out.print("═");
                    }
                } else if (i == 10){
                    if (j == 0){
                        System.out.print("╚");
                    } else if (j == 20){
                        System.out.print("╝");
                    } else if (j%2 == 0){
                        System.out.print("╩");
                    } else {
                        System.out.print("═");
                    }
                } else if (i%2 == 0) {
                    if (j == 0){
                        System.out.print("╠");
                    } else if (j == 20){
                        System.out.print("╣");
                    } else if (j%2 == 0){
                        System.out.print("╬");
                    } else {
                        System.out.print("═");
                    }
                } else {
                    if (j%2 == 0){
                        System.out.print("║");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        String[][] tabla = {{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "}};
        String op;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 20; j++) {
                if (i == 0){
                    if (j == 0){
                        System.out.print("╔");
                    } else if (j == 20){
                        System.out.print("╗");
                    } else if (j%2 == 0){
                        System.out.print("╦");
                    } else {
                        System.out.print("═");
                    }
                } else if (i == 10){
                    if (j == 0){
                        System.out.print("╚");
                    } else if (j == 20){
                        System.out.print("╝");
                    } else if (j%2 == 0){
                        System.out.print("╩");
                    } else {
                        System.out.print("═");
                    }
                } else if (i%2 == 0) {
                    if (j == 0){
                        System.out.print("╠");
                    } else if (j == 20){
                        System.out.print("╣");
                    } else if (j%2 == 0){
                        System.out.print("╬");
                    } else {
                        System.out.print("═");
                    }
                } else {
                    if (j%2 == 0){
                        System.out.print("║");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
        do {
            System.out.print("Hacia donde quieres que se mueva la pelota\n> ");
            op =  sc.nextLine();
            if (!op.equals("arriba derecha") && !op.equals("abajo derecha") && !op.equals("abajo izquierda") && !op.equals("abajo izquierda")){
                System.out.println("Dirección invalida");
            }
        }while (!op.equals("arriba derecha") && !op.equals("abajo derecha") && !op.equals("abajo izquierda") && !op.equals("abajo izquierda"));

    }
}
