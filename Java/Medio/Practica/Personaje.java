package Java.Medio.Practica;

public class Personaje {
    String nombre;
    int vida;
    int vidaMax;
    public int ataque;
    public int debilidad;
    public int fuerza;
    int vulnerabilidad;
    int sangrado;
    int veneno;
    int armadura;
    public int energia;
    int energiaMax;

    public Personaje(String nombre, int vida, int ataque, int armadura, int energia, int energiaMax) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vida;
        this.ataque = ataque;
        this.debilidad = 0;
        this.fuerza = 0;
        this.vulnerabilidad = 0;
        this.sangrado = 0;
        this.veneno = 0;
        this.armadura = armadura;
        this.energia = energia;
        this.energiaMax = energiaMax;
    }

    //<========================| Aumentos de estadisticas |========================>\\
    void aumentarVida(int aumento){
        vida+=aumento;
    }
    void aumentarVidaMax(int aumento){
        vidaMax+=aumento;
    }
    void aumentarFuerza(int aumento){
        fuerza+=aumento;
    }
    void aumentarDebilidad(int aumento){
        debilidad+=aumento;
    }
    void aumentarVulnerabilidad(int aumento){
        vulnerabilidad+=aumento;
    }
    void aumentarVeneno(int aumento){
        veneno+=aumento;
    }
    void aumentarSangrado(int aumento){
        sangrado+=aumento;
    }
    void aumentarVida(){
        vida++;
    }
    void aumentarVidaMax(){
        vidaMax++;
    }
    void aumentarFuerza(){
        fuerza++;
    }
    void aumentarDebilidad(){
        debilidad++;
    }
    void aumentarVulnerabilidad(){
        vulnerabilidad++;
    }
    void aumentarVeneno(){
        veneno++;
    }
    void aumentarSangrado(){
        sangrado++;
    }

    //<========================| Reduccion de estadisticas |========================>\\
    void reducirVida(int reduccion){
        if (vida >= reduccion){
            vida-=reduccion;
        }
    }
    void reducirVidaMax(int reduccion){
        if (vidaMax >= reduccion){
            vidaMax-=reduccion;
        }
    }
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
    void reducirVulnerabilidad(int reduccion){
        if (vulnerabilidad >= reduccion){
            vulnerabilidad-=reduccion;
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
    void reducirVida(){
        if (vida > 0){
            vida--;
        }
    }
    void reducirVidaMax(){
        if (vidaMax > 0){
            vidaMax--;
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
    void reducirVulnerabilidad(){
        if (vulnerabilidad > 0){
            vulnerabilidad--;
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

    //<========================| Getters |========================>\\
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getDebilidad() {
        return debilidad;
    }

    public int getVulnerabilidad() {
        return vulnerabilidad;
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

    //<========================| Terminar turno |========================>\\
    void terminarTurno(){
        vida-=sangrado+veneno;
        if (vida>0){
            reducirVeneno();
            reducirSangrado();
            reducirFuerza();
            reducirDebilidad();
            reducirVulnerabilidad();
        }
    }
    //<========================| Recibir daño |========================>\\
    void recibirDano(int dano){
        System.out.println("¡Recibes ["+dano+"] de daño!");
        if (armadura>0){
            if (armadura>=dano){
                armadura-=dano;
            } else {
                dano=dano-armadura;
                armadura=0;
                vida-=dano;
            }
        } else {
            vida-=dano;
        }
        if (vida <= 0){
            terminarPartida();
        }
    }
    void terminarPartida(){
        System.out.println("Partida terminada");
    }
}
