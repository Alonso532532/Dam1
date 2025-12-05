package Java.Basicos.ejercicios.Practica;

import java.security.PrivateKey;
import java.time.LocalDate;

public class Propietario {
    private String nombre;
    private String DNI;

    public Propietario() {
    }

    public Propietario(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "[ Nombre: " + nombre +
                " y DNI: " + DNI +
                " ]";
    }
}
