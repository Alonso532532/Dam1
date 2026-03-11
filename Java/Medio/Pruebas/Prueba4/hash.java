package Java.Medio.Pruebas.Prueba4;

import java.util.*;

public class hash {
    public static void main(String[] args) {
        HashMap<String, Integer> breva = new HashMap<>(Map.of("Heproll", 3, "Lydia", 1, "Juanma", 2));
        ArrayList<Map.Entry<String, Integer>> holaHecproll = new ArrayList<>(breva.entrySet());
        holaHecproll.stream().sorted(Map.Entry.comparingByValue()).toList().reversed().forEach(System.out::println);
    }
}
