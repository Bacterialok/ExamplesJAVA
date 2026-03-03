package POO.EjerciciosNivelUno;

/*Ejercicio 3 – Producto
* Clase Producto:
*   - nombre
*   - precio
*   - categoria
* Métodos:
*   - aplicarDescuento(double porcentaje)

    validación para que no acepte más de 100%
    redondeo a 2 decimales
    que no permita precio negativo
    agregar toString()
*/
public class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    public Producto() {

    }

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        if (precio >= 0) {
            this.precio = precio;
        } else {
            this.precio = 0;
        }

        this.categoria = categoria;
    }

    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            precio -= precio * porcentaje / 100;
            precio = Math.round(precio * 100) / 100;
            precio = Math.max(0, precio);
            return true;
        }

        return false;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto {" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Producto p1 = new Producto("Ventilador", 5400.50, "Electrodomestico");
        p1.aplicarDescuento(33);

        System.out.println(p1.getPrecio());
    }
}
