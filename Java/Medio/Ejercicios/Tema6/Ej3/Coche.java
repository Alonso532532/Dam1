package Java.Medio.Ejercicios.Tema6.Ej3;

public class Coche extends Vehiculo{
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    void abrirMaletero(){
        System.out.println("Se abre el maletero del coche" + marca+" "+modelo);
    }
}
