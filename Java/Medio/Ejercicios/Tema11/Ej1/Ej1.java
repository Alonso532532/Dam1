package Java.Medio.Ejercicios.Tema11.Ej1;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ej1 {
    static List<Registro> registros = new ArrayList<>();
    public static void main(String[] args) {

        try (BufferedReader leer = new BufferedReader( new FileReader("Java/Medio/Ejercicios/Tema11/Ej1/DATA.csv"))){
            String linea;
            boolean primera=true;
            while ((linea = leer.readLine()) != null){
                if (!primera){
                     String[] registro = linea.split(",");
                     registros.add(new Registro(Integer.parseInt(registro[0]), registro[1], registro[2], Double.parseDouble(registro[3]), Double.parseDouble(registro[4]), registro[5], registro[6], registro[7], registro[8], LocalDateTime.parse(registro[9].replace(" ", "T"))));
                } else {
                    primera=false;
                }
            }
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
      //  registros.forEach(System.out::println);
        System.out.println("1- Los registros del pahís FR");
        registros.stream().filter(registro -> registro.getPais().equals("FR")).forEach(System.out::println);

        System.out.println("<==========================>\n<==========================>\n<==========================>\n<==========================>\n<==========================>");
        System.out.println("2- Los registros con email de yahoo ordenados por nombre");
        registros.stream().filter(registro -> registro.getEmail().contains("@yahoo")).sorted(Comparator.comparing(Registro::getNombre)).forEach(System.out::println);

        System.out.println("<==========================>\n<==========================>\n<==========================>\n<==========================>\n<==========================>");
        System.out.println("3- Los registros con el último login entre noviembre de 2015 y enero de 2017 ambos incluidos ordenados por fecha de manera descendente.");
        registros.stream().filter(registro -> registro.getLast_login_date().isAfter(LocalDateTime.parse("2015-11-01T00:00:00")) && registro.getLast_login_date().isBefore(LocalDateTime.parse("2017-01-01T00:00:00"))).forEach(System.out::println);

        System.out.println("<==========================>\n<==========================>\n<==========================>\n<==========================>\n<==========================>");
        System.out.println("3- Los nombres y apellidos de los registros cuyo nombre (first_name) empiecen por ‘A’ ordenados por fecha (descendente) del último inicio de sesión (last_login).");
        registros.stream().filter(registro -> registro.getNombre().startsWith("A")).sorted(Comparator.comparing(Registro::getLast_login_date)).map(a->a.getNombre()+" "+ a.getApellido()).forEach(System.out::println);
        System.out.println("<==========================>\n<==========================>\n<==========================>\n<==========================>\n<==========================>");
        System.out.println("Practica");
//        registros.stream().filter(a->a.getId()>10 &&a.getId()<50).map(a).forEach(System.out::println);
    }
}
