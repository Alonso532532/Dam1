package Java.Medio.Ejercicios.Tema8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej9 {
    public static void main(String[] args) {
        String texto = """
                IES SEGUNDO DE CHOMÓN
                C/ Pablo Monguió, 48
                44002 Teruel
                Teléfono: 978 60 13 21
                Fax: 978 60 00 80
                Email: iesschteruel@educa.aragon.es
                Web: www.iesch.org""";
        Pattern correop = Pattern.compile("[\\w.%+-]+@[\\w.%+-^_]+\\.[a-zA-Z]{2,}");
        Matcher correom = correop.matcher(texto);
        Pattern codigop = Pattern.compile("\\d{5}");
        Matcher codigom = codigop.matcher(texto);
        Pattern telefonop = Pattern.compile("\\d{3} \\d{2} \\d{2} \\d{2}");
        Matcher telefonom = telefonop.matcher(texto);
        Pattern webp = Pattern.compile("www\\.\\w+\\.[a-z]{2,}");
        Matcher webm = webp.matcher(texto);
        if (correom.find()){
            System.out.println("<----------------------------->\nCorreo " + correom.group());
        } else {
            System.out.println("<----------------------------->\nNo hay");
        }
        if (codigom.find()){
            System.out.println("<----------------------------->\nCódigo postal " + codigom.group());
        } else {
            System.out.println("<----------------------------->\nNo hay");
        }
        if (telefonom.find()){
            System.out.println("<----------------------------->\nTeléfono " + telefonom.group());
        } else {
            System.out.println("<----------------------------->\nNo hay");
        }
        if (webm.find()){
            System.out.println("<----------------------------->\nDirección web " + webm.group() + "\n<----------------------------->");
        } else {
            System.out.println("<----------------------------->\nNo hay\n<----------------------------->");
        }
    }

}
