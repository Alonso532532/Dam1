package Java.Medio.Practica;

public class Demo {
    public static void main(String[] args) {
        Slime enemigo1 = new Slime(50, 12, 0, 0, 0);
        System.out.println(enemigo1.getVida());
        enemigo1.aumentarVeneno(10);
        enemigo1.terminarTurno();
        System.out.println(enemigo1.getVida());
        enemigo1.terminarTurno();
        System.out.println(enemigo1.getVida());
    }
}
