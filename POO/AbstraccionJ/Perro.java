package POO.AbstraccionJ;

public class Perro extends Animal{
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El perro ladra");
    }

    public static void main(String[] args) {
        Animal perro = new Perro("Solovino");

        perro.dormir();
        perro.hacerSonido();
    }
}
