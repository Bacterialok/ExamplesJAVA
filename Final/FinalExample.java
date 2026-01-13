public class FinalExample {
    public static final double PI = 3.1416; // Constante final
    public int value = 10; 
    public final int x;
    public final int y;
    { 
        y = 20; // initializer block (sí es válido)
    }
    

    // Solamente se puede asignar una variable final una vez si no fue declarada en línea

    FinalExample() {
        // PI = 3.14; // Esto causará un error de compilación
        value++;
        x = 5; // Se puede asignar en el constructor
        System.out.println("Valor incrementado: " + value);
    }
    public static void main(String[] args) {
        System.out.println("El valor de PI es: " + PI);

        final FinalExample example = new FinalExample();
        final FinalExample example2 = new FinalExample();
        FinalExample example3 = new FinalExample();

        example3.value = 50;
        System.out.println("Valor modificado en example3: " + example3.value);

        example3 = new FinalExample(); // Esto es válido perno no se puede hacer con 'example' o 'example2' no se pueden reasignar o instanciar de nuevo
        System.out.println("Nuevo valor en example3: " + example3.value); 

        example2.value = 30;
        System.out.println("Valor modificado en example2: " + example2.value);

        example.value = 20; 
        System.out.println("Valor modificado en example: " + example.value);
    }
}

class Animal {
    public final void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    // public void makeSound() { // Esto causará un error de compilación, no puede sobrescribirse (override) un método final
    //     System.out.println("Bark");
    // }
}

final class Cat {
    public void makeSound() {
        System.out.println("Meow");
    }
}

// class PersianCat extends Cat { // Esto causará un error de compilación, no se puede extender una clase final 

// }