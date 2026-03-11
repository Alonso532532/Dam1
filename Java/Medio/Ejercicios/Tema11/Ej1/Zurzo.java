package Java.Medio.Ejercicios.Tema11.Ej1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Zurzo {
    public static void main(String[] args) {
        ArrayList<Registro> registros = new ArrayList<>();
        try (BufferedReader leer = new BufferedReader(new FileReader("Java/Medio/Ejercicios/Tema11/Ej1/DATA.csv"))){
            String linea;
            Boolean primera = true;
            while((linea = leer.readLine())!=null){
                if (primera){
                    primera=false;
                }else{
                    String[] separado = linea.split(",");
                    registros.add(new Registro(Integer.parseInt(separado[0]), separado[1], separado[2], Double.parseDouble(separado[3]), Double.parseDouble(separado[4]), separado[5], separado[6], separado[7], separado[8], LocalDateTime.parse(separado[9].replace(" ", "T"))));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        registros.stream().filter(a->a.getId()<=50).map(Registro::getPais).distinct().sorted().toList().reversed().forEach(System.out::println);
    }
}
