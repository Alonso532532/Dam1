package Java.Medio.Ejercicios.Tema8.P1;

public class Moto extends Vehiculo {
    private int cilindrada;
    private String tipo;

    public Moto(String marca, String modelo, int ano, String matricula, double precio, int cilindrada, String tipo) {
        super(marca, modelo, ano, matricula, precio);
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    @Override
    public String descripcion() {
        return super.descripcion()+", cilindrada ["+cilindrada+"], tipo de moto ["+tipo+"]";
    }
}
