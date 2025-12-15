package Java.Medio.Ejercicios.Tema8.ej3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class ej3 {
    public static void main(String[] args) {
        File archivo = new File("Directorio\\ejercicio.txt");
        for (int i = 1; i < 3; i++){
            File destino = new File("Directorio\\ejercicio" + i + ".txt");
            //Files.copy(archivo, destino, StandardCopyOption.REPLACE_EXISTING);

        }
    }
}
