package Java.Medio.Ejercicios.Tema8.P1;


import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Pascuals", "v2", 2004, "423AAA", 2000, 5, "200L");
        Moto moto1 = new Moto("Juanmas", "v3", 2014, "423BBB", 3000, 125, "Moto");
        Camion camion1 = new Camion("Celias", "v4", 2024, "423CCC", 4500, 3000, 5);
        ArrayList<Vehiculo> porDefecto = new ArrayList<>();
        porDefecto.add(coche1);
        porDefecto.add(moto1);
        porDefecto.add(camion1);
        Concesionario mecanico = new Concesionario(porDefecto);
        for (Vehiculo i : mecanico.buscarVehiculos("camion")){
            System.out.println(i.descripcion());
        }
        System.out.println(mecanico.vehiculoMasAntiguo().descripcion());
    }
}
