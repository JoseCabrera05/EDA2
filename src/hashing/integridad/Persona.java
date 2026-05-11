import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Persona {

    private String nombre;
    private String apellido;
    private int calificacion;

    public Persona(String nombre, String apellido, int calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getHash() {
        try {
            String datos = nombre + apellido + calificacion;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(datos.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException excepcion) {
            return "";
        }
    }

    public String toString() {
        return nombre + " " + apellido + " - " + calificacion;
    }
}
