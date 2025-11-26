package Java.Medio.Clases;

public class Personas {
    private Double peso;
    private Double altura;
    private Integer edad;
    private String dni;
    private String  Nombre;

    // Creo el constructor

    public Personas() {
    }

    public Personas(Double peso, Double altura, Integer edad, String dni, String nombre) {
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.dni = dni;
        this.Nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
