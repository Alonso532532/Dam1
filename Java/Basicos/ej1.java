package Java.Basicos;
public class ej1 {
    public static void main(String[] args) {
        int segundos = 6832, minutos, horas;

        horas = segundos / 3600;
        minutos =  (segundos % 3600) / 60;
        segundos = segundos % 60;

        System.out.print("El resultado es " + horas + "h, " + minutos + "m, " + segundos + "s.");
    }
}