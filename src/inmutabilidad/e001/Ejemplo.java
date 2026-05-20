package e001;

public class Ejemplo {

    public static void main(String[] args) {
        Persona original = new Persona("Ana", "López", 1001);

        System.out.println("Original:");
        mostrar(original);

        Persona conNombreCambiado = original.withNombre("Alicia");
        Persona conApellidoCambiado = conNombreCambiado.withApellido("Johnson");
        Persona conIdCambiado = conApellidoCambiado.withId(2002);

        System.out.println("Tras withNombre:");
        mostrar(conNombreCambiado);
        System.out.println("Tras withApellido:");
        mostrar(conApellidoCambiado);
        System.out.println("Tras withId:");
        mostrar(conIdCambiado);

        System.out.println("Original (sin cambios):");
        mostrar(original);
    }

    private static void mostrar(Persona p) {
        System.out.println("  " + p.getNombre() + " " + p.getApellido() + " [" + p.getId() + "]");
    }
}
