package Java.Medio.Practica;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Slime enemigo1 = new Slime(50, 12, 0);
        Personaje personaje = new Personaje("Hecproll", 100, 20, 0);
        enemigo1.aumentarFuerza();
        enemigo1.turno(personaje);
        System.out.println(personaje.getVida());
        enemigo1.turno(personaje);
        System.out.println(personaje.getVida());
        enemigo1.turno(personaje);
        System.out.println(personaje.getVida());

    }
}
