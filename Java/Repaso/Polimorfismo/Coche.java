package Java.Repaso.Polimorfismo;

public class Coche extends Vehiculo {
    private int puetras;

    public int getPuetras() {
        return puetras;
    }

    public Coche(String marca, String modelo, int puertas) {
        this.marca = marca;
        this.modelo = modelo;
        this.puetras = puertas;
    }
    void abrirMaletero(){
        System.out.println("Se abre el maletero del coche" + marca+" "+modelo);
    }
}
