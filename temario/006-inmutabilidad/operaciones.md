<div align=right>

<sub>[INMUTABILIDAD](README.md)  
[Clase inmutable](claseInmutable.md) / [**Operaciones**](operaciones.md)</sub>

</div>

# Operaciones sobre colecciones

## ¿Por qué?

Una colección mutable ofrece `add`, `remove`, `set`. Cada una altera la colección sobre la que se invoca. El resultado de una operación es el mismo objeto en un estado distinto.

Si la colección no puede mutarse, esas operaciones no desaparecen: cambian de forma. Transformar una colección pasa a significar producir una colección nueva que refleja la transformación. La original no se toca.

La pregunta es si ese cambio de forma produce código más difícil de escribir o si, al contrario, las operaciones se vuelven más componibles.

## ¿Qué?

Tres operaciones cubren la mayor parte de las transformaciones que normalmente se realizan con mutación:

| Operación | Entrada | Salida | Qué hace |
|---|---|---|---|
| **map** | colección de A | colección de B | aplica una función a cada elemento |
| **filter** | colección de A | colección de A | conserva solo los elementos que cumplen una condición |
| **reduce** | colección de A | valor de B | combina todos los elementos en un único resultado |

Ninguna de las tres modifica la colección de entrada.

## ¿Cómo?

### map

Dado un array de enteros, producir un array con cada valor duplicado:

```java
// Con mutación (estilo habitual)
int[] original = {1, 2, 3, 4, 5};
for (int i = 0; i < original.length; i++) {
    original[i] = original[i] * 2;  // modifica el original
}

// Sin mutación
int[] original = {1, 2, 3, 4, 5};
int[] dobles = new int[original.length];
for (int i = 0; i < original.length; i++) {
    dobles[i] = original[i] * 2;
}
// original sigue siendo {1, 2, 3, 4, 5}
// dobles es {2, 4, 6, 8, 10}
```

La diferencia no es el algoritmo: es sobre qué array se escribe el resultado.

### filter

Dado un array de enteros, producir un array con solo los valores pares:

```java
int[] original = {1, 2, 3, 4, 5, 6};

// Primera pasada: contar cuántos elementos pasan el filtro
int cuenta = 0;
for (int i = 0; i < original.length; i++) {
    if (original[i] % 2 == 0) {
        cuenta++;
    }
}

// Segunda pasada: construir el resultado
int[] pares = new int[cuenta];
int pos = 0;
for (int i = 0; i < original.length; i++) {
    if (original[i] % 2 == 0) {
        pares[pos] = original[i];
        pos++;
    }
}
// original sigue siendo {1, 2, 3, 4, 5, 6}
// pares es {2, 4, 6}
```

Filter no puede escribir directamente sobre el original porque el resultado puede ser más corto. Necesita construir un array nuevo del tamaño correcto.

### reduce

Dado un array de enteros, calcular la suma:

```java
int[] valores = {1, 2, 3, 4, 5};

int suma = 0;
for (int i = 0; i < valores.length; i++) {
    suma = suma + valores[i];
}
// suma es 15
// valores no se modificó
```

Reduce no produce una colección nueva: produce un valor. La colección de entrada no cambia porque el resultado vive en una variable distinta, no en la colección original.

### Composición

Las tres operaciones se pueden encadenar: el resultado de una es la entrada de la siguiente.

```java
// Dado un array de notas, calcular el promedio de los aprobados

int[] notas = {45, 72, 38, 91, 60, 55, 82};

// Paso 1: filter - conservar solo aprobados (>= 50)
int cuentaAprobados = 0;
for (int i = 0; i < notas.length; i++) {
    if (notas[i] >= 50) cuentaAprobados++;
}
int[] aprobados = new int[cuentaAprobados];
int pos = 0;
for (int i = 0; i < notas.length; i++) {
    if (notas[i] >= 50) {
        aprobados[pos] = notas[i];
        pos++;
    }
}

// Paso 2: reduce - sumar los aprobados
int suma = 0;
for (int i = 0; i < aprobados.length; i++) {
    suma = suma + aprobados[i];
}

// Paso 3: calcular promedio
double promedio = (double) suma / aprobados.length;

// notas no se modificó en ningún paso
```

Cada paso produce un resultado nuevo. El array `notas` permanece intacto al final del cálculo.

## Conexión con el curso

Estas tres operaciones no son nuevas. En el módulo de recursividad se implementaron versiones recursivas de las mismas sin ponerles nombre:

- Una función que recorre una lista y construye una lista nueva con cada elemento transformado es map.
- Una función que recorre una lista y construye una lista nueva con solo los elementos que cumplen una condición es filter.
- Una función que recorre una lista y acumula un resultado es reduce.

La diferencia es el nivel de abstracción: allí se describía el mecanismo de recorrido; aquí se nombra el patrón que ese recorrido implementa.

## *#2Think*

Map, filter y reduce pueden expresarse en términos de reduce solo. Map es un reduce que acumula una colección transformada. Filter es un reduce que acumula solo los elementos que pasan la condición. ¿Qué dice eso sobre la relación entre las tres operaciones? ¿Cuál es la más fundamental?

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
