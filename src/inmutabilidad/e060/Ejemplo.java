package e060;

public class Ejemplo {

    public static void main(String[] args) {
        Grupo grupo = new Grupo(new Persona[] {
            new Persona("Ana",    "López",    72, 85),
            new Persona("Carlos", "García",   45, 92),
            new Persona("María",  "Martínez", 61, 70),
            new Persona("Pedro",  "Sánchez",  88, 95),
            new Persona("Laura",  "Díaz",     53, 78)
        });

        System.out.println("Grupo original (" + grupo.tamanio() + "):");
        grupo.mostrar();

        Grupo resultado = grupo
            .filtrarAprobados()
            .filtrarAsistencia(80)
            .aplicarBonificacion(1);

        System.out.println("Aprobados con asistencia >= 80% y +1 punto (" + resultado.tamanio() + "):");
        resultado.mostrar();

        System.out.println("Grupo original sin cambios (" + grupo.tamanio() + "):");
        grupo.mostrar();
    }
}
