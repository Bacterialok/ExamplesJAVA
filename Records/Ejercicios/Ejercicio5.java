package Records.Ejercicios;

import java.util.Comparator;
import java.util.List;

record ProductoRecord1(String nombre, double precio) {

}

public class Ejercicio5 {
    public static void main(String[] args) {
        List<ProductoRecord1> productos = List.of(
            new ProductoRecord1("Aciduladitos",3008),
            new ProductoRecord1("Bombones", 550),
            new ProductoRecord1("Paleta Fresa", 1500),
            new ProductoRecord1("Picafresa", 500)
        );

        System.out.println("Filtrar productos > 1000");
        productos.stream().filter(p -> p.precio() > 1000).forEach(System.out::println);
        System.out.println("\nOrdenarlos por precio:");
        productos.stream().sorted(Comparator.comparing(ProductoRecord1::precio)).forEach(System.out::println);
        System.out.println("\nObtener el promedio de precios");
        System.out.println(productos.stream().mapToDouble(ProductoRecord1::precio).average());
    }
}
