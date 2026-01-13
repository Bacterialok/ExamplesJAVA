public class indexOfPractica {

    public static void main(String[] args) {
        int[] numeros = {1, 4, 8, 10 ,3, 4, 10, 2};
        int resultado = lastIndexOf(numeros, 2);

        if (resultado != -1) 
            System.out.println("Se encontro en el indice en la posicion: " + resultado);
        else 
            System.out.println("No se encontro en el indice");
    }

    public static int indexOf(int[] array, int buscado) {

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (buscado == array[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static int lastIndexOf(int[] array, int buscado) {
        int indice = -1;
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == buscado) {
                    indice = i;
                }
            }
            return indice;
        }
        return -1;
    }

    public static int lastIndexOfCHATGPT(int[] array, int buscado) {
    if (array == null || array.length == 0) {
        return -1;
    }

    for (int i = array.length - 1; i >= 0; i--) {
        if (array[i] == buscado) {
            return i;
        }
    }
    return -1;
}
}