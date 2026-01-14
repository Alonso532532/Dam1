package Java.Medio.Practica;

public class Enemigo {
    String nombre;
    int vida;
    int ataque;
    int debilidad;
    int fuerza;
    int sangrado;
    int veneno;
    int armadura;

    void atacar(){
        int dano;
        if (fuerza > 0 && debilidad == 0){
            dano = (int)(ataque*1.25);
        } else if (fuerza == 0 && debilidad > 0) {
            dano = (int)(ataque*0.5);
        } else {
            dano = ataque;
        }
        System.out.println(nombre +" hace "+ dano +" de daño.");
    }
    void aumentarFuerza(int aumento){
        fuerza+=aumento;
    }
    void aumentarDebilidad(int aumento){
        debilidad+=aumento;
    }
    void aumentarVeneno(int aumento){
        veneno+=aumento;
    }
    void aumentarSangrado(int aumento){
        sangrado+=aumento;
    }
    void aumentarFuerza(){
        fuerza++;
    }
    void aumentarDebilidad(){
        debilidad++;
    }
    void aumentarVeneno(){
        veneno++;
    }
    void aumentarSangrado(){
        sangrado++;
    }
    int terminarTurno(){
        vida-=sangrado+veneno;
        if (vida>0){
            veneno--;
            sangrado--;
            fuerza--;
            debilidad--;
            return 1;
        } else {
            return 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDebilidad() {
        return debilidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getSangrado() {
        return sangrado;
    }

    public int getVeneno() {
        return veneno;
    }

    public int getArmadura() {
        return armadura;
    }
}
