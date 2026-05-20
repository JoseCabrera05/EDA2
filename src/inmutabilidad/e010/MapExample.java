package e010;

public class MapExample {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int[] cuadrados = cuadrado(numeros);

        System.out.print("Originales: ");
        mostrar(numeros);
        System.out.print("Cuadrados:  ");
        mostrar(cuadrados);

        Person[] personas = {
            new Person("Juan", "Pérez", 25),
            new Person("Ana", "García", 30),
            new Person("Carlos", "López", 22)
        };
        PersonDto[] dtos = resumir(personas);

        System.out.println("Personas como resumen:");
        for (int i = 0; i < dtos.length; i++) {
            System.out.println("  " + dtos[i].getNombreCompleto() + ", " + dtos[i].getEdad() + " años");
        }
    }

    private static int[] cuadrado(int[] origen) {
        int[] resultado = new int[origen.length];
        for (int i = 0; i < origen.length; i++) {
            resultado[i] = origen[i] * origen[i];
        }
        return resultado;
    }

    private static PersonDto[] resumir(Person[] origen) {
        PersonDto[] resultado = new PersonDto[origen.length];
        for (int i = 0; i < origen.length; i++) {
            resultado[i] = new PersonDto(
                origen[i].getNombre() + " " + origen[i].getApellido(),
                origen[i].getEdad()
            );
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
