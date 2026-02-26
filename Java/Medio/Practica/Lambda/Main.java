package Java.Medio.Practica.Lambda;

public class Main {
    interface Operacion {
        double operar(double a, double b);
    }
    interface Operacion2{
        double operar(double a, double b, double c);
    }
    public static void main(String[] args) {
        Operacion2 suma2 = (double a, double b, double c) -> a+b+c;
        Operacion suma = Double::sum;
        Operacion resta = (a, b) -> a-b;
        Operacion multi = (a, b) -> a*b;
        Operacion divi = (a, b) -> b <= 0 ? 0 : a/b;
        System.out.println(suma.operar(4, 5));
        System.out.println(resta.operar(8,3));
        System.out.println(multi.operar(2, 6));
        System.out.printf("%.2f", divi.operar(60, 6));
        System.out.println("\n"+divi.operar(21, -4));
        System.out.printf("%.2f",suma2.operar(2,5,2));
    }
}
