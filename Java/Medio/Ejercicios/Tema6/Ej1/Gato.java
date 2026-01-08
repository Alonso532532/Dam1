package Java.Medio.Ejercicios.Tema6.Ej1;

public class Gato extends Animal {
    @Override
    void hacerSonido() {
        super.sonido = "miau";
        super.hacerSonido();
    }
}
