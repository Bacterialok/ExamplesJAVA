package ProgramacionFuncional.ClasesAnonimas;

abstract class Animal {
    abstract void sonido();
}

public class EjemploClaseAbstracta {
    public static void main(String[] args) {
        Animal perro = new Animal() {
            @Override
            void sonido() {
                System.out.println("Guau guau");
            }
        };

        perro.sonido();
    }
}
