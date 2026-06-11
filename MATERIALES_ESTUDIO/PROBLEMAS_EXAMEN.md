# 🧪 PROBLEMAS TIPO EXAMEN - EDA2

**Ejercicios prácticos para practicar en los últimos minutos antes del examen.**

---

## BLOQUE 1: ANÁLISIS DE COMPLEJIDAD

### Problema 1.1: Análisis de Código Iterativo
```java
public static int contar(int[] array, int objetivo) {
    int contador = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == objetivo) {
            contador++;
        }
    }
    return contador;
}
```
**Preguntas:**
- a) ¿Cuál es la complejidad? **Respuesta: O(n)**
- b) ¿Mejor, peor y caso promedio son distintos? **No, siempre recorre todo**
- c) ¿Necesita espacio auxiliar? **No, O(1)**

---

### Problema 1.2: Análisis de Bucles Anidados
```java
public static boolean tieneDuplicados(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
                return true;
            }
        }
    }
    return false;
}
```
**Preguntas:**
- a) ¿Complejidad de tiempo? **O(n²)** (bucles anidados)
- b) ¿Y si encontramos duplicado en la primera iteración? **Mejor caso O(1), peor caso O(n²)**
- c) ¿Cómo mejoraría esto? **Usar Hash Set → O(n) con O(n) espacio**

---

### Problema 1.3: Suma de Series
Analiza:
```
1 + 2 + 3 + ... + n = n(n+1)/2
```

**Si esto ocurre en un algoritmo, ¿cuál es su complejidad?**

**Respuesta: O(n²)** porque n(n+1)/2 ≈ n²/2 → O(n²)

---

### Problema 1.4: Árbol de Recursión
Dado T(n) = 2T(n/2) + O(n):

```
Nivel 0:          [n]              → n trabajo
Nivel 1:      [n/2] [n/2]         → n trabajo
Nivel 2:    [n/4]...[n/4]         → n trabajo
...
Altura: log₂(n) niveles
```

**Complejidad total = n × log(n) = O(n log n)**

Esto es exactamente **Merge Sort**.

---

## BLOQUE 2: RECURSIÓN

### Problema 2.1: Identificar Patrón Recursivo
¿Cuál es la relación recursiva para calcular la suma de los primeros n números?

| n | suma |
|---|------|
| 0 | 0 |
| 1 | 1 |
| 2 | 3 |
| 3 | 6 |

**Respuesta:** 
- Caso base: suma(0) = 0
- Paso recursivo: suma(n) = n + suma(n-1)

---

### Problema 2.2: Detectar Problema de Recursión
```java
int contar(int n) {
    return 1 + contar(n + 1);  // ❌ PROBLEMA
}
```

**¿Qué está mal?**
- n aumenta, nunca llega a caso base
- Resultado: **Infinita**, Stack Overflow

**Corrección:**
```java
int contar(int n) {
    return (n == 0) ? 0 : 1 + contar(n - 1);  // ✅
}
```

---

### Problema 2.3: Fibonacci Optimizado
¿Cuál es la complejidad de esto?

```java
int fib(int n) {
    return (n <= 1) ? n : fib(n-1) + fib(n-2);
}
```

**Respuesta: O(2ⁿ)** porque cada llamada genera 2 más.

**¿Cómo optimizar?**
```java
int fib(int n, int[] memo) {
    if (memo[n] != -1) return memo[n];
    return memo[n] = fib(n-1, memo) + fib(n-2, memo);
}
```
**Nueva complejidad: O(n)** (memoización)

---

## BLOQUE 3: BÚSQUEDA

### Problema 3.1: Elegir Búsqueda Correcta
**Escenario:** Tienes 100.000 números desordenados. Necesitas buscar uno.

**Opciones:**
a) Búsqueda lineal  
b) Búsqueda binaria después de ordenar  
c) Tabla hash  

**Respuesta: (a) Búsqueda lineal**

**Por qué:**
- (b) Ordenar cuesta O(n log n), buscar O(log n) = O(n log n + log n) = O(n log n) > O(n)
- (c) Construir hash cuesta O(n), una búsqueda O(1) = O(n) total, pero igual que lineal
- Para una sola búsqueda: lineal es más directo

---

### Problema 3.2: Búsqueda Binaria - Traza
Array: `[1, 3, 5, 7, 9, 11, 13, 15]`  
Buscar: 7

**Paso a paso:**
```
izq=0, der=7
medio = 0 + (7-0)/2 = 3
array[3] = 7 ✓ ENCONTRADO en posición 3
```

---

### Problema 3.3: Precondición Violada
¿Qué ocurre si aplicas búsqueda binaria a esto?
```
Array: [5, 2, 8, 1, 9]  // DESORDENADO
```

