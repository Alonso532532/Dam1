package Java.Medio.Practica;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Slime enemigo1 = new Slime(50, 12, 0);
        Slime enemigo2 = new Slime("Slime2", 50, 12, 0);
        Personaje personaje = new Personaje("Hecproll", 100, 20, 0);
        enemigo1.aumentarFuerza(3);
        System.out.println(enemigo1.getNombre());
        enemigo1.turno(personaje);
        System.out.println(enemigo2.getNombre());
        enemigo2.turno(personaje);
        System.out.println(personaje.getVida());
        System.out.println(enemigo1.getNombre());
        enemigo1.turno(personaje);
        System.out.println(enemigo2.getNombre());
        enemigo2.turno(personaje);
        System.out.println(personaje.getVida());
        System.out.println(enemigo1.getNombre());
        enemigo1.turno(personaje);
        System.out.println(enemigo2.getNombre());
        enemigo2.turno(personaje);
        System.out.println(personaje.getVida());

    }
}
