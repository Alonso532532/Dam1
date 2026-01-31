package Java.Medio.Rpg;

public class Sala {
    int columna;
    int fila;
    String tipo;
    boolean[] caminos = new boolean[3];
    String[] estilo = new String[12];
    public Sala(int columna, int fila, String tipo, boolean[] caminos, String[] estilo) {
        this.columna = columna;
        this.fila = fila;
        this.tipo = tipo;
        this.caminos = caminos;
        this.estilo = estilo;
    }

    public Sala(int columna, int fila, String tipo, boolean[] caminos) {
        this.columna = columna;
        this.fila = fila;
        this.tipo = tipo;
        this.caminos = caminos;
    }

    public Sala(int columna, int fila, String tipo) {
        this.columna = columna;
        this.fila = fila;
        this.tipo = tipo;
    }



    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean[] getCaminos() {
        return caminos;
    }

    public void setCaminos(boolean[] caminos) {
        this.caminos = caminos;
    }

    public String[] getEstilo() {
        return estilo;
    }

    public void setEstilo(String[] estilo) {
        this.estilo = estilo;
    }
}
