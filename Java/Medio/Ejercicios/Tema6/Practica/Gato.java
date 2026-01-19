package Java.Medio.Ejercicios.Tema6.Practica;

public class Gato extends Animal{
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    void hacerRuido() {
        System.out.println("Gato "+numSerie+": miau");
    }
}
