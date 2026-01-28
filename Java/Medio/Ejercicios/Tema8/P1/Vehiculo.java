package Java.Medio.Ejercicios.Tema8.P1;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String matricula;
    private double precio;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Vehiculo(String marca, String modelo, int ano, String matricula, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.matricula = matricula;
        this.precio = precio;
    }

    public String descripcion(){
        return "Vehiculo marca ["+marca+"],"+"modelo ["+modelo+"],"+"año ["+ano+"],"+"matricula ["+matricula+"],"+"precio ["+precio+"]";
    }

    public int antiguedad(){
        return 2026-ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
