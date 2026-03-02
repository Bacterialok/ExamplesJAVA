package POO.EjerciciosNivelUno;
/* Ejercicio 1 – Clase Persona

Crear una clase Persona con:
- nombre
- edad
- altura

✔ Constructor
✔ Getters y setters
✔ Método esMayorDeEdad()
✔ Método toString()
*/
public class Persona {
    private String nombre;
    private int edad;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Edad: " + edad + " Altura: " + altura;
    }
}
