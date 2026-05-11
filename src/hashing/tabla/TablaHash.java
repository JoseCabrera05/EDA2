public class TablaHash {

    private static final int CAPACIDAD_INICIAL = 16;
    private Nodo[] tabla;
    private int cantidad;

    public TablaHash() {
        tabla = new Nodo[CAPACIDAD_INICIAL];
    }

    public void insertar(String clave, Object valor) {
        int posicion = Math.abs(clave.hashCode()) % tabla.length;
        tabla[posicion] = new Nodo(clave, valor, tabla[posicion]);
        cantidad++;
    }

    public Object buscar(String clave) {
        int posicion = Math.abs(clave.hashCode()) % tabla.length;
        Nodo actual = tabla[posicion];
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public double factorDeCarga() {
        return (double) cantidad / tabla.length;
    }
}
