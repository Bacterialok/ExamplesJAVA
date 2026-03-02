public class CuentaBancariaPractica {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0)
            saldo += monto;
        else
            System.out.println("Solo se permiten montos mayores a 0");
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) //No se permite retirar todo el saldo por que no puede quedar en negativo
            saldo -= monto;
        else 
            System.out.println("El monto excede su saldo");
    }

    public static void main(String[] args) {
        CuentaBancariaPractica cuenta = new CuentaBancariaPractica();
        cuenta.depositar(-100);
        cuenta.retirar(5000);
    }
}