package e001;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final int id;

    public Persona(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }

    public Persona withNombre(String nombre) {
        return new Persona(nombre, this.apellido, this.id);
    }

    public Persona withApellido(String apellido) {
        return new Persona(this.nombre, apellido, this.id);
    }

    public Persona withId(int id) {
        return new Persona(this.nombre, this.apellido, id);
    }
}
