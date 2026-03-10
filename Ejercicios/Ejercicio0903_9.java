import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Persona2 {
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona2(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return nombre + " " + edad + " " + ciudad;
    }
}

public class Ejercicio0903_9 {
    public static void main(String[] args) {
        List<Persona2> personas = List.of(
            new Persona2("Ana", 25, "Puebla"),
            new Persona2("Luis", 20, "Puebla"),
            new Persona2("Carlos", 30, "Guadalajara"),
            new Persona2("Mario", 28, "Puebla"),
            new Persona2("Pedro", 19, "CDMX"),
            new Persona2("Sofia", 35, "Guadalajara")
        );

        Map<String, List<Persona2>> grupos = 
        personas.stream()
        .collect(Collectors.groupingBy(Persona2::getCiudad));
        
        grupos.forEach((ciudad, lista) -> {
            System.out.println(ciudad + ": ");
            lista.forEach(System.out::println);
            System.out.println();
        });
    }
}