**Respuesta:** El algoritmo podría devolver un índice o -1, pero el resultado NO es confiable. La precondición "DEBE estar ordenado" se viola.

---

### Problema 3.4: BST Degenerado
Inserta en orden: 1, 2, 3, 4, 5

```
        1           (búsqueda: O(n))
         \
          2
           \
            3
             \
              4
               \
                5
```

**¿Complejidad de búsqueda?** O(n) (es una lista)

**¿Solución?** AVL Tree o Red-Black Tree (autobalanceo)

---

## BLOQUE 4: ORDENACIÓN

### Problema 4.1: Elegir Algoritmo
**Datos:** 50 números aleatorios

- Insertion sort: O(50²) = O(2500)
- Merge sort: O(50 × log 50) ≈ O(280)

**¿Cuál elegirías?** Insertion sort (para n pequeño es más rápido en práctica)

---

### Problema 4.2: Análisis de Insertion Sort
```java
for (int i = 1; i < 5; i++) {
    // Inserta arr[i] en posición correcta
}
```

**Mejor caso:** Array [1,2,3,4,5] → O(n) comparaciones  
**Peor caso:** Array [5,4,3,2,1] → O(n²) desplazamientos

**¿Por qué?** En mejor caso no hay desplazamientos; peor caso cada elemento va al inicio.

---

### Problema 4.3: Merge Sort - Complejidad de Espacio
Merge sort necesita dos arrays de tamaño n/2. ¿Es O(n) de espacio?

**Respuesta:** SÍ, O(n) auxiliar. La fusión necesita copias temporales.

**¿Alternativa?** Quicksort, que es in-place O(log n) en la pila, pero peor caso O(n²).

---

### Problema 4.4: Traza de Quicksort
Array: `[3, 7, 1, 4]`  
Pivote: último = 4

**Partición:**
```
[3, 7, 1] 4
i=-1, j=0: 3≤4 → i=0, swap → [3, 7, 1]
i=0, j=1: 7>4 → nada
i=0, j=2: 1≤4 → i=1, swap → [3, 1, 7]
Coloca pivote: swap(arr[2], arr[3]) → [3, 1, 4, 7]
```

Resultado: **[3, 1, 4, 7]** (pivote en posición 2)

---

### Problema 4.5: Estabilidad
¿Es estable este algoritmo?

```java
for (int i = 0; i < n; i++) {
    int minIdx = i;
    for (int j = i+1; j < n; j++) {
        if (arr[j] < arr[minIdx]) minIdx = j;
    }
    swap(arr, i, minIdx);  // intercambia
}
```

**Respuesta: NO** (es Selection Sort). Intercambia elementos iguales.

**¿Cuál es estable?** Merge Sort, Insertion Sort, Counting Sort.

---

## BLOQUE 5: HASHING

### Problema 5.1: Colisión Inevitable
Tengo tabla hash de tamaño 10 e inserto 11 elementos.

**¿Colisiones garantizadas?** SÍ (principio del palomar)

**¿Cómo se resuelve?** Encadenamiento: lista en cada celda

---

### Problema 5.2: Factor de Carga
Tabla hash: 1000 elementos, 1024 posiciones

$$\text{Factor} = \frac{1000}{1024} \approx 0.977$$

**¿Es bueno?** SÍ, factor < 1 significa O(1) promedio

**¿Cuándo redimensiona Java?** Cuando factor > 0.75 (umbral)

---

### Problema 5.3: Función Hash Mala
```java
int hash(String s) {
    return s.length() % 10;  // ¿Buena?
}
```

**Problemas:**
- Distribuciópobre (solo 10 valores posibles)
- "hola" y "mundo" tienen hash similar si longitud similar
- No cumple "distribución uniforme"

**Mejor:** Usar `s.hashCode()` de Java

---

### Problema 5.4: SHA-256 vs Función Hash
¿Por qué NO usarías SHA-256 como función hash para tabla?

**Respuesta:**
- SHA-256 es lenta (computacionalmente cara)
- Tabla necesita función rápida (crítica)
- SHA-256 es para criptografía (overkill)
- Función simple suficiente para tabla

---

### Problema 5.5: Detección de Cambios
Un acta tiene datos + hash SHA-256. ¿Qué detecta?

```
Datos: nombre, apellido, calificación
Hash: SHA-256(nombre + apellido + calificación)
```

Si cambio calificación 92 → 95:
- Hash antiguo: xabc123...
- Hash nuevo: zyxw456...
- Totalmente distinto (efecto avalancha)

**Conclusion:** Cambio detectado

---

## BLOQUE 6: INMUTABILIDAD

### Problema 6.1: Clase Inmutable
¿Es esta clase inmutable?

