package Java.Medio.Pruebas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        String texto = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tincidunt nisi eget metus gravida fermentum. Duis tempus tortor eget 
                blandit ultricies. Nulla eget lacinia nisi. Fusce ut erat venenatis, fermentum felis ac, dapibus ipsum. Morbi posuere dignissim convallis
                Aenean viverra augue eu mauris tristique, eget lacinia quam efficitur. amam amAl Maecenas euismod maximus aliquam. Integer gravida elit id tempus
                """;
        Matcher cosa = Pattern.compile("").matcher(texto);
        while (cosa.find()){
            System.out.println(cosa.group());
        }
    }
}
