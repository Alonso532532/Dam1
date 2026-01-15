package Java.Medio.Practica;

public class Slime extends Enemigo {
    public Slime(int vida, int ataque, int armadura) {
        super.nombre = "Slime";
        super.vida = vida;
        super.vidaMax = vida;
        super.ataque = ataque;
        super.debilidad = 0;
        super.fuerza = 0;
        super.vulnerabilidad = 0;
        super.sangrado = 0;
        super.veneno = 0;
        super.armadura = armadura;
    }
    public Slime(String nombre, int vida, int ataque, int armadura) {
        super.nombre = nombre;
        super.vida = vida;
        super.vidaMax = vida;
        super.ataque = ataque;
        super.debilidad = 0;
        super.fuerza = 0;
        super.vulnerabilidad = 0;
        super.sangrado = 0;
        super.veneno = 0;
        super.armadura = armadura;
    }
    //<========================| Empezar turno |========================>\\
    void turno(Personaje personaje) throws InterruptedException {
        switch ((int)(Math.random()*4)){
            case 0:
                Thread.sleep(1000);
                System.out.println("El slime se prepara para atacar");
                Thread.sleep(2000);
                personaje.recibirDano(debilitar());
                personaje.aumentarDebilidad(2);
                System.out.println("El slime aplica 2 de debilidad");
                break;
            case 1,2:
                Thread.sleep(1000);
                System.out.println("El slime se prepara para atacar");
                Thread.sleep(2000);
                personaje.recibirDano(atacar());
                break;
            case 3:
                Thread.sleep(1000);
                System.out.println("El slime se protege");
                proteger();
                Thread.sleep(2000);
        }
        terminarTurno();
    }
    //<========================| Habilidades |========================>\\
    int debilitar(){
        return atacar(-7);
    }
    void proteger(){
        armadura+=12;
    }
}
