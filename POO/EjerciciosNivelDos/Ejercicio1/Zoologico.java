package POO.EjerciciosNivelDos.Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Zoologico {
    private List<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarAnimales() {
        animales.forEach(Animal::presentarse);
    }

    public void mostrarDomesticables() {
        animales.stream()
        .filter(a -> a instanceof Domesticable)
        .map(a -> (Domesticable) a)
        .forEach(Domesticable::jugar);
    }

    /* Version 1
    public void ordenarPorNombre() {
        animales.sort((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
    }
    */

    // Version 2 - moderna
    public void  ordenarPorNombre() {
        animales.sort(Comparator.comparing(Animal::getNombre));
    }

    public Optional<Animal> buscarPorNombre(String nombre) {
        return animales.stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
