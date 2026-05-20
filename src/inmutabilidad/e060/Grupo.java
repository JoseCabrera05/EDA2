package e060;

public class Grupo {
    private final Persona[] personas;

    public Grupo(Persona[] personas) {
        this.personas = new Persona[personas.length];
        for (int i = 0; i < personas.length; i++) {
            this.personas[i] = personas[i];
        }
    }

    public Grupo filtrarAprobados() {
        int cuenta = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getNota() >= 50) {
                cuenta++;
            }
        }
        Persona[] resultado = new Persona[cuenta];
        int posicion = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getNota() >= 50) {
                resultado[posicion] = personas[i];
                posicion++;
            }
        }
        return new Grupo(resultado);
    }

    public Grupo filtrarAsistencia(int minimo) {
        int cuenta = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getAsistencia() >= minimo) {
                cuenta++;
            }
        }
        Persona[] resultado = new Persona[cuenta];
        int posicion = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i].getAsistencia() >= minimo) {
                resultado[posicion] = personas[i];
                posicion++;
            }
        }
        return new Grupo(resultado);
    }

    public Grupo aplicarBonificacion(int puntos) {
        Persona[] resultado = new Persona[personas.length];
        for (int i = 0; i < personas.length; i++) {
            int nuevaNota = personas[i].getNota() + puntos;
            if (nuevaNota > 100) {
                nuevaNota = 100;
            }
            resultado[i] = personas[i].withNota(nuevaNota);
        }
        return new Grupo(resultado);
    }

    public int tamanio() {
        return personas.length;
    }

    public void mostrar() {
        for (int i = 0; i < personas.length; i++) {
            System.out.println("  " + personas[i]);
        }
    }
}
