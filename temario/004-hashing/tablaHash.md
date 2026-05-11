<div align=right>

<sub>[**HASHING**](README.md)  
[La función hash](funcionHash.md) / [**Tabla hash**](tablaHash.md) / [Integridad y huellas](integridad.md)</sub>

</div>

# Tabla hash

## ¿Por qué?

La función hash lleva a una posición en O(1). El problema es que dos claves distintas pueden producir la misma posición. Si la tabla solo puede almacenar un elemento por posición, la colisión destruye el dato anterior o impide la inserción.

La solución no pasa por evitar las colisiones: el principio del palomar garantiza que existen con cualquier función que proyecte un dominio grande en un rango pequeño. La solución es diseñar una estructura que las gestione sin perder el O(1).

## ¿Qué?

Una tabla hash es un array donde cada posición no almacena un elemento sino una lista. Cuando dos elementos producen la misma posición, se añaden a la misma lista. La función hash sigue siendo O(1); el coste adicional es recorrer esa lista.

Esta estrategia se llama **encadenamiento**: los elementos que colisionan se encadenan en la misma posición.

## ¿Cómo?

### Estructura y operaciones

Cada posición del array apunta al primer nodo de una lista enlazada. Insertar añade al frente. Buscar calcula la posición y recorre su lista comparando claves:

```java
// TablaHash.java
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
}
```

```java
// Nodo.java
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
```

`valor` es de tipo `Object`: la tabla acepta cualquier tipo de objeto como valor asociado a la clave. La flexibilidad tiene un coste: el compilador no puede verificar que el tipo recuperado por `buscar` sea el esperado. Un cast incorrecto en tiempo de ejecución produce `ClassCastException`. La solución es usar genéricos (`HashMap<K,V>` en Java), que trasladan esa verificación al momento de compilación.

`insertar` es O(1): calcular posición y añadir al frente de la lista no depende del número de elementos. `buscar` calcula la posición en O(1) y recorre su lista: el coste real depende de cuántos elementos haya en esa posición.

Si las listas son cortas, `buscar` es O(1) en la práctica. Si son largas, el rendimiento se degrada. La longitud media de las listas depende de cuántos elementos hay por posición disponible.

### Factor de carga

El ratio entre elementos almacenados y posiciones disponibles determina la longitud media de las listas:

<div align=center>

```
factor_de_carga = n / m
```

`n` = número de elementos almacenados  
`m` = número de posiciones en el array

</div>

Con factor de carga 0.5 hay de media medio elemento por posición: las listas son cortas y `buscar` es casi O(1). Con factor de carga 2.0 hay de media dos elementos por posición: las listas se alargan y el rendimiento se aproxima a O(n).

El factor de carga es el dial que regula el equilibrio entre uso de memoria y velocidad de acceso.

### Redimensionamiento

Cuando el factor de carga supera un umbral, la tabla crea un array más grande y reinserta todos los elementos calculando su nueva posición con la función hash actualizada. Esa operación cuesta O(n).

Sin embargo, el redimensionamiento no ocurre en cada inserción: ocurre cuando la tabla se duplica, es decir, después de O(n) inserciones desde el último redimensionamiento. Si se distribuye ese coste O(n) entre las O(n) inserciones que lo provocaron, el coste amortizado por inserción es O(1).

Ese es el significado de O(1) **amortizado**: la mayoría de las operaciones son O(1); ocasionalmente aparece una O(n) por redimensionamiento, pero distribuida entre todas las operaciones previas resulta en O(1) por operación en el promedio.

`HashMap` en Java usa encadenamiento con umbral de factor de carga 0.75: redimensiona cuando el 75% de las posiciones tienen al menos un elemento.

### Direccionamiento abierto

La alternativa al encadenamiento: cuando hay colisión, en lugar de añadir a una lista, se busca otro slot libre dentro del mismo array. Sin memoria adicional para los nodos de lista, pero más sensible al factor de carga: los elementos desplazados tienden a concentrarse en zonas contiguas (clustering), degradando el rendimiento antes de que el factor de carga sea alto.

Con encadenamiento, el factor de carga puede superar 1.0 sin colapso estructural. Con direccionamiento abierto, el umbral práctico es considerablemente menor.

<div align=center>

| Estrategia | Memoria adicional | Sensibilidad al factor de carga | Clustering |
|-|:-:|:-:|:-:|
| Encadenamiento | nodos de lista | moderada | no |
| Direccionamiento abierto | ninguna | alta | sí |

</div>

## *#2Think*

- Con encadenamiento, ¿cuál es el peor caso teórico de `buscar`? ¿En qué condiciones se produce?
- El redimensionamiento reinserta todos los elementos con la nueva función hash. ¿Pueden colisionar tras el redimensionamiento elementos que antes no colisionaban?
- `HashMap` usa `hashCode()` del objeto Java como función hash. ¿Qué ocurre si dos objetos distintos tienen el mismo `hashCode()`? ¿Y si el mismo objeto devuelve `hashCode()` distintos en momentos diferentes?

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
