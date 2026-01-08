package Java.Medio.Ejercicios.Tema6.Ej3;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Vehiculo moto1 = new Moto("Breva", "9000");
        Vehiculo moto2 = new Moto("Breva", "7000.sl");
        Vehiculo coche1 = new Coche("Pascuals", "Vintage edition");
        ArrayList<Vehiculo> garaje = new ArrayList<>(Arrays.asList(moto1, moto2, coche1));
        for (Vehiculo i : garaje){
            i.arrancar();
            if (i.getClass().toString().substring(i.getClass().toString().lastIndexOf(".")+1).equals("Moto")){
                System.out.println("Es una moto");
            } else {
                System.out.println("Es un coche");
            }

        }
    }
}
