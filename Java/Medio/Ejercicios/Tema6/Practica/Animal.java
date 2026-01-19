package Java.Medio.Ejercicios.Tema6.Practica;

public class Animal {
    static int id=0;
    int numSerie;
    String nombre;
    int edad;
    public Animal(String nombre, int edad) {
        numSerie=++id;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "numSerie=" + numSerie +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    void hacerRuido(){
        System.out.print("El animal "+numSerie+" hace un ruido: ");
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
