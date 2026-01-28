package Java.Medio.Rpg.Cartas.Ataque;
import Java.Medio.Rpg.Cartas.Carta;
import Java.Medio.Rpg.Personaje;

public class Corte extends Carta {
    //<========================| Constructor básico |========================>\\
    public Corte(String estilo, boolean mejorada, Personaje personaje) {
        super(12, 1, estilo, "Corte", mejorada, personaje);
    }
    //<========================| Constructor completo |========================>\\
    public Corte(int dano, int coste, String estilo, String nombre, boolean mejorada, Personaje personaje) {
        super(dano, coste, estilo, nombre, mejorada, personaje);
    }
}
