package Java.Medio.Practica.Cosas.Serializacion;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Registro {
    private int id;
    private String nombre;
    private String apellido;
    private double latitud;
    private double longitud;
    private String dominio;
    private String email;
    private String pais;
    private String ip;
    private LocalDateTime ultimoLogin;

    public Registro(int id, String nombre, String apellido, double latitud, double longitud, String dominio, String email, String pais, String ip, LocalDateTime ultimoLogin) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dominio = dominio;
        this.email = email;
        this.pais = pais;
        setIp(ip);
        this.ultimoLogin = ultimoLogin;
    }

    public Registro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) throws IllegalArgumentException {
        Pattern patron = Pattern.compile("((25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");
        if (patron.matcher(ip).matches()) {
            this.ip = ip;
        } else {
            throw new IllegalArgumentException("IP incorrecta");
        }

    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", dominio='" + dominio + '\'' +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
                ", ip='" + ip + '\'' +
                ", ultimoLogin=" + ultimoLogin +
                '}';
    }
}
