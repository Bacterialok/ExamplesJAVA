package POO.EjerciciosNivelDos.Ejercicio1;

public abstract class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void presentarse() {
        System.out.print(nombre + " dice: ");
        hacerSonido();
    }

    public abstract void hacerSonido();
}
