class Persona {
    private String nombre;
    private int edad;

    // Getter
    public int getEdad() {
        return edad;
    }

    // Setter con validación
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona();

        System.out.println(p.getEdad());

        p.setEdad(20); //Válido
        p.setEdad(-5); //No permitido

        System.out.println(p.getEdad());
    }
}