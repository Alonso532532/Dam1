package Java.Medio.Rpg.Cartas;

import Java.Medio.Rpg.Personaje;

public class CartaAtaque extends Carta {
    public CartaAtaque(int dano, int coste, String estilo, String nombre, boolean mejorada, Personaje personaje) {
        super(dano, coste, estilo, nombre, mejorada, personaje);
    }
}
