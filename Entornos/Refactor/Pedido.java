package Entornos.Refactor;

public class Pedido {
    public void procesarPedido(String tipoCliente, double totalCompra) {

        // paso tipoCliente a mayusculas para evitar posibles errores futuros

        tipoCliente = tipoCliente.toUpperCase();

        // Para evitar la repetición de código calcúlo antes el descuento a aplicar y luego lo imprimo todo

        double descuento = 0;

        if (tipoCliente.equals("NORMAL")) {

            if (totalCompra > 100) {
                descuento = 0.05;
            } else {
                System.out.println("Sin descuento");
                System.out.println("Total: " + totalCompra);
                return;
            }

        } else if (tipoCliente.equals("VIP")) {

            if (totalCompra > 100) {
                descuento = 0.2;
            } else {
                descuento = 0.1;
            }

        } else {
            System.out.println("Tipo de cliente desconocido");
        }

        System.out.println("Descuento "+descuento*100+"%");
        System.out.println("Total: "+ (totalCompra - totalCompra * descuento));
    }
}