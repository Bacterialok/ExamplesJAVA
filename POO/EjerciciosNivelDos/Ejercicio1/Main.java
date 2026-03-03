package POO.EjerciciosNivelDos.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales =new ArrayList<>();
        animales.add(new Perro("Firulas"));
        animales.add(new Gato("Michi"));
        animales.add(new Vaca("Lola"));

        for (Animal animal : animales) {
            animal.presentarse();
        }

        System.out.println("\nAnimales domestiables");

        for (Animal animal : animales) {
            if (animal instanceof Domesticable domesticable) {
                domesticable.jugar();
            }
        }
    }
}
