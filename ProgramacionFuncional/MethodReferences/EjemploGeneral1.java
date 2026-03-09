package ProgramacionFuncional.MethodReferences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}

public class EjemploGeneral1 {
    public static void main(String[] args) { 

        /* Lista inmutable
        List<Persona> personas = List.of(
            new Persona("Ana", 25),
            new Persona("Luis", 20),
            new Persona("Carlos", 30)
        ); */

        //Lista no inmutable
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Luis", 20));
        personas.add(new Persona("Carlos", 30));

        personas.sort(Comparator.comparing(Persona::getEdad));

        // Ordenar con lambda
        //personas.sort((a,b) -> a.getEdad() - b.getEdad());

        // Ordenar con method reference
        personas.sort(Comparator.comparing(Persona::getEdad));

        //Ejemplo con streams y Method Reference
        personas.stream()
        .map(Persona::getEdad)
        .forEach(System.out::println);
        System.out.println();

        //Ejemplo con streams y Lambda
        System.out.println();
        personas.stream()
        .map(p -> p.getNombre())
        .forEach(n -> System.out.println(n));
        System.out.println();

        List<String> nombres = List.of("Ana", "Luis", "Carlos", "Eva");
        nombres.stream()
        .filter(nombre -> nombre.length() > 3)
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);
    }
}
