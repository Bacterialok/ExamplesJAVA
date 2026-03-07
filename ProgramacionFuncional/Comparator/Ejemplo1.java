package ProgramacionFuncional.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

public class Ejemplo1 {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Luis", 20));
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("Ana", 23));
        personas.add(new Persona("Luis", 29));
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("Ana", 50));
        personas.add(new Persona("Luis", 10));
        personas.add(new Persona("Carlos", 9));

        //Lista sin edades ordenadas
        for (Persona persona : personas) {
            System.out.println(persona.edad);
        }

        //Ordeno las edads
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.edad - p2.edad;
            }
        });

        System.out.println();

        //Lista con edades ordenadas
        for (Persona persona : personas) {
            System.out.println(persona.edad);
        }
    }
}
