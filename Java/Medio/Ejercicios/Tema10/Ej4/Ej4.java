package Java.Medio.Ejercicios.Tema10.Ej4;

public class Ej4 {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Pascual");
        CuentaBancaria cuenta2 = new CuentaBancaria("Celia");
        cuenta1.depositar(200);
        cuenta1.retirar(50);
        cuenta1.mostrarSaldo();
        cuenta2.mostrarSaldo();
    }
}
