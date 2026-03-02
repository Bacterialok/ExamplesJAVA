public class UsuarioPractica {
    private String username;
    private String password;

    public UsuarioPractica(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        if (password.length() >= 8)
            this.password = password;
        else 
            System.out.println("La contraseña debe tener minimo 8 caracteres");
    }

    public String getUsername() {
        if (username != null)
            return username;
        else
            return "No existe ningun username";
    }

    public String getPassword() {
        if (password != null)
            return password;
        else
            return "No existe ningun password";
    }

    public static void main(String[] args) {
        UsuarioPractica usuarioPractica = new UsuarioPractica("Omar");
        usuarioPractica.setPassword("Holahola");

        System.out.println(usuarioPractica.getUsername());
        System.out.println(usuarioPractica.getPassword());
    }
}
