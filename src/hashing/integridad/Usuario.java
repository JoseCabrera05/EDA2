import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {

    private String nombre;
    private String hashContrasena;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.hashContrasena = calcularHash(contrasena);
    }

    public boolean verificarContrasena(String contrasena) {
        return hashContrasena.equals(calcularHash(contrasena));
    }

    private String calcularHash(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(texto.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException excepcion) {
            return "";
        }
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Paracetamol", "1234segura");

        System.out.println("Contrasena correcta:   " + usuario.verificarContrasena("1234segura"));
        System.out.println("Contrasena incorrecta: " + usuario.verificarContrasena("1234"));
    }
}
