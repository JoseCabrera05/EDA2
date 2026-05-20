package e030;

public class FilterExample {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] pares = filtrarPares(numeros);

        System.out.print("Originales: ");
        mostrar(numeros);
        System.out.print("Pares:      ");
        mostrar(pares);

        Product[] productos = {
            new Product("Teclado",    45.0, 3),
            new Product("Ratón",      25.0, 0),
            new Product("Monitor",   280.0, 1),
            new Product("Cable HDMI", 12.0, 0),
            new Product("Webcam",     60.0, 5)
        };
        Product[] disponibles = filtrarDisponibles(productos);

        System.out.println("Productos con stock:");
        for (int i = 0; i < disponibles.length; i++) {
            System.out.println("  " + disponibles[i].getNombre() + " (" + disponibles[i].getStock() + " uds.)");
        }
    }

    private static int[] filtrarPares(int[] origen) {
        int cuenta = 0;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i] % 2 == 0) {
                cuenta++;
            }
        }
        int[] resultado = new int[cuenta];
        int posicion = 0;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i] % 2 == 0) {
                resultado[posicion] = origen[i];
                posicion++;
            }
        }
        return resultado;
    }

    private static Product[] filtrarDisponibles(Product[] origen) {
        int cuenta = 0;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i].getStock() > 0) {
                cuenta++;
            }
        }
        Product[] resultado = new Product[cuenta];
        int posicion = 0;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i].getStock() > 0) {
                resultado[posicion] = origen[i];
                posicion++;
            }
        }
        return resultado;
    }

    private static void mostrar(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}
