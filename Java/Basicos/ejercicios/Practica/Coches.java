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


    public Coches() {
        numeroDeSerie = numero++;
    }

    public Coches(int velocidad, String modelo, double precio, LocalDate fechaDeCompra) {
        this.velocidad = velocidad;
        this.modelo = modelo;
        this.precio = precio;
        this.fechaDeCompra = fechaDeCompra;
        numeroDeSerie = numero++;
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

    //Calculo el tiempo de uso
    public int uso(){
        return (int) ChronoUnit.DAYS.between(fechaDeCompra, LocalDate.now());
    }

}
