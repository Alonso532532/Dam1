package Java.Medio.Practica;

public class Enemigo {
    String nombre;
    int vida;
    int vidaMax;
    int ataque;
    int debilidad;
    int fuerza;
    int vulnerabilidad;
    int sangrado;
    int veneno;
    int armadura;

    Modificadores mods = new Modificadores();
    //<========================| Constructor |========================>\\

    public Enemigo(int armadura, int veneno, int sangrado, int vulnerabilidad, int fuerza, int debilidad, int ataque, int vidaMax, int vida, String nombre) {
        this.armadura = armadura;
        this.veneno = veneno;
        this.sangrado = sangrado;
        this.vulnerabilidad = vulnerabilidad;
        this.fuerza = fuerza;
        this.debilidad = debilidad;
        this.ataque = ataque;
        this.vidaMax = vidaMax;
        this.vida = vida;
        this.nombre = nombre;
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
        if (fuerza > 0){
            fuerza--;
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

    public int getAtaque() {
        return ataque;
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
    }
    //<========================| Ataque basico |========================>\\
    int atacar(){
        int dano = ataque;
        int aumento = 0;
        int reduccion = 0;

        if (fuerza > 0 && debilidad == 0){
            aumento = (int) (dano * mods.getFuerza());
        } else if (fuerza == 0 && debilidad > 0) {
            reduccion = (int) (dano * mods.getDebilidad());
        }

        return dano-reduccion+aumento;
    }
    //<========================| Ataque con mod |========================>\\
    int atacar(int mod){
        return atacar()+mod;
    }
}
