package Java.Medio.Ejercicios.Tema10.Ej3;

public class Ej3 {
    public static void main(String[] args) {
        PayPal paypal = new PayPal();
        TarjetaCredito tarjeta = new TarjetaCredito();
        TransferenciaBancaria transferencia = new TransferenciaBancaria();
        paypal.procesarpago(200);
        tarjeta.procesarpago(300);
        transferencia.procesarpago(400);
    }
}
