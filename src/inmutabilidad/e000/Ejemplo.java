package e000;

public class Ejemplo {

    public static void main(String[] args) {
        Persona original = new Persona("Ana", "López", 1001);

        System.out.println("Persona original:");
        mostrar(original);

        Persona alias = original;

        System.out.println("'Otra' persona (mismo objeto):");
        mostrar(alias);

        alias.setNombre("Roberto");
        alias.setApellido("Martínez");
        alias.setId(9999);

        System.out.println("Después de modificar 'alias':");
        System.out.println("original:");
        mostrar(original);
        System.out.println("alias:");
        mostrar(alias);
    }

    private static void mostrar(Persona p) {
        System.out.println("  " + p.getNombre() + " " + p.getApellido() + " [" + p.getId() + "]");
    }
}
