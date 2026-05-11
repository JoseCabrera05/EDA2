public class ActaCalificaciones {

    private static final int CAPACIDAD = 100;
    private Persona[] personas;
    private String[] hashes;
    private int cantidad;

    public ActaCalificaciones() {
        personas = new Persona[CAPACIDAD];
        hashes = new String[CAPACIDAD];
        cantidad = 0;
    }

    public void agregarPersona(Persona persona) {
        personas[cantidad] = persona;
        hashes[cantidad] = persona.getHash();
        cantidad++;
    }

    public void modificarCalificacion(int indice, int nuevaCalificacion) {
        personas[indice].setCalificacion(nuevaCalificacion);
    }

    public boolean verificarIntegridad() {
        for (int i = 0; i < cantidad; i++) {
            String hashActual = personas[i].getHash();
            if (!hashActual.equals(hashes[i])) {
                System.out.println("Manipulacion detectada: " + personas[i]);
                return false;
            }
        }
        return true;
    }
}
