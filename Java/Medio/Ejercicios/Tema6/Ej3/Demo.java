package Java.Medio.Ejercicios.Tema6.Ej3;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Moto moto1 = new Moto("Breva", "9000");
        Moto moto2 = new Moto("Breva", "7000.sl");
        Coche coche1 = new Coche("Pascuals", "Vintage edition");
        ArrayList<Vehiculo> garaje = new ArrayList<>(Arrays.asList(moto1));
        for (Vehiculo v : garaje){
            if (v instanceof Coche){
                ((Coche) v).abrirMaletero();
            } else {
                ((Moto) v).hacerElCaballito();
            }
        }

    }
}
