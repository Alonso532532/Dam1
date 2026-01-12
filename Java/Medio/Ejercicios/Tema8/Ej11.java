package Java.Medio.Ejercicios.Tema8;

public class Ej11 {
    public static void main(String[] args) {
        String texto = " hola  buenas   tardes     ";
        texto = texto.trim();
        texto = texto.replaceAll(" {2,}", " ");
        System.out.println(texto);
    }
}
