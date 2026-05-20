package e060;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final int nota;
    private final int asistencia;

    public Persona(String nombre, String apellido, int nota, int asistencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
        this.asistencia = asistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNota() {
        return nota;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public Persona withNota(int nota) {
        return new Persona(this.nombre, this.apellido, nota, this.asistencia);
    }

    public String toString() {
        return nombre + " " + apellido + " [nota=" + nota + ", asistencia=" + asistencia + "%]";
    }
}
