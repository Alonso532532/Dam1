package Java.Repaso.Regex;

import java.util.regex.Pattern;

public class Sufrir {
    public static void main(String[] args) {
        System.out.println("Contraseña");
        String texto = "12WWWWWW?";
        Pattern patron = Pattern.compile("(?=\\S*[A-Z])(?=\\S*[?¿=·%€!¡]).{5,10}");
        System.out.println(patron.matcher(texto).matches() ? "correcto" : "terrible");
        texto = "123.123.123.123";
        patron = Pattern.compile("((25[0-5]|2[0-4][0-9]|\\d?\\d)\\.){3}25[0-5]|2[0-4][0-9]|\\d?\\d");
        System.out.println(patron.matcher(texto).matches() ? "correcto" : "terrible");
    }
}
