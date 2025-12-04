package Java.Basicos.ejercicios.Practica;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Coches {
    private static int numero = 0;
    private int numeroDeSerie;
    private int velocidad;
    private String modelo;
    private double precio;
    private LocalDate fechaDeCompra;
    private Propietario propietario;

    public Coches() {
        numeroDeSerie = ++numero;
    }

    public Coches(int velocidad, String modelo, double precio, LocalDate fechaDeCompra, Propietario propietario) {
        this.velocidad = velocidad;
        this.modelo = modelo;
        this.precio = precio;
        this.fechaDeCompra = fechaDeCompra;
        this.propietario = propietario;
        numeroDeSerie = ++numero;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDate fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    @Override
    public String toString() {
        return "Coche " + numeroDeSerie + " <" +
                " Velocidad: " + velocidad +
                " | Modelo: " + modelo +
                " | Precio: " + precio +
                " | FechaDeCompra: " + fechaDeCompra +
                " | Propietario: " + propietario.toString() +
                " >";
    }

    //Calculo el tiempo de uso
    public int uso(){
        if (fechaDeCompra == null)return 0;
        return (int) ChronoUnit.DAYS.between(fechaDeCompra, LocalDate.now());
    }

}
