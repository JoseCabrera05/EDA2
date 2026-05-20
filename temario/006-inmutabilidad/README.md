<div align=right>

<sub>[**INMUTABILIDAD**](README.md)  
[Clase inmutable](claseInmutable.md) / [Operaciones](operaciones.md)</sub>

</div>

# Inmutabilidad

## ¿Por qué?

Todo el recorrido del curso ha sido mutación.

||||||
|-|-|-|-|-|
|Insertion sort desplaza elementos en el mismo array|Quicksort particiona in-place|El BST muta punteros al insertar un nodo|La tabla hash redimensiona su array interno cuando el factor de carga lo exige|El módulo de recursividad culminó con backtracking: mutar el estado, explorar un camino, restituir el estado original.

La mutación es eficiente y directa. También tiene un coste que no siempre es visible.

### El problema del estado compartido

Cuando dos partes del código comparten una referencia al mismo objeto, cualquiera de las dos puede modificarlo. La otra no tiene forma de saberlo. El objeto que se tenía en un momento puede ser distinto al de un momento después, sin que haya ocurrido ninguna asignación explícita en el código que lo usa.

```java
Persona p = new Persona("Ana", "López", 1001);
registrar(p);              // ¿modifica p? ¿devuelve algo? no hay forma de saberlo sin leer registrar()
System.out.println(p.getNombre());  // ¿sigue siendo "Ana"?
```

Este problema se llama ***aliasing***: una sola realidad en memoria accesible desde múltiples nombres. Mientras más grande es el sistema, más difícil es rastrear qué partes del código podrían haber tocado un objeto entre un punto y otro.

La solución habitual es la disciplina: documentar qué métodos modifican sus argumentos, hacer copias defensivas, restringir el acceso mediante encapsulación. Todas son respuestas válidas, pero también añaden complejidad.

### La restricción como alternativa

La pregunta que abre este módulo no busca gestionar mejor la mutación:

**¿Y si no fuera posible modificar nada?**

No es una propuesta ideológica. Es una restricción artificial que, como todas las restricciones en este curso, revela propiedades interesantes cuando se la toma en serio.

Si un objeto no puede modificarse después de su creación, el aliasing deja de ser un problema: dos referencias al mismo objeto inmutable son equivalentes porque ninguna puede cambiar lo que la otra ve. La pregunta "¿sigue siendo Ana?" tiene una respuesta definitiva: sí, siempre.

### El coste real y por qué no es prohibitivo

La objeción inmediata es el rendimiento. Si insertar en un BST no puede mutar punteros, la operación no altera el árbol existente: produce un árbol nuevo. Copiar un árbol entero en cada inserción sería O(n), lo que destruiría toda la ventaja de la estructura.

Pero no hace falta copiar todo. El árbol nuevo comparte con el original todos los nodos que no cambiaron. Solo el camino desde la raíz hasta el punto de inserción se duplica: O(log n) nodos nuevos, no O(n). Esa reutilización de estructura -compartir todo lo que no cambia- es lo que hace viable la inmutabilidad como decisión de diseño.

## ¿Qué?

La inmutabilidad es una restricción sobre el estado: una vez creado un objeto, no se modifica. Cualquier operación que aparentemente lo cambia produce una versión nueva con el cambio aplicado y el original intacto.

El cambio de modelo mental es concreto: en lugar de "modifico X", la operación es "produzco una versión de X con este cambio". El resultado es un objeto nuevo. El original sigue existiendo.

La restricción se aplica en dos dominios: los objetos individuales y las colecciones. En ambos casos el principio es el mismo: ninguna operación altera el estado existente.

## ¿Para qué?

### Razonamiento local

Con objetos inmutables, una referencia es suficiente para conocer completamente el estado de un objeto. No hace falta rastrear qué métodos lo han tocado desde su construcción, porque ninguno puede haberlo hecho. El estado de un objeto inmutable en cualquier punto del programa es exactamente el que tenía cuando se creó.

Esto simplifica radicalmente el análisis de código: basta con leer el constructor para entender qué contiene el objeto.

### Funciones sin efectos secundarios

Una función que recibe un objeto inmutable y devuelve un resultado no puede alterar el estado del llamador por sorpresa. Su comportamiento depende únicamente de sus argumentos. Esto las hace más fáciles de entender, probar y reutilizar, porque su efecto está completamente contenido en su valor de retorno.

### Historial gratuito

Si cada modificación produce una versión nueva, las versiones anteriores no desaparecen. Están en memoria mientras algo las referencie. Esto hace posible el deshacer, la comparación entre estados y la recuperación ante errores sin infraestructura adicional.

Git funciona exactamente así. Cada commit es inmutable, cada árbol de archivos es inmutable y las ramas son punteros a commits distintos que comparten la mayor parte de su historia mediante reutilización de estructura. No hay copias completas del repositorio por cada commit.

### Concurrencia sin sincronización

En sistemas con múltiples hilos de ejecución, el acceso concurrente a un objeto mutable exige sincronización: mecanismos que garanticen que dos hilos no lo modifiquen simultáneamente. La sincronización es costosa y propensa a errores.

Con objetos inmutables, la sincronización es innecesaria: dos hilos que leen el mismo objeto simultáneamente no se interfieren porque ninguno puede cambiarlo. La concurrencia segura no requiere coordinación.

### Interfaces reactivas

Los sistemas de interfaz basados en estado inmutable siguen el mismo patrón: el estado de la interfaz no se muta, se reemplaza por una versión nueva cada vez que algo cambia. El motor compara el estado anterior con el nuevo y aplica solo las diferencias. Sin inmutabilidad, esa comparación no es posible de forma fiable porque el estado anterior ya no existe.

## ¿Cómo?

La restricción se implementa de forma distinta según el dominio.

|En objetos|En colecciones|
|-|-|
Mediante diseño de clase: atributos `final` que el compilador protege de reasignación, constructor que inicializa todo el estado, y withers en lugar de setters. Un wither no modifica el objeto: devuelve una instancia nueva con el cambio aplicado y el resto igual.|Mediante operaciones que producen resultados nuevos en lugar de modificar la colección original. Las tres operaciones fundamentales son map (transformar cada elemento), filter (conservar los que cumplen una condición) y reduce (combinar todos en un valor). Ninguna toca la colección de entrada.

| | |
|-|-|
| [**Clase inmutable**](claseInmutable.md) | `final` en atributos, constructor completo, withers en lugar de setters. El contrato que permite razonar sobre el estado sin seguirlo en el tiempo. |
| [**Operaciones**](operaciones.md) | Map, filter y reduce sobre colecciones. Las mismas operaciones que aparecieron en recursividad, ahora nombradas y aplicadas sobre arrays. |

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
