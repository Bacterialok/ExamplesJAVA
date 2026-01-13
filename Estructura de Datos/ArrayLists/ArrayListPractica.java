import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPractica {
    public static void main(String[] args) {
        System.out.println("- - - UNO - - -");
        ejercicioUno();
        System.out.println("- - - DOS - - -");
        ejercicioDos();
        System.out.println("- - - TRES - - -");
        ejercicioTres();
        System.out.println("- - - CUATRO - - -");
        ejercicioCuatro();
    }

    public static void ejercicioUno() {
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Nicolas");
        nombres.add("Omar");
        nombres.add("Diego");
        nombres.add("Ondina");
        nombres.add("Guadalupe");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    public static void ejercicioDos() {
        ArrayList<String> colores = new ArrayList<>(
                Arrays.asList("rojo", "azul", "verde", "amarillo"));

        System.out.println(colores.indexOf("verde"));

    }

    public static void ejercicioTres() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);

        /*
         * for (int i = numeros.size() - 1; 0 < i; i--) {
         * // System.out.println("Tamaño: " + numeros.size() + " i= " + i);
         * if (numeros.get(i)%2 == 0) {
         * numeros.remove(i);
         * }
         * }
         */

        // CORRECION
        for (int i = numeros.size() - 1; i >= 0; i--) {
            if (numeros.get(i) % 2 == 0) {
                numeros.remove(i);
            }
        }

        // MEJOR SOLUCION 
        numeros.removeIf(n -> n % 2 == 0);

        System.out.println(numeros);
    }

    public static void ejercicioCuatro() {
        ArrayList<Double> numeros = new ArrayList<>();
        numeros.add(1.0);
        numeros.add(2.5);
        numeros.add(3.2);
        numeros.add(4.4);
        numeros.add(5.8);
        numeros.add(6.5);
        numeros.add(7.8);
        numeros.add(8.9);
        numeros.add(9.1);
        numeros.add(10.0);

        double mayor = numeros.get(0), menor = numeros.get(0), suma = 0.0;

        for (Double numero : numeros) {
            if (numero < menor)
                menor = numero;

            if (numero > mayor)
                mayor = numero;

            suma += numero;
        }

        System.out.println("Promedio: " + suma / numeros.size());
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
    }
}
