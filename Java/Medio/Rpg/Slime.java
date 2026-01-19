package Java.Medio.Rpg;

public class Slime extends Enemigo {
    //<========================| Constructores |========================>\\

    public Slime(int armadura, int veneno, int sangrado, int vulnerabilidad, int fuerza, int debilidad, int ataque, int vidaMax, int vida) {
        super(armadura, veneno, sangrado, vulnerabilidad, fuerza, debilidad, ataque, vidaMax, vida, "Slime");
    }

    public Slime(int armadura, int veneno, int sangrado, int vulnerabilidad, int fuerza, int debilidad, int ataque, int vidaMax, int vida, String nombre) {
        super(armadura, veneno, sangrado, vulnerabilidad, fuerza, debilidad, ataque, vidaMax, vida, nombre);
    }

    public Slime(String nombre, int vidaMax , int vida, int ataque, int armadura) {
        super(armadura, 0, 0, 0, 0, 0, ataque, vidaMax, vida, nombre);
    }

    public Slime(int vidaMax , int vida, int ataque, int armadura) {
        super(armadura, 0, 0, 0, 0, 0, ataque, vidaMax, vida, "Slime");
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
