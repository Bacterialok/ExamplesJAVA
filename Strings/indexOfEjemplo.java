public class indexOfEjemplo {
    public static void main(String[] args) {
        String palabras = "Hola Mundo Java";
        System.out.println(palabras.indexOf("s"));

        int[] numeros = { 4, 7, 10, 3 };
        int indice = indexOf(numeros, 2);

        if (indice != -1) {
            System.out.println("Encontrado en el indice: " + indice);
        } else {
            System.out.println("No encontrado");
        }
    }

    public static int indexOf(int[] array, int buscado) {

        if (array == null || array.length == 0) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == buscado) {
                return i;
            }
        }

        return -1;
    }
}
