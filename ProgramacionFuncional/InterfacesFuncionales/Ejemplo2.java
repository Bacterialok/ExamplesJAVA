package ProgramacionFuncional.InterfacesFuncionales;

interface Saludo {
    void saludar();
}

@FunctionalInterface
interface Calculadora {
    int operar(int a, int b);
}

public class Ejemplo2 {
    public static void main(String[] args) {
        // Ejemplo 1 (sin lambda)
        Saludo saludo =new Saludo() {
            @Override
            public void saludar() {
                System.out.println("Hola");
            }
        };

        saludo.saludar();

        // Ejemplo 2 (con lambda)
        Saludo saludo2 = () -> System.out.println("Hola2");

        saludo2.saludar();

        Calculadora calculadoraSuma = (a,b) -> a + b;
        Calculadora calculadoraResta = (a, b) -> a - b;

        System.out.println(calculadoraSuma.operar(4, 3));
        System.out.println(calculadoraResta.operar(4, 3));
    }
}
