package Records.Ejercicios;

record AlumnoRecord1(String nombre, double calificacion) {
    public String aprobado() {
        return calificacion >= 6 ? "Esta aprobado" : "No esta aprobado";
    }

    public String estado() {
        if (calificacion == 10)
            return "Exelente";
        else if (calificacion >= 8) 
            return "Bueno";
        else if (calificacion >= 6) 
            return "Regular";
        else 
            return "Reprobado";
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println(new AlumnoRecord1("Omar", 9).aprobado());
        System.out.println(new AlumnoRecord1("Lupita", 10).estado());
        System.out.println(new AlumnoRecord1("Nicolas", 5).estado());
        System.out.println(new AlumnoRecord1("Diego", 5).aprobado());
    }
}
