package Java.Repaso.Polimorfismo;

public class Vehiculo {
    String marca;
    String modelo;
    boolean encendido = false;
    void arrancar(){
        if (encendido){
            System.out.println("Ya está encendido");
        } else {
            System.out.println("El vehiculo " + marca+" "+modelo+ " ha arrancado");
            encendido = true;
        }
    }
}
