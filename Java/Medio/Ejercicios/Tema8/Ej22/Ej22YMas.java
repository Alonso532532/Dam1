package Java.Medio.Ejercicios.Tema8.Ej22;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej22YMas {
     public static void main(String[] args) {
         ArrayList<String> texto = new ArrayList<>();
         System.out.println("<===================| Ej22 y 23 |===================>");
         try (BufferedReader buffer = new BufferedReader( new FileReader("Java/Medio/Ejercicios/Tema8/Ej22/texto.txt"))){
             String linea;
             int palabras=0;
             while ((linea=buffer.readLine()) != null){
                 Matcher contar = Pattern.compile("\\S+").matcher(linea);
                 while (contar.find()){
                     System.out.println(contar.group());
                     palabras++;
                 }
                 linea = linea.replaceAll("Hola", "Adios");
                 texto.add(linea);
             }

             System.out.println(palabras);
         } catch (IOException e){
            System.out.println("El archivo no existe");
         }

         System.out.println("<===================| Ej23, //24, 25 y 26 |===================>");
         Scanner sc = new Scanner(System.in);
         System.out.print("Dame una cadena a buscar > ");
         String cad = sc.nextLine();
         System.out.print("Y una longitud > ");
         int longitud = sc.nextInt();
         try (FileWriter escribir = new FileWriter("Java/Medio/Ejercicios/Tema8/Ej22/texto.txt")){
             int cont = 0;
             int contLong = 0;
             for (String i : texto){
                 //i = new StringBuilder(i).reverse().toString();
                 Matcher filtro = Pattern.compile(cad).matcher(i);
                 Matcher dist = Pattern.compile("\\b\\S{"+longitud+"}\\b").matcher(i);
                 if (filtro.find()){
                     cont++;
                 }
                 while (dist.find()){
                     System.out.println(dist.group());
                     contLong++;
                 }
                 escribir.write(i+"\n");
             }
             System.out.println("La cadena " + cad + " aparece " + cont + " veces en distintas lineas y aparecen " + contLong + " palabras con la longitud determinada");

         } catch (IOException e){
             System.out.println("El archivo no existe");
         }
     }
}
