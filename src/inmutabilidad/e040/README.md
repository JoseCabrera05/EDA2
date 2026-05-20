# Reduce

## ¿Qué?

Reduce combina todos los elementos de un array en un único valor. En cada paso, el acumulador incorpora el elemento actual. Al terminar el recorrido, el acumulador contiene el resultado. El array original no se modifica.

## ¿Cómo?

El ejemplo calcula el total de ventas de un conjunto de pedidos. El reduce aparece en dos niveles.

Dentro de cada pedido, `calcularTotal` suma el importe de cada línea:

```java
public double calcularTotal() {
    double total = 0;
    for (int i = 0; i < lineas.length; i++) {
        total = total + lineas[i].getPrecio() * lineas[i].getCantidad();
    }
    return total;
}
```

Sobre el conjunto de pedidos, `calcularTotal` en `ReduceExample` acumula el total de cada pedido:

```java
private static double calcularTotal(Order[] pedidos) {
    double total = 0;
    for (int i = 0; i < pedidos.length; i++) {
        total = total + pedidos[i].calcularTotal();
    }
    return total;
}
```

La estructura es idéntica en ambos niveles: acumulador inicializado a cero, bucle que incorpora cada elemento, valor devuelto al terminar.
