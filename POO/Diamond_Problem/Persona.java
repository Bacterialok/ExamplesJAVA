package POO.Diamond_Problem;

//Error: inherits unrelated defaults for saludar()
public class Persona implements A, B {
    /*
     * Cómo se soluciona
     * - La clase debe decidir explícitamente.
     */
    @Override
    public void saludar() {
        A.super.saludar();
        // O
        //B.super.saludar();
        // Cualquiera de las dos soluciones son correctas
    }

    /*
     * O crear tu propia implementación.
    @Override
    public void saludar() {
        System.out.println("Hola desde Persona");
    } */
}
