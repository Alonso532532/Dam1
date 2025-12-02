package Java.Basicos.ejercicios.Ej26;

public class Producto {
    private int numProducto;
    private String producto;
    private int cantidad;
    private double precio;
    private double IVA = 1.21;

    public Producto(int numProducto, int cantidad) {
        this.numProducto = numProducto;
        this.cantidad = cantidad;
        if (numProducto == 1){
            producto = "Manzana";
            precio = 0.69;
        } else if (numProducto == 2) {
            producto = "Pera";
            precio = 0.59;
        } else if (numProducto == 3) {
            producto = "Chokapick";
            precio = 4.99;
        } else if (numProducto == 4) {
            producto = "Donut de lotus";
            precio = 0.99;
        } else if (numProducto == 5) {
            producto = "Fanta";
            precio = 1.20;
        } else if (numProducto == 6) {
            producto = "Monster mangoloco";
            precio = 1.79;
        } else if (numProducto == 7) {
            producto = "Empanadilla de atún";
            precio = 0.79;
        } else if (numProducto == 8) {
            producto = "Bifrutas";
            precio = 1;
        }
    }

    public int getNumProducto() {
        return numProducto;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIVA() {
        return IVA;
    }

    public double precioIVA(){
        return precio*IVA;
    }
}
