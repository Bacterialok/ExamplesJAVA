package Records.Ejercicios;

record PuntoRecord1(int x, int y) {
    public int distanciaOrigen() {
        return Math.abs(x) + Math.abs(y);
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println(new PuntoRecord1(-2, 4).distanciaOrigen());
    }
}
