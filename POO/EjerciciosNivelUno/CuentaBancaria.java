package POO.EjerciciosNivelUno;
/* Ejercicio 2 – Clase CuentaBancaria
Crear una clase CuentaBancaria con:
- titular
- saldo

✔ Constructor
✔ Método depositar(double monto)
✔ Método retirar(double monto) (no permitir saldo negativo)
✔ Método consultarSaldo()
✔ toString()
*/
public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria() {

    }

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        } else {
            return false;
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String getTitular(){
        return titular;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (saldo >= monto && retirar(monto)) {
            destino.depositar(monto);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Titular: " + titular + ", Saldo: " + saldo;
    }

    public static void main(String[] args) {
        CuentaBancaria persona1 = new CuentaBancaria("Omar", 3000);
        CuentaBancaria persona2 = new CuentaBancaria("Nicolas", 3000);

        persona1.transferir(persona2, 300);
        System.out.println("P1: " + persona1.consultarSaldo());
        System.out.println("P2: " + persona2.consultarSaldo());
    }
}
