package Java.Medio.Practica.Lambda;

public class lamda2 {
    interface calculo{

        double operacion(double a, double b);
    }

    public static void main(String[] args) {
        calculo suma = Double::sum;
        System.out.println(suma.operacion(2,3));
    }
}
