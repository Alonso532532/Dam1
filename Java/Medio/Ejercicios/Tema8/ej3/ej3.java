package Java.Medio.Ejercicios.Tema8.ej3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ej3 {
    public static void main(String[] args) {
        File archivo = new File("Java\\Medio\\Ejercicios\\Tema8\\ej3\\Directorio\\ejercicio.txt");
        for (int i = 1; i < 3; i++){

            // Copio 2 veces el archivo, el "StandardCopyOption.REPLACE_EXISTING"
            try {
                File destino = new File("Java\\Medio\\Ejercicios\\Tema8\\ej3\\Directorio\\ejercicio" + i + ".txt");
                System.out.println("Creando \""+destino.getName()+"\"");
                Files.copy(archivo.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e){
                System.out.println("Ha ocurrido un error durante la copia");
                e.printStackTrace();
            }
        }
        // Creo una estructura de carpetas, importatnte: "mkdirs" no "mkdir"
        File carpetas1 = new File("Java\\Medio\\Ejercicios\\Tema8\\ej3\\Directorio\\docs\\samples");
        File carpetas2 = new File("Java\\Medio\\Ejercicios\\Tema8\\ej3\\Directorio\\docs\\exercises");

        if (carpetas1.mkdirs()){
            System.out.println("Carpetas " + carpetas1.getParent() + carpetas1.getPath().substring( carpetas1.getPath().lastIndexOf("docs")-1) + " creadas");
        } else {
            System.out.println("Error garrafal durante la creación de los directorios " + carpetas1.getPath().substring( carpetas1.getPath().lastIndexOf("docs")-1));
        }

        if (carpetas2.mkdir()){
            System.out.println("Carpetas " + carpetas2.getParent() + carpetas2.getPath().substring( carpetas2.getPath().lastIndexOf("docs")-1) + " creadas");
        } else {
            System.out.println("Error garrafal durante la creación de los directorios " + carpetas2.getPath().substring( carpetas2.getPath().lastIndexOf("docs")-1));
        }
    }
}
