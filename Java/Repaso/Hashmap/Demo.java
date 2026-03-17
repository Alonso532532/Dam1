package Java.Repaso.Hashmap;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> hashOrdenado = new LinkedHashMap<>();

        hashOrdenado.put("B", 3);
        hashOrdenado.put("D", 2);
        hashOrdenado.put("A", 4);
        hashOrdenado.put("C", 1);
        hashOrdenado.put("E", 1);
        hashOrdenado.put("T", 1);
        hashOrdenado.put("X", 1);

        System.out.println(hashOrdenado);
    }
}
