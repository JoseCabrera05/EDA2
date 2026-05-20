package e050;

public class Ejemplo {

    public static void main(String[] args) {
        int[] notas = {45, 72, 38, 91, 60, 55, 82};

        mostrar("Notas originales:     ", notas);
        mostrar("Aprobadas:            ", filtrarAprobados(notas));
        mostrar("Con bonificación:     ", aplicarBonificacion(filtrarAprobados(notas)));

        double promedio = calcularPromedio(aplicarBonificacion(filtrarAprobados(notas)));
        System.out.println("Promedio aprobados+bonificación: " + promedio);

        mostrar("Notas originales (sin cambios):", notas);
    }

    private static int[] filtrarAprobados(int[] origen) {
        int cuenta = 0;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i] >= 50) {
                cuenta++;
            }
        }
        int[] resultado = new int[cuenta];
        int pos = 0;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i] >= 50) {
                resultado[pos] = origen[i];
                pos++;
            }
        }
        return resultado;
    }

    private static int[] aplicarBonificacion(int[] origen) {
        int[] resultado = new int[origen.length];
        for (int i = 0; i < origen.length; i++) {
            int bonificada = origen[i] + 5;
            if (bonificada > 100) {
                bonificada = 100;
            }
            resultado[i] = bonificada;
        }
        return resultado;
    }

    private static double calcularPromedio(int[] origen) {
        int suma = 0;
        for (int i = 0; i < origen.length; i++) {
            suma = suma + origen[i];
        }
        return (double) suma / origen.length;
    }

    private static void mostrar(String etiqueta, int[] arr) {
        System.out.print(etiqueta + " [");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}
