# Composición: colección como objeto inmutable

## ¿Qué?

`Grupo` es una clase inmutable que envuelve un array de `Persona`. Sus métodos no modifican el array interno: cada operación produce un `Grupo` nuevo con el resultado aplicado.

Esto permite encadenar operaciones directamente sobre el objeto:

```java
Grupo resultado = grupo
    .filtrarAprobados()
    .filtrarAsistencia(80)
    .aplicarBonificacion(1);
```

## ¿Por qué funciona?

Cada método devuelve un `Grupo` nuevo, lo que hace posible llamar al siguiente método sobre ese resultado. El `grupo` original no cambia en ningún paso.

`aplicarBonificacion` usa `withNota()` de `Persona` para producir personas nuevas con la nota corregida. El array de personas del grupo original queda intacto.

## La unificación

`Grupo` aplica el mismo principio que `Persona`: atributos `final`, constructor que protege la referencia al array, operaciones que devuelven instancias nuevas. El constructor copia el array -para que nadie externo pueda alterar el contenido apuntando al mismo array- pero no copia las personas: al ser inmutables, compartir la referencia es seguro. La diferencia con `Persona` es la escala: uno opera sobre campos, el otro sobre los elementos de una colección.

Map, filter y reduce no son operaciones ajenas a la inmutabilidad: son la forma natural en que un objeto inmutable transforma su contenido.
