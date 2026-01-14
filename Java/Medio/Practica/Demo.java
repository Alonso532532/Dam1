package Java.Medio.Practica;

public class Demo {
    public static void main(String[] args) {
        Baba enemigo1 = new Baba(50, 12, 0, 0, 0);
        enemigo1.atacar();
        enemigo1.aumentarFuerza();
        enemigo1.atacar();
        enemigo1.aumentarSangrado(10);
        System.out.println(enemigo1.getVida());
        enemigo1.terminarTurno();
        System.out.println(enemigo1.getVida());
        enemigo1.terminarTurno();
        System.out.println(enemigo1.getVida());
        enemigo1.atacar();
    }
}
