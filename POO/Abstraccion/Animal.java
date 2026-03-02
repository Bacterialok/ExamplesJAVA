public abstract class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void dormir() {
        System.out.println("El animal duerme");
    }

    public abstract void hacerSonido();
}
