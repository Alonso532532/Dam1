package Java.Medio.Ejercicios.Tema6.Practica;

public class PastorAleman extends Perro {
    public PastorAleman(String nombre, int edad) {
        super(nombre, edad);
    }
    @Override
    public String toString() {
        return "PastorAlemán{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", numSerie=" + numSerie +
                '}';
    }
}
