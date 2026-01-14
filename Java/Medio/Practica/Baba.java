package Java.Medio.Practica;

public class Baba extends Enemigo {
    public Baba(int vida, int ataque, int debilidad, int fuerza, int armadura) {
        super.nombre = "Baba";
        super.vida = vida;
        super.ataque = ataque;
        super.debilidad = debilidad;
        super.fuerza = fuerza;
        super.armadura = armadura;
        super.sangrado = 0;
        super.veneno = 0;
    }
}
