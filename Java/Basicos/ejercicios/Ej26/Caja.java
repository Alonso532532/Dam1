package Java.Basicos.ejercicios.Ej26;

import java.util.ArrayList;
import java.util.Scanner;

public class Caja {
    public static void main(String[] args) {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Para empezar con la creación del ticket presiona ENTER, si quieres terminar el programa introduce \"s\"\n> ");
            if (sc.nextLine().equalsIgnoreCase("s")){
                return;
            }
            ArrayList<Producto> productos = new ArrayList<>();
            do {
                System.out.print("Introduce el código de producto y seguido de un guión la cantidad, EJ \"4-2\"\n| 1 - Manzana\n| 2 - Pera\n| 3 - Chokapick\n| 4 - Donut de lotus\n| 5 - Fanta\n| 6 - Monster mangoloco\n| 7 - Empanadilla de atún\n| 8 - Bifrutas\n[ 0 para terminar ]\n└> ");
                String op = sc.nextLine();
                if (op.equals("0"))break;


                int cod = 0;
                int cant = 0;
                try {
                    cod = Integer.valueOf(op.substring(0, op.indexOf('-')));
                    cant = Integer.valueOf(op.substring(op.indexOf("-")+1));
                } catch (Exception e){
                    System.out.println("Formato invalido");
                    continue;
                }
                if (cod < 1 || cod > 8){
                    System.out.println("ERROR - Código de producto incorrecto");
                    continue;
                }
                if (cant < 1){
                    System.out.println("ERROR - Cantidad inferior a 1");
                    continue;
                }

                productos.add( new Producto(cod, cant));
            }while (true);
            double total = 0;
            int cont = 0;
            System.out.println("<===========================>");
            for (Producto i : productos){
                if (cont != 0){
                    System.out.println("\n-----------------------------");
                }
                System.out.println("Producto " + ++cont);
                System.out.print(i.getCantidad() + " - " + i.getProducto() + ": ");
                System.out.printf("%.2f", i.getPrecio()*i.getCantidad());
                System.out.print("\nCon IVA añadido: ");
                System.out.printf("%.2f", i.precioIVA()*i.getCantidad());
                total += i.precioIVA()*i.getCantidad();
            }
            System.out.println("\n<===========================>");
            System.out.print("Precio sin IVA: ");
            System.out.printf("%.2f", (total - total*0.21));
            System.out.print("\nPRECIO TOTAL: ");
            System.out.printf("%.2f", total);
            System.out.println("\n<===========================>");
            System.out.println("\nENTER PARA CONTINUAR...");
            sc.nextLine();
        }while(true);
    }
}
