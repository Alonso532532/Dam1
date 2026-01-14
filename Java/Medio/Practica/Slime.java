package Java.Medio.Practica;

public class Slime extends Enemigo {
    public Slime(int vida, int ataque, int debilidad, int fuerza, int armadura) {
        super.nombre = "Slime";
        super.vida = vida;
        super.ataque = ataque;
        super.debilidad = debilidad;
        super.fuerza = fuerza;
        super.armadura = armadura;
        super.sangrado = 0;
        super.veneno = 0;
    }
}
