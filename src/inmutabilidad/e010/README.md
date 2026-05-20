# Map

## ¿Qué?

Map toma un array y produce un array nuevo del mismo tamaño donde cada elemento es el resultado de aplicar una transformación al elemento correspondiente del original. El array de entrada no se modifica.

## ¿Cómo?

El ejemplo muestra dos aplicaciones del patrón.

### Transformación numérica

```java
int[] numeros = {1, 2, 3, 4, 5};
int[] cuadrados = cuadrado(numeros);
```

`cuadrado` recorre `numeros` y escribe cada resultado en un array nuevo:

```java
private static int[] cuadrado(int[] origen) {
    int[] resultado = new int[origen.length];
    for (int i = 0; i < origen.length; i++) {
        resultado[i] = origen[i] * origen[i];
    }
    return resultado;
}
```

### Transformación de objetos

```java
Person[] personas = { ... };
PersonDto[] dtos = resumir(personas);
```

`resumir` transforma cada `Person` en un `PersonDto` nuevo:

```java
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
```

En ambos casos `origen` permanece intacto. El resultado vive en un array nuevo.

> [2Think](2Think.md)
