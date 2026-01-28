package Java.Medio.Ejercicios.Tema8.P1;

public class Camion extends Vehiculo {
    private double capacidadDeCarga;
    private int ejes;

    public Camion(String marca, String modelo, int ano, String matricula, double precio, double capacidadDeCarga, int ejes) {
        super(marca, modelo, ano, matricula, precio);
        this.capacidadDeCarga = capacidadDeCarga;
        this.ejes = ejes;
    }

    @Override
    public String descripcion() {
        return super.descripcion()+", capacidad de carga ["+capacidadDeCarga+"], numero de ejes ["+ejes+"]";
    }
}
