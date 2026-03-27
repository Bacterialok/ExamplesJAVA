package Records.Ejercicios;

record CuentaBancaria1(String titular, double saldo) {
    public CuentaBancaria1 depositar(double cantidad) {
        return new CuentaBancaria1(titular, saldo + cantidad);
    }

    public CuentaBancaria1 retirar(double cantidad) {
        return new CuentaBancaria1(titular, saldo - cantidad);
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        CuentaBancaria1 cb1 = new CuentaBancaria1("Omar", 4000);
        System.out.println(cb1.toString());

        CuentaBancaria1 cb2 = cb1.depositar(4000);
        System.out.println(cb2.toString());

        CuentaBancaria1 cb3 = cb2.retirar(1250);
        System.out.println(cb3.toString());
    }
}