```java
public class Punto {
    private final int x;
    private final int y;
    
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

**Respuesta:** SÍ (atributos final, sin setters)

---

### Problema 6.2: Wither vs Setter
**Setter:**
```java
punto.setX(10);  // punto cambia
```

**Wither:**
```java
Punto nuevoPunto = punto.withX(10);  // original no cambia
```

**Diferencia:** Setter muta, wither crea nuevo objeto

---

### Problema 6.3: Trampa de Mutables
¿Es esto inmutable?

```java
public class Equipo {
    private final List<String> miembros;
    
    public Equipo(List<String> miembros) {
        this.miembros = miembros;  // ❌ PROBLEMA
    }
}
```

**Problema:** 
```java
List<String> lista = new ArrayList<>();
lista.add("Ana");
Equipo eq = new Equipo(lista);
lista.add("Bob");  // ¡eq.miembros cambió!
```

**Corrección:**
```java
this.miembros = new ArrayList<>(miembros);  // copia
```

---

### Problema 6.4: Map, Filter, Reduce
Dado: `[1, 2, 3, 4, 5]`

**Map:** Duplica cada → `[2, 4, 6, 8, 10]`  
**Filter:** Conserva pares → `[2, 4]`  
**Reduce:** Suma todos → `15`

**¿Original cambia?** NO (inmutabilidad)

---

### Problema 6.5: Ventaja de Inmutabilidad en Concurrencia
Dos hilos acceden al mismo objeto inmutable simultáneamente.

**¿Necesita sincronización?** NO

**¿Por qué?** Ambos hilos leen lo mismo y ninguno lo modifica. No hay carrera de datos.

---

## PROBLEMAS INTEGRADOS (Combinan varios temas)

### Problema 7.1: Decisión de Estructura
**Requisitos:**
- Insertar 1.000.000 de números
- Buscar frecuentemente
- Números en rango [1, 100]

**¿Qué estructura?**

**Respuesta: Counting sort + array**
- Ordenación: O(1.000.000 + 100) = O(1.000.100)
- Búsqueda binaria: O(log 1.000.000) ≈ 20 comparaciones
- Total: excelente

---

### Problema 7.2: Recursión vs Iteración
Fibonacci:

**Recursiva (sin memoización):**
```java
int fib(int n) {
    return (n <= 1) ? n : fib(n-1) + fib(n-2);  // O(2ⁿ)
}
```

**Iterativa:**
```java
int fib(int n) {
    int a = 0, b = 1;
    for (int i = 0; i < n; i++) {
        int c = a + b;
        a = b;
        b = c;
    }
    return a;  // O(n)
}
```

**¿Cuál en examen?** Iterativa (O(n), no O(2ⁿ))

---

### Problema 7.3: Análisis Comparativo
Ordena 10.000 números:

| Algoritmo | Complejidad | Tiempo aproximado |
|-----------|------------|------------------|
| Insertion | O(10000²) | ~100.000.000 ops |
| Merge | O(10000 log 10000) | ~130.000 ops |
| Quick | O(10000 log 10000) prom | ~130.000 ops |

**¿Ganador?** Merge o Quick (100x más rápido)

---

### Problema 7.4: Amortización
HashMap con tabla de 16 posiciones.

**Inserciones:** 1, 2, 4, 8, 9, ..., 16, 17

En inserción 17: redimensiona a 32. Coste: O(16)

**¿Coste amortizado por inserción?** O(16) / 16 inserciones = O(1)

---

### Problema 7.5: Inmutabilidad y Rendimiento
BST inmutable:

```
Original:
    50
   /  \
  30   70

Insertar 60 (crea nuevo árbol):
    50
   /  \
  30   70'  ← nuevo nodo
       /
      60
```

**¿Cuántos nodos nuevos?** Solo los en el camino (3: 50→70→60), no todo el árbol.

**Complejidad:** O(log n) nuevos nodos, O(log n) copias

---

## 🎯 RESPUESTAS RÁPIDAS (Memoriza)

| Pregunta | Respuesta |
|----------|-----------|
| ¿Merge sort es O(n log n)? | SÍ, GARANTIZADO |
| ¿Quicksort es O(n²)? | SÍ, en peor caso |
| ¿Búsqueda binaria sin orden? | INCORRECTO, necesita orden |
| ¿Tabla hash O(1)? | SÍ, amortizado |
| ¿Recursión sin caso base? | Infinita |
| ¿Estable = Merge sort? | SÍ |
| ¿In-place = Quicksort? | SÍ, O(log n) pila |
| ¿O(n²) para 1M elementos? | Demasiado lento |
| ¿O(n log n) para 1M? | ~20M ops, rápido |
| ¿Inmutable = sin cambios? | SÍ, crea objeto nuevo |

---

**Cronómetro:** 🕐 Dedica 15-20 minutos a estos problemas.

Enfócate en entender la LÓGICA, no en memorizar respuestas.

