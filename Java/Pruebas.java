package Java;
import java.util.ArrayList;

public class Pruebas {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < Math.random()*10+10; i++){
            numeros.add((int)(Math.random()*10));
        }
        System.out.print("|");
        for (int i : numeros){
            System.out.print(i + "|");
        }

        for (int i = 0; i < numeros.size();i++){
            for (int j = 0; j < numeros.size() -1 -i;j++){
                if (numeros.get(j) > numeros.get(j+1)){
                    int a = numeros.get(j+1);
                    numeros.set(j+1,numeros.get(j));
                    numeros.set(j,a);
                }
            }
        }
        System.out.print("\n|");
        for (int i : numeros){
            System.out.print(i + "|");
        }
    }
}
