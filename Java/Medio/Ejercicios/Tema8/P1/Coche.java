package Java.Medio.Ejercicios.Tema8.P1;

public class Coche extends Vehiculo {
    private int puertas;
    private String combustible;

    public Coche(String marca, String modelo, int ano, String matricula, double precio, int puertas, String combustible) {
        super(marca, modelo, ano, matricula, precio);
        this.puertas = puertas;
        this.combustible = combustible;
    }

    @Override
    public String descripcion() {
        return super.descripcion()+", tipo de combustible ["+combustible+"], numero de puertas ["+puertas+"]";
    }
}
