package Java.Medio.Ejercicios.Tema6.Ej3;

public class Moto extends Vehiculo{
    public Moto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    void hacerElCaballito(){
        System.out.println("Haces el caballito con la moto " + marca+" "+modelo);
    }
}
