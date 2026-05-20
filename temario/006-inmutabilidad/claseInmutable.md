<div align=right>

<sub>[INMUTABILIDAD](README.md)  
[**Clase inmutable**](claseInmutable.md) / [Operaciones](operaciones.md)</sub>

</div>

# Clase inmutable

## ¿Por qué?

Una clase convencional expone su estado a través de setters. Cualquier código que tenga acceso al objeto puede cambiarlo en cualquier momento. El historial de ese cambio no queda registrado en ningún sitio: el objeto simplemente tiene un estado distinto al que tenía antes.

Cuando ese comportamiento produce problemas -porque dos partes del sistema modifican el mismo objeto con expectativas distintas, o porque un cambio en un componente afecta a otro sin que haya una dependencia explícita-, la respuesta habitual es añadir sincronización, encapsulación adicional o copias defensivas.

La inmutabilidad toma una dirección diferente: en lugar de proteger el acceso al estado, elimina la posibilidad de modificarlo.

## ¿Qué?

Una clase inmutable en Java tiene tres características:

1. Todos los atributos son `final`. El compilador garantiza que no se les puede asignar un valor después de la inicialización.
2. El constructor inicializa todos los atributos. No hay estado parcial ni estado por defecto: un objeto o está completamente construido o no existe.
3. No hay setters. En su lugar hay **withers**: métodos que devuelven una instancia nueva con un atributo cambiado y el resto igual.

```java
public class Persona {
    private final String nombre;
    private final String apellido;
    private final int id;

    public Persona(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }

    public Persona withNombre(String nombre) {
        return new Persona(nombre, this.apellido, this.id);
    }

    public Persona withApellido(String apellido) {
        return new Persona(this.nombre, apellido, this.id);
    }

    public Persona withId(int id) {
        return new Persona(this.nombre, this.apellido, id);
    }
}
```

El efecto es visible en el uso:

```java
Persona original = new Persona("Ana", "López", 1001);
Persona trasladada = original.withApellido("Martínez");

// original sigue siendo "Ana López 1001"
// trasladada es "Ana Martínez 1001"
// Son dos objetos distintos en memoria
```

`original` no cambia. `withApellido` no lo modifica: crea un objeto nuevo que hereda `nombre` e `id` del original y tiene el apellido nuevo. Los dos coexisten.

## ¿Para qué?

El contrato de `final` tiene una consecuencia directa sobre el razonamiento: en cualquier punto del código, si se tiene una referencia a un objeto inmutable, se sabe exactamente cuál es su estado. No es necesario seguir todas las operaciones que podrían haberlo modificado desde su construcción, porque ninguna puede haberlo hecho.

Eso simplifica el razonamiento en tres situaciones:

- **Objetos compartidos**: si el mismo objeto se pasa a varios métodos, ninguno puede alterar el estado que el otro espera encontrar.
- **Concurrencia**: dos hilos que acceden simultáneamente al mismo objeto inmutable no necesitan coordinarse, porque no hay estado que proteger.
- **Historial**: si cada modificación produce una versión nueva, las versiones anteriores siguen existiendo. Es posible conservar el estado anterior sin coste adicional.

## ¿Cómo?

### El problema con atributos mutables

`final` prohíbe reasignar la referencia, pero no impide modificar el objeto al que apunta. Si un atributo es de un tipo mutable, la garantía se rompe:

```java
public class Equipo {
    private final String nombre;
    private final int[] miembros;  // final, pero el array es mutable

    public Equipo(String nombre, int[] miembros) {
        this.nombre = nombre;
        this.miembros = miembros;  // problema: guardamos la referencia externa
    }

    public int[] getMiembros() {
        return miembros;  // problema: entregamos acceso directo al array
    }
}
```

```java
int[] ids = {1, 2, 3};
Equipo e = new Equipo("Alpha", ids);
ids[0] = 99;  // el array de e.miembros ahora también cambió
```

La corrección es copiar al recibir y no exponer la referencia directa:

```java
public class Equipo {
    private final String nombre;
    private final int[] miembros;

    public Equipo(String nombre, int[] miembros) {
        this.nombre = nombre;
        this.miembros = new int[miembros.length];
        for (int i = 0; i < miembros.length; i++) {
            this.miembros[i] = miembros[i];
        }
    }

    public int[] getMiembros() {
        int[] copia = new int[miembros.length];
        for (int i = 0; i < miembros.length; i++) {
            copia[i] = miembros[i];
        }
        return copia;
    }
}
```

La regla es: si un atributo apunta a un objeto mutable, hay que copiar al entrar y al salir. De lo contrario, la inmutabilidad es aparente.

### Conexión con el curso

El BST del módulo de orden y búsqueda muta punteros al insertar: recorre hasta la posición correcta y asigna un nodo nuevo. Una versión inmutable del mismo árbol no asigna nada sobre el árbol existente: recorre hasta la posición y construye un camino nuevo desde la raíz hasta ese punto, reutilizando todos los nodos que no están en ese camino.

El árbol resultante comparte la mayor parte de su estructura con el original. Solo el camino de inserción es nuevo. Esa reutilización hace que la operación cueste O(log n) en tiempo y O(log n) en memoria adicional, no O(n).

## *#2Think*

Una tabla hash inmutable no puede redimensionarse. El factor de carga no puede ajustarse en tiempo de ejecución. ¿Qué implica eso para la garantía de O(1) amortizado? ¿Sigue siendo posible garantizar O(1) en algún sentido?

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
