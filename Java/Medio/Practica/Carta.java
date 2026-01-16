package Java.Medio.Practica;

public class Carta {
    String nombre;
    String estilo;
    int coste;
    int dano;
    boolean mejorada;
    //<========================| Constructor |========================>\\
    public Carta(int dano, int coste, String estilo, String nombre, boolean mejorada) {
        this.dano = dano;
        this.coste = coste;
        this.estilo = estilo;
        this.nombre = nombre;
        this.mejorada = mejorada;
    }

}
