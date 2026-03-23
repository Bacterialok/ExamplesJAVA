package Records.Ejemplos;

import POO.EjerciciosNivelUno.Producto;

record ProductoRecord1(String nombre, double precio) {
    public ProductoRecord1 {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}

public  class Ejemplo1 {
    public static void main(String[] args) {
        ProductoRecord1 p = new ProductoRecord1("Laptop", 15000);
    }
}
