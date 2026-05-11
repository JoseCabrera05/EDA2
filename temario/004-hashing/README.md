<div align=right>

<sub>[**HASHING**](README.md)  
[La función hash](funcionHash.md) / [Tabla hash](tablaHash.md) / [Integridad y huellas](integridad.md)</sub>

</div>

# Hashing

## ¿Por qué?

El módulo anterior cerró con una promesa: cuando solo se necesita acceso por clave exacta y se puede prescindir del orden, existe una estrategia que entrega O(1). Esa estrategia exige algo que ninguna estructura vista hasta ahora utilizó: **transformar la clave en una posición de acceso directo**.

Esa transformación -una función que proyecta un dominio grande a un rango pequeño y manejable- se llama función hash. Estudiada con cuidado, revela que el mismo mecanismo resuelve un segundo problema completamente distinto:

*Un sistema almacena actas de calificaciones. Alguien modifica una nota. La modificación no deja rastro visible. Si antes de guardar el acta se calculara un resumen compacto de su contenido y ese resumen se volviera a calcular después, cualquier cambio quedaría expuesto: el mismo dato siempre produce el mismo resumen; un cambio mínimo en el dato produce un resumen completamente diferente.*

Ese resumen también se calcula con una función hash. Pero las propiedades que lo hacen útil para detectar modificaciones son distintas de las que hacen útil una tabla de acceso directo.

El presente módulo parte del núcleo común y desarrolla los dos usos.

## ¿Qué?

Una función hash toma una entrada de tamaño arbitrario y produce una salida de tamaño fijo. Es determinista: la misma entrada produce siempre la misma salida. Lo que varía entre aplicaciones son las propiedades adicionales que se exigen:

<div align=center>

|Propiedad|Descripción | En una tabla hash | En su uso para garantizar integridad |
|-|-|:-:|:-:|
|Determinista|<sub>La misma entrada produce siempre la misma salida. Sin aleatoriedad, sin estado interno. Condición mínima de cualquier función hash.</sub>| obligatoria | obligatoria |
|Distribución uniforme|<sub>Las claves se reparten de forma homogénea sobre el rango disponible. Minimiza colisiones; si el hash agrupa claves en pocas posiciones, la tabla pierde su ventaja de O(1).</sub>| crítica | deseable |
|Efecto avalancha|<sub>Un cambio mínimo en la entrada (un solo bit o carácter) produce una salida completamente distinta. Hace imposible deducir la relación entre dos entradas a partir de sus hashes.</sub>| irrelevante | crítico |
|Unidireccional|<sub>Dado el hash, no hay camino computacionalmente viable de vuelta a la entrada original. Garantiza que el resumen no revela el dato.</sub>| irrelevante | crítico |
|Colisiones tolerables|<sub>Indica si el sistema puede seguir funcionando cuando dos entradas distintas producen el mismo valor. En una tabla hash se gestiona con desbordamiento; en criptografía es una vulnerabilidad.</sub>| sí | no |
|Velocidad de cálculo|<sub>Coste de ejecutar la función. En tablas hash se invoca en cada acceso; si la función es lenta, destruye la ventaja de O(1). En criptografía, cierta lentitud es a veces deseable (dificulta ataques por fuerza bruta).</sub>| crítica | secundaria |

</div>

Dos familias con propiedades distintas. Un mecanismo en común.

## ¿Para qué?

Las **tablas hash** implementan diccionarios, cachés, conjuntos e índices. Son la estructura interna de `HashMap` en Java, `dict` en Python y los objetos en JavaScript. La búsqueda, inserción y eliminación son O(1) amortizado.

Las **funciones hash criptográficas** sustentan el almacenamiento seguro de contraseñas, la detección de manipulación de datos y los sistemas de control de versiones. Git identifica cada commit, árbol y blob mediante su hash SHA-256: la historia del repositorio es una cadena de huellas digitales que garantiza su integridad.

## ¿Cómo?

| | |
|-|-|
| [**La función hash**](funcionHash.md) | El concepto compartido. Qué hace una función hash, qué propiedades puede o no puede tener y por qué las dos familias las exigen en distinta medida. |
| [**Tabla hash**](tablaHash.md) | La estructura de datos. Función de dispersión, colisiones y sus estrategias de resolución, factor de carga. Coste real frente a coste amortizado. |
| [**Integridad y huellas digitales**](integridad.md) | La función hash criptográfica. Efecto avalancha, unidireccionalidad, resistencia a colisiones. Aplicaciones: contraseñas, actas, control de versiones. |

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
