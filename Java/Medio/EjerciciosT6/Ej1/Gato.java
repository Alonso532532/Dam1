package Java.Medio.EjerciciosT6.Ej1;

public class Gato extends Animal{
    @Override
    public void hacerSonido() {
        super.sonido = "miau";
        super.hacerSonido();
    }
}
