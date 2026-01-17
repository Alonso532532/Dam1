package Java.Medio.Practica;

import Java.Medio.Practica.Cartas.Ataque.Corte;
import Java.Medio.Practica.Cartas.Carta;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Slime enemigo1 = new Slime("Slime1", 38, 38, 12, 0);
        Personaje personaje = new Personaje("Hecproll", 100, 0, 0, 3, 3);
        Corte carta1 = new Corte("", false, personaje);
        carta1.accion(enemigo1);
        carta1.accion(enemigo1);
        carta1.accion(enemigo1);
        System.out.println(enemigo1.getVida());
    }
}
