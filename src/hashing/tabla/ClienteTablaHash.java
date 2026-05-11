public class ClienteTablaHash {
    public static void main(String[] args) {
        TablaHash tabla = new TablaHash();

        tabla.insertar("Bisolvon Alvarez", 7);
        tabla.insertar("Flutox Castro", 9);
        tabla.insertar("Voltaren Diaz", 6);
        tabla.insertar("Gelocatil Martinez", 8);
        tabla.insertar("Ventolin Moreno", 5);

        System.out.println("Nota de Flutox Castro:  " + tabla.buscar("Flutox Castro"));
        System.out.println("Nota de Ventolin Moreno: " + tabla.buscar("Ventolin Moreno"));
        System.out.println("Busqueda inexistente:    " + tabla.buscar("Nolotil Rodriguez"));
        System.out.println("Factor de carga:         " + tabla.factorDeCarga());
    }
}
