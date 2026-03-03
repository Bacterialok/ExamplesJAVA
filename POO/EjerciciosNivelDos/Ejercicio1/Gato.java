package POO.EjerciciosNivelDos.Ejercicio1;

public class Gato extends Animal implements Domesticable {

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void jugar() {
        System.out.println(getNombre() + " esta jugando");  
    }
}
