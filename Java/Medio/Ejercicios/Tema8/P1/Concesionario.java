package Java.Medio.Ejercicios.Tema8.P1;

import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Vehiculo> vehiculos;

    public Concesionario() {
        vehiculos = new ArrayList<>();
    }

    public Concesionario(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void mostrarVehiculos(){
        for (Vehiculo i : vehiculos){
            System.out.println(i.descripcion());
        }
    }

    public Vehiculo vehiculoMasAntiguo(){
        Vehiculo masAntiguo = vehiculos.getFirst();
        for (Vehiculo i : vehiculos){
            if (masAntiguo.antiguedad() < i.antiguedad()){
                masAntiguo = i;
            }
        }
        return masAntiguo;
    }

    public ArrayList<Vehiculo> buscarVehiculos(String criterio){
        ArrayList<Vehiculo> resultados = new ArrayList<>();
        if (vehiculos.isEmpty()){
            throw new IllegalArgumentException("El array está vacío");
        }
        for (Vehiculo i : vehiculos){
            if (i.getMarca().equalsIgnoreCase(criterio)){
                resultados.add(i);
            }
            if (criterio.equalsIgnoreCase("coche") && i instanceof Coche){
                resultados.add(i);
            }
            if (criterio.equalsIgnoreCase("moto") && i instanceof Moto){
                resultados.add(i);
            }
            if (criterio.equalsIgnoreCase("camion") && i instanceof Camion){
                resultados.add(i);
            }
        }
        return resultados;
    }

    public double precioPromedio(){
        if (vehiculos.isEmpty()){
            throw new IllegalArgumentException("El array está vacio");
        }
        double precio = 0;
        for (Vehiculo i : vehiculos){
            precio += i.getPrecio();
        }
        return precio/vehiculos.size();
    }
}
