public class ClienteIntegridad {
    public static void main(String[] args) {
        ActaCalificaciones acta = new ActaCalificaciones();
        acta.agregarPersona(new Persona("Bisolvon", "Alvarez", 7));
        acta.agregarPersona(new Persona("Flutox", "Castro", 9));
        acta.agregarPersona(new Persona("Voltaren", "Diaz", 6));

        System.out.println("Integridad inicial: " + acta.verificarIntegridad());

        acta.modificarCalificacion(1, 10);

        System.out.println("Integridad tras modificar nota de Flutox Castro: " + acta.verificarIntegridad());
    }    
}
