package POO.EjerciciosNivelDos.Ejercicio1;

public class Perro extends Animal implements Domesticable {

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Wuf");
    }

    @Override
    public void jugar() {
        System.out.println(getNombre() + " esta jugando");    
    }
}
