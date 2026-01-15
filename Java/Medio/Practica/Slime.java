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
            case 1,2:
                Thread.sleep(1000);
                System.out.println("El slime se prepara para atacar");
                Thread.sleep(2000);
                personaje.recibirDano(atacar());
            case 3:
                Thread.sleep(1000);
                System.out.println("El slime se protege");
                proteger();
                Thread.sleep(2000);
        }
    }
    //<========================| Habilidades |========================>\\
    int debilitar(){
        int dano = ataque/2;
        if (fuerza > 0 && debilidad == 0){
            dano *= 1.25;
        } else if (fuerza == 0 && debilidad > 0) {
            dano *= 0.5;
        }
        return dano;
    }
    void proteger(){
        armadura+=12;
    }
}
