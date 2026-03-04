package POO.EjerciciosNivelDos.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* Lo que hice antes 

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
        }*/

        //Lo que hizo chatgpt
        Zoologico zoologico =new Zoologico();

        zoologico.agregarAnimal(new Perro("Firulais"));
        zoologico.agregarAnimal(new Gato("Michi"));
        zoologico.agregarAnimal(new Vaca("Lola"));

        zoologico.mostrarAnimales();
        System.out.println("Domesticables");
        zoologico.mostrarDomesticables();

        System.out.println("Ordenados por nombre: ");
        zoologico.ordenarPorNombre();

        System.out.println(" - - - - - - - - -");
        zoologico.buscarPorNombre("Michi")
            .ifPresentOrElse(
                Animal::presentarse,
                () -> System.out.println("No encontrado")
            );
    }
}
