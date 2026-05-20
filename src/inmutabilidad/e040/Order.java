package e040;

class Order {
    private final String numeroPedido;
    private final OrderItem[] lineas;

    public Order(String numeroPedido, OrderItem[] lineas) {
        this.numeroPedido = numeroPedido;
        this.lineas = new OrderItem[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            this.lineas[i] = lineas[i];
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < lineas.length; i++) {
            total = total + lineas[i].getPrecio() * lineas[i].getCantidad();
        }
        return total;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public OrderItem[] getLineas() {
        return lineas;
    }
}
