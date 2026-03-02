package POO.EjerciciosNivelUno;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<CuentaBancaria> cuentasBancarias;

    public Banco() {
        cuentasBancarias =new ArrayList<CuentaBancaria>();
    }

    public Banco(List<CuentaBancaria> cuentaBancarias) {
        this.cuentasBancarias = cuentaBancarias;
    }

    /* No valide que se dupliquen las cuentas
    public void agregarCuenta(CuentaBancaria cuentaBancaria) {
        cuentasBancarias.add(cuentaBancaria);
    } */

    public boolean agregarCuenta(CuentaBancaria cuentaBancaria) {
    if (buscarCuenta(cuentaBancaria.getTitular()) == null) {
        cuentasBancarias.add(cuentaBancaria);
        return true;
    }
    return false;
}

    public CuentaBancaria buscarCuenta(String titular) {
        for (CuentaBancaria cuentaBancaria : cuentasBancarias) {
            if (titular.equals(cuentaBancaria.getTitular())) {
                return cuentaBancaria;
            }
        }
        return null;
    }

    public boolean transferir(String origen, String destino, double monto) {
        CuentaBancaria cb1 = buscarCuenta(origen);
        CuentaBancaria cb2 = buscarCuenta(destino);
        
        return (cb1 != null && cb2 != null) ? cb1.transferir(cb2, monto) : false;
    }

    public static void main(String[] args) {
        CuentaBancaria persona1 = new CuentaBancaria("Omar", 3000);
        CuentaBancaria persona2 = new CuentaBancaria("Nicolas", 3000);

        Banco banco =new Banco();
        banco.agregarCuenta(persona2);
        banco.agregarCuenta(persona1);
        
        banco.transferir("Nicolas", "Omar", 300);

        System.out.println(banco.buscarCuenta("Omar"));
        System.out.println(banco.buscarCuenta("Nicolas"));
    }
}
