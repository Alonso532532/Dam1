package Java.Medio.Ejercicios.Tema8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej12EntreOtros {
    public static void main(String[] args) {
        System.out.println("--------Correo electrónico----------");
        String email = "asdad@sdasd.adsa";
        Matcher matcher = Pattern.compile("\\w+@\\w+\\.\\w{2,}").matcher(email);
        if (matcher.matches()) {
            System.out.println(matcher.group());
        } else {
            System.out.println("No válido");
        }
        System.out.println("---------Nº Teléfono---------");
        String telefono = "412-012-8423";
        matcher = Pattern.compile("\\d{3}-\\d{3}-\\d{4}").matcher(telefono);
        if (matcher.matches()){
            System.out.println(matcher.group());
        } else {
            System.out.println("No válido");
        }
        System.out.println("---------Mayúsculas---------");
        String texto = "HOLA BUENAS A";
        matcher = Pattern.compile("\\b[A-Z]\\w*").matcher(texto);
        System.out.println(texto);
        while (matcher.find()){
            System.out.println("Se ha encontrado: " + matcher.group());
        }
        System.out.println("--------IP---------");
        System.out.println("MANERA 1");
        String ip = "255.89.25.1";
        matcher = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+").matcher(ip);
        if (matcher.matches()){
            Matcher octeto = Pattern.compile("\\d+").matcher(ip);
            boolean valido = true;
            while (octeto.find()){
                if (Integer.parseInt(octeto.group()) > 255 || Integer.parseInt(octeto.group()) < 0){
                    System.out.println("No válido");
                    valido = false;
                    break;
                }
            }
            if (valido){
                System.out.println("OK " + matcher.group());
            }

        } else {
            System.out.println("No válido");
        }
        System.out.println("MANERA 2");
        matcher = Pattern.compile("(25[0-5]|2[0-4][0-9]|[01]\\d{1,2}|\\d{0,2})(\\.25[0-5]|\\.2[0-4][0-9]|\\.[01]\\d{0,2}|\\.\\d{1,2}){3}").matcher(ip);
        if (matcher.matches()){
            System.out.println("La ip es correcta");
        } else {
            System.out.println("La ip es incorrecta");
        }
        System.out.println("---------Fecha---------");
        String fecha = "03/12/2007";
        matcher = Pattern.compile("(3[01]|[0-2]\\d)/(1[0-2]|0\\d)/\\d{4}").matcher(fecha);
        if (matcher.matches()){
            System.out.println("La fecha es correcta");
        } else {
            System.out.println("La fecha es incorrecta");
        }
        System.out.println("---------Contraseña---------");
        String contrasena = "123122Aaa!a";
        matcher = Pattern.compile("(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}").matcher(contrasena);
        if (matcher.matches()){
            System.out.println("La contraseña es correcta");
        } else {
            System.out.println("La contraseña es incorrecta");
        }
        System.out.println("---------Vocales---------");
        String vocales = "Hola";
        System.out.println(vocales.replaceAll("[aeiouAEIOU]", "*"));
        System.out.println("---------Especiales---------");
        String especiales = "Hola #mundo juanma hecproll%";
        matcher = Pattern.compile("\\w*[@#$%^&+=!]\\w*").matcher(especiales);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
