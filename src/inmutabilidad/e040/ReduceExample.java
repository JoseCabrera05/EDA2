package e040;

public class ReduceExample {

    public static void main(String[] args) {
        Order[] pedidos = {
            new Order("A001", new OrderItem[] {
                new OrderItem("Producto1", 10.0, 2),
                new OrderItem("Producto2", 15.0, 1)
            }),
            new Order("A002", new OrderItem[] {
                new OrderItem("Producto3", 20.0, 3),
                new OrderItem("Producto4",  5.0, 4)
            })
        };

        double totalVentas = calcularTotal(pedidos);
        System.out.println("Total de ventas: " + totalVentas);
    }

    private static double calcularTotal(Order[] pedidos) {
        double total = 0;
        for (int i = 0; i < pedidos.length; i++) {
            total = total + pedidos[i].calcularTotal();
        }
        return total;
    }
}
