package Java.Medio.Ejercicios.Tema10.Ej5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private String requisitos = "^(?=.*[A-Z])(?=.*\\d)\\S{8,}$";
    private String nombreUsuario;
    private String contrasena;

    public Usuario(String nombreUsuario, String contrasena) {
        if (Pattern.matches(requisitos, contrasena)){
            this.nombreUsuario = nombreUsuario;
            this.contrasena = contrasena;
        } else {
            throw new IllegalArgumentException("Contraseña no valida");
        }

    }

    public boolean verificarContrasena(String ingreso){
        return contrasena.equals(ingreso);
    }

    public void cambiarContrasena(String nuevaContrasena){
        if (Pattern.matches(requisitos, nuevaContrasena)){
            contrasena = nuevaContrasena;
        } else {
            throw new IllegalArgumentException("Contraseña no valida");
        }
    }
}