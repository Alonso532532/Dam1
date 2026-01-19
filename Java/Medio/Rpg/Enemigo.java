package Java.Medio.Rpg;

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
    public void aumentarVida(int aumento){
        vida+=aumento;
    }
    public void aumentarVidaMax(int aumento){
        vidaMax+=aumento;
    }
    public void aumentarFuerza(int aumento){
        fuerza+=aumento;
    }
    public void aumentarDebilidad(int aumento){
        debilidad+=aumento;
    }
    public void aumentarVulnerabilidad(int aumento){
        vulnerabilidad+=aumento;
    }
    public void aumentarVeneno(int aumento){
        veneno+=aumento;
    }
    public void aumentarSangrado(int aumento){
        sangrado+=aumento;
    }
    public void aumentarVida(){
        vida++;
    }
    public void aumentarVidaMax(){
        vidaMax++;
    }
    public void aumentarFuerza(){
        fuerza++;
    }
    public void aumentarDebilidad(){
        debilidad++;
    }
    public void aumentarVulnerabilidad(){
        vulnerabilidad++;
    }
    public void aumentarVeneno(){
        veneno++;
    }
    public void aumentarSangrado(){
        sangrado++;
    }

    //<========================| Reduccion de estadisticas |========================>\\
    public void reducirVida(int reduccion){
        if (vida >= reduccion){
            vida-=reduccion;
        }
    }
    public void reducirVidaMax(int reduccion){
        if (vidaMax >= reduccion){
            vidaMax-=reduccion;
        }
    }
    public void reducirFuerza(int reduccion){
        if (fuerza >= reduccion){
            fuerza-=reduccion;
        }
    }
    public void reducirDebilidad(int reduccion){
        if (debilidad >= reduccion){
            debilidad-=reduccion;
        }
    }
    public void reducirVulnerabilidad(int reduccion){
        if (vulnerabilidad >= reduccion){
            vulnerabilidad-=reduccion;
        }
    }
    public void reducirVeneno(int reduccion){
        if (veneno >= reduccion){
            veneno-=reduccion;
        }
    }
    public void reducirSangrado(int reduccion){
        if (sangrado >= reduccion){
            sangrado-=reduccion;
        }
    }
    public void reducirVida(){
        if (vida > 0){
            vida--;
        }
    }
    public void reducirVidaMax(){
        if (vidaMax > 0){
            vidaMax--;
        }
    }
    public void reducirFuerza(){
        if (fuerza > 0){
            fuerza--;
        }
    }
    public void reducirDebilidad(){
        if (debilidad > 0){
            debilidad--;
        }
    }
    public void reducirVulnerabilidad(){
        if (vulnerabilidad > 0){
            vulnerabilidad--;
        }
    }
    public void reducirVeneno(){
        if (veneno > 0){
            veneno--;
        }
    }
    public void reducirSangrado(){
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
    public void terminarTurno(){
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
    public void recibirDano(int dano){
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
    public int atacar(){
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
    public int atacar(int mod){
        return atacar()+mod;
    }
}
