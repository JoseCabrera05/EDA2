<div align=right>

<sub>[**HASHING**](README.md)  
[La función hash](funcionHash.md) / [Tabla hash](tablaHash.md) / [**Integridad y huellas**](integridad.md)</sub>

</div>

# Integridad y huellas digitales

## ¿Por qué?

La tabla hash usa una función hash para acceder a datos en O(1). El mismo mecanismo puede responder a preguntas completamente distintas.

Pero hay contextos donde la pregunta relevante no es dónde está el dato sino su integridad: si ha sido modificado o quién puede haberlo producido. Son contextos donde el rendimiento es secundario y la confianza es crítica: contraseñas, documentos firmados, control de versiones.

Para esos contextos, una función hash con las propiedades habituales no es suficiente. Hace falta una familia distinta: las funciones hash criptográficas.

## ¿Qué?

Una función hash criptográfica toma una entrada de cualquier tamaño y produce una huella de tamaño fijo. Es determinista: la misma entrada produce siempre la misma huella. Hasta ahí, igual que cualquier función hash.

Lo que la distingue son tres propiedades adicionales:

<div align=center>

|Efecto avalancha|Unidireccionalidad|Resistencia a colisiones|
|-|-|-|
Un cambio mínimo en la entrada produce una huella completamente distinta, sin ninguna relación visible con la original. Una nota que pasa de 7 a 8, una letra que cambia de posición, un bit que se invierte: la huella resultante es irreconocible respecto a la anterior.|Dado el hash, es computacionalmente inviable recuperar la entrada que lo produjo. La función es una vía de sentido único: fácil de calcular en una dirección, imposible de invertir en la práctica.|Es computacionalmente inviable encontrar dos entradas distintas que produzcan la misma huella. A diferencia de la tabla hash, donde las colisiones son tolerables y gestionables, aquí una colisión fabricada deliberadamente permite suplantar un documento por otro sin que el hash lo detecte.


| Propiedad | Tabla hash | Criptográfica |
|-|:-:|:-:|
| Determinista | obligatoria | **obligatoria** |
| Distribución uniforme | crítica | **deseable** |
| Efecto avalancha | irrelevante | **crítico** |
| Unidireccional | irrelevante | **crítico** |
| Colisiones tolerables | sí | **no** |
| Velocidad de cálculo | crítica | **secundaria** |

</div>

## ¿Cómo?

### Contraseñas

Un sistema que almacena contraseñas en texto plano expone a todos sus usuarios si la base de datos es comprometida.

La alternativa es almacenar solo la huella:

```java
// Usuario.java
public class Usuario {

    private String nombre;
    private String hashContrasena;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.hashContrasena = calcularHash(contrasena);
    }

    public boolean verificarContrasena(String contrasena) {
        return hashContrasena.equals(calcularHash(contrasena));
    }

    private String calcularHash(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(texto.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException excepcion) {
            return "";
        }
    }
}
```

La contraseña nunca se almacena. En cada verificación se calcula el hash de lo que el usuario introduce y se compara con el guardado. Si la base de datos es robada, el atacante obtiene hashes, no contraseñas: la unidireccionalidad garantiza que no puede invertirlos.

### Integridad de documentos

El acta de calificaciones de `funcionHash.md` ilustra el mismo principio aplicado a un documento: calcular la huella en el momento de la firma y recalcularla en el momento de la auditoría. El efecto avalancha garantiza que cualquier modificación, por mínima que sea, produce una huella diferente y expone la manipulación.

### Control de versiones

Git identifica cada commit, cada árbol de directorios y cada archivo mediante su hash SHA-256. El identificador que aparece en `git log` no es un número de versión asignado arbitrariamente: es la huella del contenido.

Eso tiene una consecuencia directa: si el contenido de un archivo cambia, su hash cambia. Si el hash de un archivo cambia, cambia el hash del árbol que lo contiene. Si cambia el árbol, cambia el hash del commit. La historia de un repositorio es una cadena de huellas donde cada eslabón depende del anterior: modificar un commit pasado invalida todos los commits posteriores. La resistencia a colisiones hace que esa cadena no pueda ser falsificada en la práctica.

## *#2Think*

- Almacenar el hash de una contraseña protege frente al robo de la base de datos. ¿Protege también frente a un atacante que prueba contraseñas comunes y compara sus hashes con los almacenados?
- Dos archivos distintos con el mismo hash SHA-256 permitirían sustituir uno por otro sin que Git lo detecte. ¿Por qué esto no ocurre en la práctica aunque SHA-256 produzca hashes de tamaño fijo?
- El hash de un commit en Git incluye el hash de su commit padre. ¿Qué impide modificar un commit antiguo y recalcular todos los hashes siguientes para reconstruir una historia falsa coherente?

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
