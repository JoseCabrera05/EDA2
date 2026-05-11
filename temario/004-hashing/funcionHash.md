<div align=right>

<sub>[**HASHING**](README.md)  
[**La función hash**](funcionHash.md) / [Tabla hash](tablaHash.md) / [Integridad y huellas](integridad.md)</sub>

</div>

# La función hash

## ¿Por qué?

El índice externo mostró que separar la clave del registro y mantenerla ordenada permite búsqueda binaria: O(log n). Pero O(log n) sigue siendo búsqueda: recorrer el índice comparando claves hasta encontrar la correcta.

Para bajar de O(log n) hay que eliminar la búsqueda, no reducirla. Si en lugar de buscar la clave dentro del índice se pudiera ir directamente a su posición, el coste sería O(1) con independencia del tamaño de la colección.

Eso exige una función que transforme la clave en una posición. Esto es, dado un identificador obtener directamente el número de celda donde está el registro, sin buscar. La misma clave produce siempre la misma posición.

## ¿Qué?

Una función hash toma una entrada de tamaño arbitrario (una cadena, un número, un objeto completo) y produce un número de tamaño fijo. Es determinista: la misma entrada produce siempre la misma salida.

El problema es matemático. El conjunto de claves posibles es enorme: hay millones de cadenas posibles, millones de identificadores posibles. El conjunto de posiciones válidas en la tabla es pequeño y acotado. Una función que proyecta un conjunto grande en uno pequeño tiene, por el **principio del palomar**, que asignar la misma posición a claves distintas en algún momento.

Eso se llama **colisión**. La colisión no es un fallo de implementación sino consecuencia matemática inevitable del mecanismo: cualquier función que proyecte un dominio grande en un rango pequeño inevitablemente tendrá colisiones.

Por tanto, la pregunta que divide todo lo que sigue es: **¿qué se hace con las colisiones?**

## ¿Para qué?

|||
|-|-|
Si las colisiones son **tolerables** (si el sistema puede gestionar que dos claves apunten al mismo sitio y recuperarse sin error), se diseña una estructura que las acepta como excepciones manejables. El coste promedio sigue siendo O(1).|Si las colisiones son **inaceptables** (si alguien podría fabricar deliberadamente dos entradas con el mismo hash para engañar al sistema), la función necesita propiedades adicionales que hagan esa fabricación computacionalmente imposible.
Esa estructura es la **tabla hash**.|Esas son las **funciones hash criptográficas**.

Las propiedades que cada familia exige no solo son distintas: en algunos casos son opuestas.

<div align=center>

| Propiedad | Tabla hash | Criptográfica |
|-|:-:|:-:|
| Determinista | obligatoria | obligatoria |
| Distribución uniforme | crítica | deseable |
| Efecto avalancha | irrelevante | crítico |
| Unidireccional | irrelevante | crítico |
| Colisiones tolerables | sí | no |
| Velocidad de cálculo | crítica | secundaria |

</div>

Un mismo mecanismo (transformar una entrada en un número de tamaño fijo) sirve a propósitos radicalmente distintos según las propiedades que se le exigen.

## ¿Cómo?

Un acta de calificaciones ilustra las dos familias desde el mismo escenario.

**Acceso por clave.** El acta almacena registros indexados por identificador de estudiante. Con cientos de registros, buscar por identificador debe ser O(1). La solución es una tabla donde el identificador se transforma en posición mediante una función hash. Ese mecanismo se desarrolla en el documento [tabla Hash](tablaHash.md).

**Integridad.** El acta también tiene que detectar si alguna nota fue alterada tras su firma. Al guardar cada registro se calcula un resumen compacto de su contenido. Para auditar, se recalcula el resumen y se compara con el guardado:

```java
public void agregarPersona(Persona persona) {
    personas.add(persona);
    hashes.add(persona.getHash());
}

public boolean verificarIntegridad() {
    for (int i = 0; i < personas.size(); i++) {
        String hashActual = personas.get(i).getHash();
        if (!hashActual.equals(hashes.get(i))) {
            return false;
        }
    }
    return true;
}
```

El hash de cada persona concatena nombre, apellido y calificación y los pasa por SHA-256:

```java
public String getHash() {
    try {
        String datos = nombre + apellido + calificacion;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(datos.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException excepcion) {
        return "";
    }
}
```

El `try-catch` dentro de `getHash()` es obligatorio: `MessageDigest.getInstance()` lanza una checked exception que el compilador de Java exige tratar, aunque SHA-256 esté garantizado en cualquier JVM y el `catch` nunca se ejecute en la práctica.

Si alguien modifica una calificación, `getHash()` produce un resultado diferente al guardado y la verificación falla:

```java
Persona maria = new Persona("María", "González", 92);
acta.agregarPersona(maria);
System.out.println(acta.verificarIntegridad()); // true

maria.setCalificacion(95);
System.out.println(acta.verificarIntegridad()); // false: manipulación detectada
```

Esta función no puede ser la misma que se usa para la tabla. Una función de dispersión simple como `identificador % tamaño` es rápida y suficientemente uniforme, pero completamente reversible: dado el índice, puede deducirse el identificador original. Para integridad eso es inaceptable.

SHA-256 garantiza **efecto avalancha**: una calificación que pasa de 92 a 95 produce un hash completamente distinto, sin ninguna relación visible con el original. Y es **unidireccional**: dado el hash, es computacionalmente inviable recuperar los datos que lo produjeron.

El documento [Integridad y huellas digitales](integridad.md) desarrolla estas propiedades y sus aplicaciones: almacenamiento de contraseñas, firmas digitales, control de versiones con Git.

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
