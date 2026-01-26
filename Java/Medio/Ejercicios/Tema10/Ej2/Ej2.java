package Java.Medio.Ejercicios.Tema10.Ej2;

public class Ej2 {
    public static void main(String[] args) {
        Auto auto = new Auto();
        Moto moto = new Moto();
        Camion camion = new Camion();
        Vehiculo[] parking = new Vehiculo[3];
        parking[0] = auto;
        parking[1] = moto;
        parking[2] = camion;
        for (Vehiculo i : parking){
            System.out.println(i.describirVehiculo());
        }
    }
}
