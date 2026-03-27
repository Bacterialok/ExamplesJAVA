package Records.Ejemplos;

record RectanguloRecord1(double base, double altura) {
    public double area() {
        return base * altura;
    }

    public double perimetro() {
        return 2 * area();
    }
}

public class Ejemplo2 {
    public static void main(String[] args) {
        System.out.println(new RectanguloRecord1(2,2).perimetro());
    }
}
