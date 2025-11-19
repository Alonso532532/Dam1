package Java.Basicos;
import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.Scanner;



public class Pruebas {
    public static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> numeros = new ArrayList<>();
    static void main(String[] args) {
        do {
            System.out.print("¿Cuantos numeros quieres almacenar?\n> ");
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num > 0){
                    for (;num > 0; num--){
                        numeros.add((int) (Math.random()*10));
                    }
                    break;
                }
                System.out.println("ERROR - El numero tiene que ser superior a 0");
            } catch (Exception e){
                System.out.println("ERROR - Formato invalido");
            }
        } while (true);
        int pos = 0;
        for (int num : numeros){
            pos++;
            System.out.println(pos + "> " + num);
        }
        Representar();
        do {
            System.out.print("¿Quieres sustituir alguna posición?\n1 - Sustituir valores \n2 - Sustituir posiciónes\n3 - Eliminar una posición\nS - Salir\n> ");
            String op = sc.nextLine();
            if (op.equalsIgnoreCase("s"))break;
            if (op.equals("1")){
                Sustituir();
            } else if (op.equals("2")){
                SustituirPos();
            } else if (op.equals("3")){
                EliminarPos();
            }else {
                System.out.println("ERROR - Opción inválida");
            }

        }while (true);

    }

    static void Sustituir(){
        boolean ok = true;
        System.out.print("¿Que valor quieres sustituir?\n> ");
        int vals = 0, valS = 0;
        try {
            vals = Integer.parseInt(sc.nextLine());
            if (vals < 0 || vals > 9)ok = false;
        } catch (Exception e){
            ok = false;
        }
        System.out.print("¿Por que valor quieres sustituirlo?\n> ");
        try {
            valS = Integer.parseInt(sc.nextLine());
            if (valS < 0 || valS > 9)ok = false;
        } catch (Exception e){
            ok = false;
        }
        if (!ok){
            System.out.println("Algo ha ido mal, repito el proceso");
            Sustituir();
            return;
        } else {
            for (int i = 0; i < numeros.size(); i++){
                if (numeros.get(i) == vals){
                    numeros.set(i, valS);
                }
            }
            Representar();
        }
    }

    static void SustituirPos(){
        int pos = 10;
        int valor = 10;
        do {
            try {
                System.out.print("¿Que posición quieres sustituir?\n> ");
                pos = Integer.parseInt(sc.nextLine());
                pos--;
                System.out.print("¿Por que valor?\n> ");
                valor = Integer.parseInt(sc.nextLine());
                if (valor < 0 || valor > 9)System.out.println("ERROR - Valor inválido");
            } catch (Exception e){
                System.out.println("ERROR - Formato invalido");
            }
            if (valor > -1 && valor < 10){
                try {
                    numeros.set(pos, valor);
                    Representar();
                    break;
                } catch (Exception e){
                    System.out.println("BOBO, La posición es imposible");
                }
            }
        }while (true);

    }
    static void EliminarPos(){
        int pos;
        do {
            try {
                System.out.print("¿Que posición quieres borrar?\n> ");
                pos = Integer.parseInt(sc.nextLine());
                pos--;
                numeros.remove(pos);
                Representar();
                break;
            } catch (Exception e){
                System.out.println("ERROR - Formato invalido");
            }
        }while (true);
    }
    static void Representar(){
        int pos = 0;
        System.out.println("Representación grafica:");
        for (int num : numeros){
            if (pos % 15 == 0) System.out.print("\n|");
            pos++;
            System.out.print(num + "|");
        }
        System.out.println("\n");
    }

}
