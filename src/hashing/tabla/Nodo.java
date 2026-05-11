public class Nodo {

    String clave;
    Object valor;
    Nodo siguiente;

    Nodo(String clave, Object valor, Nodo siguiente) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = siguiente;
    }
}
