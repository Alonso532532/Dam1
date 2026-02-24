package Java.Medio.Practica.Cosas.Serializacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Registro> registros = new ArrayList<>();
        try (BufferedReader leer = new BufferedReader(new FileReader("Java/Medio/Practica/Cosas/Serializacion/DATA.csv"))){
            boolean primera = true;

                String linea;
                while ((linea = leer.readLine()) != null) {
                    if (primera){
                        primera = false;
                    }else{
                        String[] elementos = linea.split(",");
                        registros.add(new Registro(Integer.parseInt(elementos[0]), elementos[1], elementos[2], Double.parseDouble(elementos[3]), Double.parseDouble(elementos[4]), elementos[5], elementos[6], elementos[7], elementos[8], LocalDateTime.parse(elementos[9].replace(" ", "T"))));
                    }
                }

        } catch (IOException | IllegalArgumentException e){
            e.printStackTrace();
        }
        registros.stream().filter(a -> a.getUltimoLogin().isAfter(LocalDateTime.parse("2015-11-01T00:00:00")) & a.getUltimoLogin().isBefore(LocalDateTime.parse("2017-01-01T00:00:00"))).sorted(Comparator.comparing(Registro::getNombre).reversed()).forEach(System.out::println);
    }
}
