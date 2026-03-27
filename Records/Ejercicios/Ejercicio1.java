package Records.Ejercicios;

record LibroRecord1(String titulo, String autor, double precio) {
}

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println(new LibroRecord1("Harry Poter", "Alguien", 1000).toString());
    }
}
