package Java.Medio.Practica.MasCosas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Ficheros {
    public static void main(String[] args) {
        Path archivo1 = Path.of("Java/Medio/Practica/MasCosas/arch1.txt");
        if (!Files.exists(archivo1)){
            System.out.println("Creando el archivo");
            try {
                Files.createFile(archivo1);
            }catch (IOException e){
                System.out.println("La ruta no existe");
            }
        }
        try (RandomAccessFile editar = new RandomAccessFile( "Java/Medio/Practica/MasCosas/arch1.txt", "rw")){
            editar.write("Pascaual Pascualez \nPasc".getBytes());
            editar.write("Tete!!".getBytes());
            editar.seek(8);
            editar.write("2Iker".getBytes());
            String leer1;
            int cont = 0;
            editar.seek(0);
            while ((leer1 = editar.readLine()) != null){
                System.out.println(leer1 +" | "+(++cont));
            }
//            editar.seek(0);
//            cont=0;
//            int leer2;
//            while ((leer2 = editar.readByte()) != 0){
//                System.out.print((char)leer2);
//            } // Lanza una excepción cuando acaba
//            System.out.println(cont);
        } catch (IOException e){
            System.out.println("No se ha podido acceder al archivo");
        }
        try (BufferedReader leer = new BufferedReader(new FileReader("Java/Medio/Practica/MasCosas/arch1.txt"))){
            String linea;
            String texto = "";
            while ((linea = leer.readLine()) != null){
                texto=texto.concat(linea+"\n");
            }
            Matcher regex = Pattern.compile("\nPascTete!{0,2}").matcher(texto);
            while (regex.find()){
                System.out.println(regex.group().substring(1, 5));
            }
        } catch (IOException e){
            System.out.println("No se ha podido acceder al archivo");
        }
    }
}
