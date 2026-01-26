package Java.Medio.Ejercicios.Tema10.Ej4;

public class CuentaBancaria {
    private static int num = 0;

    private int numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular) {
        this.numeroCuenta = ++num;
        this.titular = titular;
        this.saldo = 0;
    }

    void depositar(double monto){
        saldo += monto;
    }

    void retirar(double monto){
        if (monto<=saldo){
            saldo -= monto;
        } else {
            throw new IllegalArgumentException("No se puede retirar más dinero del que hay");
        }

    }

    void mostrarSaldo(){
        System.out.println(saldo+" en la cuenta "+numeroCuenta);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }


}
