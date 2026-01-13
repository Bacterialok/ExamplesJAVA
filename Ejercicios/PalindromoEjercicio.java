public class PalindromoEjercicio {
    public static void main(String[] args) {
        palindromo("anita lava la tina");

    }

    public static void palindromo(String palabra) {

        String auxiliar = "";
        String[] palabras = palabra.split(" ");
        for (String palabr : palabras) {
            auxiliar += palabr;
        }
        String[] letras = auxiliar.split("");
        boolean esPalindromo = true;

        for (int i = 0; i < letras.length / 2; i++) {
            System.out.println("Cliclo: " + i + " | " + letras[i] + " " + letras[letras.length - 1 - i]);
            if (!letras[i].equals(letras[letras.length - 1 - i])) {
                System.out.println("Error");
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo)
            System.out.println("Es palindromo");
        else
            System.out.println("No es palindromo");
    }

    public static void palindromoChatGPT(String palabra) {

    palabra = palabra.toLowerCase().replace(" ", "");
    boolean esPalindromo = true;

    for (int i = 0; i < palabra.length() / 2; i++) {
        System.out.println(
            "Ciclo: " + i + " | " +
            palabra.charAt(i) + " " +
            palabra.charAt(palabra.length() - 1 - i)
        );

        if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
            esPalindromo = false;
            break;
        }
    }

    System.out.println(esPalindromo ? "Es palindromo" : "No es palindromo");
}
}
