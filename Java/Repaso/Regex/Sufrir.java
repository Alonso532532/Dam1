package Java.Repaso.Regex;

import java.util.regex.Pattern;

public class Sufrir {
    public static void main(String[] args) {
        System.out.println("Contraseña");
        String texto = "12123W?";
        Pattern patron = Pattern.compile("(?=.*[A-Z])(?=.*[?¿=·%€!¡]).{5,10}");
        System.out.println(patron.matcher(texto).matches() ? "correcto" : "terrible");
        System.out.println("IP");
        texto = "252.2.2.2";
        patron = Pattern.compile("((25[0-5]|2[0-4][0-9]|1\\d{2}|\\d?\\d)\\.){3}(25[0-5]|2[0-4][0-9]|1\\d{2}|\\d?\\d)");
        System.out.println(patron.matcher(texto).matches() ? "correcto" : "terrible");
    }
}
