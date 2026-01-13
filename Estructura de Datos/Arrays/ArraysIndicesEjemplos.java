public class ArraysIndicesEjemplos {
    public static void main(String[] args) {
        //ArraysIndicesEjemplos arraysIndicesEjemplos = new ArraysIndicesEjemplos();

        //arraysIndicesEjemplos.arrayInvertido();
        ejercicioUno();
        System.out.println("- - - - - -");
        ejercicioDos();
        System.out.println("- - - - - -");
        ejercicioTres();
        System.out.println("- - - - - -");
        ejercicioCuatro();
        
    }

    public static void ejercicioUno() {
        int[] numeros = {1, 3, 2, 5};

        if (numeros.length > 0) {
            for (int i = 0; i < numeros.length; i++)
            {
                System.out.println("Indice " + i + " -> " + numeros[i]);
            }
        }
    }

    public static void ejercicioDos() {
        int[] numeros = {1, 3, 2, 5};
        int total = 0;
        int mayor = 0;
        int menor = 0;
        if (numeros.length > 0) {
            mayor = numeros[0];
            menor = numeros[0];
            for (int i = 0; i < numeros.length; i++) {
                total += numeros[i]; 

                if (mayor < numeros[i])
                    mayor = numeros[i];

                if (menor > numeros[i])
                    menor = numeros[i];
            }
        }

        double promedio = (double) total / numeros.length;

        System.out.println("Total: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
    }

    public static void ejercicioTres() {
        int[] numeros = {1, 3, 2, 5};
        
        int pares = 0;
        if (numeros.length > 0) {
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] % 2 == 0)
                    pares++;
            }
        }

        System.out.println("Hay " + pares + " pares");
        System.out.println("Hay " + (numeros.length - pares) + " impares");
    }

    public static void ejercicioCuatro() {
        int[] numeros = {1, 3, 2, 5};
        
        if (numeros.length > 0) {
            for (int i = 0; i < numeros.length / 2; i++) {
                int temporal = numeros[i];
                numeros[i] = numeros[numeros.length - 1 - i];
                numeros[numeros.length - 1 - i] = temporal;
            }
        }

        System.out.print("El array invertido: ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }

    public void arrayInvertido() {
        int[] numeros = { 20, 52, 73, 100, 104 };

        System.out.println(numeros.length);

        /* Guarda en el temp el primer dato del array, 
        despues guarda el ultimo dato del array en la posicion i que es 0 osea el primero y para guardarlo usa el tamaño del arreglo - 1 - i (5 - 1 - 0),
        despues mediante la misma formula de arriba guarda lo de temp que es el primer valor en el ultimo,
        asi sigue hasta que invierte de posiciones el arreglo y en caso de ser impar solamente ignora el de enmedio porque queda igual */

        for (int i = 0; i < numeros.length / 2; i++) {
            System.out.println("Clico: " + i);
            int temp = numeros[i];
            System.out.println("temp: " + temp);
            numeros[i] = numeros[numeros.length - 1 - i];
            System.out.println("numeros: " + numeros[i]);
            numeros[numeros.length - 1 - i] = temp;
        }

        System.out.println("- - - - - - - - -");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
