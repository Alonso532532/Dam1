package Java.Medio.Practica.Cosas.Lamda;

public class prueba {
    public static void main(String[] args) {
        operacion suma = (x, y) -> x + y;
        operacion division = (x, y) -> y != 0 ? x / y : 0;
        System.out.println(suma.operar(2, 5));
        System.out.println(division.operar(4, 3));
    }
}
