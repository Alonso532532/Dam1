package Java.Medio.Practica.Cartas;

import Java.Medio.Practica.Personaje;

public class Carta {
    public String nombre;
    public String estilo;
    public int coste;
    public int dano;
    public boolean mejorada;
    public Personaje personaje;
    //<========================| Constructor |========================>\\
    public Carta(int dano, int coste, String estilo, String nombre, boolean mejorada, Personaje personaje) {
        this.dano = dano;
        this.coste = coste;
        this.estilo = estilo;
        this.nombre = nombre;
        this.mejorada = mejorada;
        this.personaje = personaje;
    }

}
