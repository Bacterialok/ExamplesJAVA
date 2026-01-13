import java.util.ArrayList;

public class ArrayListEjemplos {
    public static void main(String[] args) {
        /*
         * Sí puede crecer o disminuir
         * 
         * Tiene métodos útiles (add, remove, get, etc.)
         * 
         * Solo puede almacenar objetos (no primitivos directamente)
         */
        //ArrayList<Integer> numeros = new ArrayList<>();

        ArrayList<String> frutas = new ArrayList<>();

        // add() – Agregar elementos
        frutas.add("Manzana");
        frutas.add("Plátano");
        frutas.add("Fresa");

        System.out.println(frutas);

        // add(index, elemento) – Insertar en posición
        frutas.add(1, "Mango");

        // get(index) – Obtener elemento
        String fruta = frutas.get(0);
        System.out.println(fruta);

        // remove()
        // Por indice
        frutas.remove(2);

        // Por valor
        frutas.remove("Mango");

        // size() – Tamaño
        System.out.println(frutas.size());

        // set(index, nuevoValor) – Reemplazar
        frutas.set(0, "Pera");

        // contains() – ¿Existe?
        if (frutas.contains("Pera")) {
            System.out.println("Sí existe");
        }

        // indexOf() – Buscar posición
        int pos = frutas.indexOf("Fresa");
        System.out.println(pos);

        // Recorrer un ArrayList
        for (int i = 0; i < frutas.size(); i++) {
            System.out.println(frutas.get(i));
        }

        // For-each
        for (String frutaa : frutas) {
            System.out.println(frutaa);
        }

        ejemplo();
    }

    // Ejemplo
    public static void ejemplo() {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        numeros.remove(1); // elimina 20

        for (int n : numeros) {
            System.out.println(n);
        }

        System.out.println("Tamaño: " + numeros.size());
    }
}
