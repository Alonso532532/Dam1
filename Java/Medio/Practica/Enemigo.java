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


    //<========================| Aumentos de estadisticas |========================>\\
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
    //<========================| Reduccion de estadisticas |========================>\\
    void reducirFuerza(int reduccion){
        if (fuerza >= reduccion){
            fuerza-=reduccion;
        }
    }
    void reducirDebilidad(int reduccion){
        if (debilidad >= reduccion){
            debilidad-=reduccion;
        }
    }
    void reducirVeneno(int reduccion){
        if (veneno >= reduccion){
            veneno-=reduccion;
        }
    }
    void reducirSangrado(int reduccion){
        if (sangrado >= reduccion){
            sangrado-=reduccion;
        }
    }
    void reducirFuerza(){
        if (debilidad > 0){
            debilidad--;
        }
    }
    void reducirDebilidad(){
        if (debilidad > 0){
            debilidad--;
        }
    }
    void reducirVeneno(){
        if (veneno > 0){
            veneno--;
        }
    }
    void reducirSangrado(){
        if (sangrado > 0){
            sangrado--;
        }
    }
    //<========================| Ataque basico |========================>\\
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
    //<========================| Terminar turno |========================>\\
    int terminarTurno(){
        vida-=sangrado+veneno;
        if (vida>0){
            reducirVeneno();
            reducirSangrado();
            reducirFuerza();
            reducirDebilidad();
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
