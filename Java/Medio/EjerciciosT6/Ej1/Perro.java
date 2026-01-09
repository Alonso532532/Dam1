package Java.Medio.EjerciciosT6.Ej1;

public class Perro extends Animal{
    @Override
    public void hacerSonido() {
        super.sonido = "guau";
        super.hacerSonido();
    }
}
