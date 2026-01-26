package Java.Medio.Ejercicios.Tema10.Ej3;

public class PayPal extends MetodoPago{
    @Override
    public void procesarpago(double monto) {
        System.out.println("Se procesa un pago de: "+monto+" mediante PayPal");
    }
}
