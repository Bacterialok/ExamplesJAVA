public class ArraysEjemplos {
    public static void main(String[] args) {
        // ejemploUno(); 
        ArraysEjemplos arraysEjemplos = new ArraysEjemplos();
        // arraysEjemplos.ejemploDos();
        // arraysEjemplos.ejemploTres();
        arraysEjemplos.ejemploCuatro();
    }

    public void ejemploCuatro() {
        int[] numeros = {5, 10, 15, 20};
        int suma = 0;
        int mayor = numeros[0];
        for (int numero : numeros) {
            suma += numero;
            if (mayor < numero) {
                mayor = numero;
            }
        }

        System.out.println("La suma es: " + suma);

        System.out.println("El numero mayor es:" + mayor);
    }

    public void ejemploTres() {
        String[] nombres = {"Omar", "Diego", "Nicolas", "Pedro"};
        for(String nombre : nombres) {
            System.out.println(nombre);
        }
        System.out.println("La cantidad de nombres escritos es: " + nombres.length);
    }

    public void ejemploDos() {
        double[] temp = {22.5, 23.0, 21.8, 24.1};
        double suma = 0;for (double t : temp) {
            suma += t;
        }

        double promedio = suma / temp.length;
        System.out.println("Temperatura promedio: " + promedio);
    }

    public static void ejemploUno() {
        int[] numeros = {1,2,3,4,5};

        for (int num : numeros) {
            System.out.println(num);    
        }
    }
}
