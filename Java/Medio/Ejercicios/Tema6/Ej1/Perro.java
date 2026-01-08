package Java.Medio.Ejercicios.Tema6.Ej1;

public class Perro extends Animal{
    @Override
    void hacerSonido() {
        super.sonido = "guau";
        super.hacerSonido();
    }
}
