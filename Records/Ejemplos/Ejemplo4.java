package Records.Ejemplos;

record EmpleadoRecord1(String nombbre, double salario) {
    public double salarioAnual() {
        return salario * 12;
    }

    public boolean esAltoIngreso() {
        return salario > 20000;
    }
}

public class Ejemplo4 {
    public static void main(String[] args) {
        System.out.println(new EmpleadoRecord1("Omar", 70000).salarioAnual());
        System.out.println(new EmpleadoRecord1("Nicolas", 90000).esAltoIngreso());
    }
}
