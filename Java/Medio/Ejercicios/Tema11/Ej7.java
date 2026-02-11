package Java.Medio.Ejercicios.Tema11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej7 {
    public static void main(String[] args) {
        List<String> lista1 = new ArrayList<>(Arrays.asList("Ann", "Carol", "Mary", "Joe",
                "John", "Kevin", "Jack", "Jack", "Lucy", "Laura", "George",
                "Ann", "Johnny", "Charlie", "Hillary"));
        List<String> lista2 = new ArrayList<>(Arrays.asList("Ann", "Martha", "Noel",
                "Mark", "Pamela", "Elisabeth", "Laura", "Jane", "Mildred",
                "Laura", "Rue", "Ann", "Jacob", "Sidney", "Sophia", "Tyler"));
        lista1.stream().filter(lista2::contains).distinct().forEach(System.out::println);
        System.out.println("<================>");
        lista1.stream().filter(a->!lista2.contains(a)).distinct().forEach(System.out::println);
        System.out.println("<================>");
        lista2.stream().filter(a->!lista1.contains(a)).distinct().forEach(System.out::println);
        System.out.println("<================>");
        List<String> lista3 = new ArrayList<>();
        lista3.addAll(lista2);
        lista3.addAll(lista1);
        lista3.stream().distinct().forEach(System.out::println);
    }
}
