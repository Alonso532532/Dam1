package Java.Basicos.ejercicios;

import java.util.ArrayList;

public class ej18 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();
        ArrayList<Integer> resultado= new ArrayList<>();
        for (int i = 0; i < 10;i++){
            numeros1.add((int)(Math.random()*22-11));
        }
        for (int i = 0; i < 10;i++){
            numeros2.add((int)(Math.random()*22-11));
        }

        System.out.print("|");
        for (int i:numeros1){
            if (i >= 0){
                System.out.print(" ");
            }
            if (Math.abs(i) < 10){
                System.out.print(" ");
            }
            System.out.print(i + "|");
        }

        System.out.print("\n|");
        for (int i:numeros2){
            if (i >= 0){
                System.out.print(" ");
            }
            if (Math.abs(i) < 10){
                System.out.print(" ");
            }
            System.out.print(i + "|");
        }
        System.out.println();
        for (int i = 0; i < 10;i++){
            resultado.add(numeros1.get(i) + numeros2.get(i));
        }
        System.out.print("===============RESULTADO=================\n|");
        for (int i:resultado){
            if (i >= 0){
                System.out.print(" ");
            }
            if (Math.abs(i) < 10){
                System.out.print(" ");
            }
            System.out.print(i + "|");
        }
        System.out.println();

    }
}
