# 📚 GUÍA DE ESTUDIO EDA2 - EXAMEN (En 2 horas)

**Estructuras de Datos y Algoritmos II**  
*Construir → Organizar → Optimizar*

---

## 🎯 RESUMEN EJECUTIVO

EDA2 estudia **cómo operar eficientemente sobre datos organizados**. El curso se divide en 6 módulos organizados en 3 bloques:

| Bloque | Módulos | Objetivo |
|--------|---------|----------|
| **Instrumental** | 1. Análisis de Algoritmos<br>2. Recursividad | Medir y conceptualizar |
| **Acceso Eficiente** | 3. Orden y Búsqueda<br>4. Hashing | Encontrar datos rápido |
| **Avanzado** | 5. Estructuras de Datos Avanzadas<br>6. Inmutabilidad | Paradigmas complementarios |

**Ecuación fundamental del curso:**  
$$\text{Estructura correcta} + \text{Algoritmo correcto} = \text{Eficiencia garantizada}$$

---

## 1️⃣ ANÁLISIS DE ALGORITMOS

### 🔍 Concepto Central
Medir el rendimiento de algoritmos **independientemente del hardware** mediante **análisis asintótico**.

### 📊 Notación Asintótica (Big O)

| Notación | Nombre | Comportamiento | Ejemplo |
|----------|--------|-----------------|---------|
| **O(1)** | Constante | No depende de n | Acceso a array[i] |
| **O(log n)** | Logarítmica | Divide por 2 cada vez | Búsqueda binaria |
| **O(n)** | Lineal | Proporcional a n | Búsqueda lineal |
| **O(n log n)** | Lineal-logarítmica | Divide y ordena | Merge sort |
| **O(n²)** | Cuadrática | Bucles anidados | Insertion sort, Bubble sort |
| **O(2ⁿ)** | Exponencial | Explota combinatoriamente | Recursión sin optimizar |
| **O(n!)** | Factorial | Peor que exponencial | Permutaciones brutas |

### 📈 Ranking de Eficiencia
$$O(1) < O(\log n) < O(n) < O(n \log n) < O(n^2) < O(2^n) < O(n!)$$

### ⚠️ Tres Perspectivas de Análisis

| Perspectiva | Definición | Uso |
|-------------|-----------|-----|
| **Mejor caso** | Datos ideales | Poco práctico |
| **Caso promedio** | Datos típicos | Descriptivo |
| **Peor caso** | Datos adversos | **Garantía de rendimiento** |

**En ingeniería: usamos PEOR CASO porque necesitamos garantías.**

### 🧮 Análisis de Algoritmos Iterativos

**Regla 1: Secuencias se suman**
```
O(n) + O(log n) = O(n + log n) = O(n)
```

**Regla 2: Bucles se multiplican**
```
for i in 0..n:
    for j in 0..n:      → O(n²)
```

**Regla 3: Bucles dependientes generan series**
```
for i in 0..n:
    for j in 0..i:      → 0+1+2+...+n = n(n+1)/2 → O(n²)
```

### 🎯 Análisis de Algoritmos Recursivos

Se visualiza el **árbol de llamadas**:
- Cada nodo = una llamada
- Profundidad = altura del árbol
- Total = suma de nodos

**Ejemplo: T(n) = 2T(n/2) + O(n)** (como Merge Sort)
- Altura: log n
- Nodos por nivel: n
- Total: O(n log n)

### 💡 Complejidad Espacial

| Tipo | Definición | Ejemplo |
|------|-----------|---------|
| **In-place** | O(1) auxiliar | Quicksort |
| **Linear** | O(n) auxiliar | Merge sort |
| **Stack overflow** | Recursión profunda | Fib sin memoización |

### ⚡ Compromiso Tiempo-Espacio
- **Hashing**: más espacio → acceso O(1)
- **Compresión**: menos espacio → acceso lento
- **Memoización**: más espacio → menos cálculos

---

## 2️⃣ RECURSIVIDAD

### 🔄 Definición Correcta
**NO es "una función que se llama a sí misma"**. Es un método para **resolver un problema definiéndolo en términos de versiones más pequeñas del mismo problema**.

### 🏗️ Estructura Fundamental

```
RECURSIÓN = CASO BASE + PASO RECURSIVO
```

#### Caso Base
- Problema tan pequeño que se resuelve directamente
- Sin más recursión
- **Ejemplo**: factorial(0) = 1

#### Paso Recursivo
- Reduce el problema a uno más pequeño
- Se resuelve el pequeño, se combina resultado
- **Ejemplo**: factorial(n) = n × factorial(n-1)

### 📋 Esquema Tabular (Método de Estructuración)

| Entrada | Salida |
|---------|--------|
| **CB: 0** | **1** |
| CR: 4 | 24 |
| CR: 5 | 120 |

**Buscar relación en aspa:**
- 5 → 120
- 4 → 24
- Relación: 5 × 24 = 120
- **Fórmula: f(n) = n × f(n-1)**

### 🎯 Patrones de Recursión

| Patrón | Estructura | Ejemplo |
|--------|-----------|---------|
| **Cola** | f(n) = ... f(n-1) | Factorial |
| **Bifurcada** | f(n) = f(n-1) + f(n-2) | Fibonacci |
| **Múltiple** | f(n) = 2×f(n/2) + ... | Merge sort |
| **Árbol/Grafo** | Visita cada rama | DFS |

### ⚠️ Problemas Comunes

**Problema: Infinita**
```java
// ❌ MAL: nunca llega al caso base
int contar(int n) {
    return 1 + contar(n + 1);  // n aumenta, nunca llega a 0
}

// ✓ BIEN: acerca a caso base
int contar(int n) {
    return (n == 0) ? 0 : 1 + contar(n - 1);
}
```

**Problema: Stack Overflow**
- Recursión muy profunda → pila de llamadas muy grande
- Para n = 100.000, recursión lineal es peligrosa
- **Solución**: iteración o compilador que optimiza tail recursion

**Problema: Exponencial Innecesaria**
```java
// ❌ MAL: O(2ⁿ)
int fib(int n) {
    return (n <= 1) ? n : fib(n-1) + fib(n-2);
}

// ✓ BIEN: O(n) con memoización
int fib(int n, int[] memo) {
    if (memo[n] != -1) return memo[n];
    return memo[n] = fib(n-1, memo) + fib(n-2, memo);
}
```

### 🔗 Técnicas

| Técnica | Qué hace | Uso |
|---------|----------|-----|
| **Memoización** | Cachea resultados | Evita recálculos |
| **Backtracking** | Explora caminos, deshace | N-reinas, laberintos |
| **Divide y Vencerás** | Divide, resuelve, combina | Merge sort, búsqueda binaria |

---

## 3️⃣ ORDEN Y BÚSQUEDA

### 🎯 Pregunta Central
**¿Dónde está el elemento que busco?**

El **orden es la precondición** para acceso eficiente.

### 🔎 Búsqueda Lineal

```java
// Precondición: ninguna
// Complejidad: O(n)
// Uso: datos pequeños, sin orden, una búsqueda

public static int buscar(int[] array, int objetivo) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == objetivo) return i;
    }
    return -1;
}
```

**Cuándo usarla:**
- Colección pequeña
- Datos desordenados
- Una sola búsqueda
- Acceso secuencial (listas enlazadas)

### 🔍 Búsqueda Binaria

```java
// Precondición: ARRAY ORDENADO, acceso aleatorio
// Complejidad: O(log n)
// Uso: múltiples búsquedas, datos grandes

public static int buscar(int[] array, int objetivo) {
    int izq = 0, der = array.length - 1;
    while (izq <= der) {
        int medio = izq + (der - izq) / 2;
        if (array[medio] == objetivo) return medio;
        if (array[medio] < objetivo) izq = medio + 1;
        else der = medio - 1;
    }
    return -1;
}
```

**Precondiciones NO negociables:**
1. Array **DEBE estar ordenado**
2. Acceso aleatorio O(1)
3. Comparación funciona

**Cálculo del punto medio:**
```
❌ (izq + der) / 2      // Desbordamiento
✓ izq + (der - izq) / 2 // Seguro
```

### 📊 Comparativa de Búsquedas

| Estructura | Inserción | Búsqueda | Nota |
|-----------|-----------|----------|------|
| Array sin orden | O(1) | O(n) | Flexible pero lento |
| Array ordenado | O(n) | O(log n) | Desplazamientos costosos |
| Lista enlazada sin orden | O(1) | O(n) | No hay acceso aleatorio |
| Lista ordenada | O(n) | O(n) | ¡Orden no ayuda en lista! |
| **BST** | **O(log n)** | **O(log n)** | Mejor de ambos mundos |

### 🌳 Búsqueda en BST (Binary Search Tree)

```
Invariante: izquierda < raíz < derecha

    50
   /  \
  30   70
 / \   / \
20 40 60 80
```

- **Inserción**: O(log n) si balanceado, O(n) si degenerado
- **Búsqueda**: O(log n) si balanceado, O(n) si degenerado
- **Eliminación**: O(log n) si balanceado

### ⚠️ Trampa: BST No Balanceado

```
Insertar 1,2,3,4,5 en orden:
    1       → O(n) en búsqueda (es una lista!)
     \
      2
       \
        3
```

**Solución**: AVL trees o Red-Black trees (balanceo automático).

---

## 4️⃣ ORDENACIÓN

### 🎯 La Pregunta
**¿Cómo reorganizo estos datos para acceso eficiente?**

### 📊 Tipos de Ordenación

#### A. POR COMPARACIÓN

##### 1️⃣ Insertion Sort
```
Complejidad: O(n²) en general
Mejor caso: O(n) si ya está ordenado
Estable: SÍ
Espacio: O(1) in-place

Estrategia: Prefijo ordenado crece de izquierda a derecha
```

```java
for (int i = 1; i < arr.length; i++) {
    int actual = arr[i];
    int j = i - 1;
    while (j >= 0 && arr[j] > actual) {
        arr[j + 1] = arr[j];  // desplaza
        j--;
    }
    arr[j + 1] = actual;  // inserta
}
```

**Cuándo usarla:**
- Datos casi ordenados
- Colecciones pequeñas (n < 50)
- Necesita ser estable

##### 2️⃣ Merge Sort
```
Complejidad: O(n log n) GARANTIZADO
Mejor/Peor/Promedio: todas O(n log n)
Estable: SÍ
Espacio: O(n) auxiliar

Estrategia: Divide, ordena, fusiona
```

```java
void ordenar(int[] arr, int izq, int der) {
    if (izq >= der) return;
    int medio = izq + (der - izq) / 2;
    ordenar(arr, izq, medio);      // ordena izquierda
    ordenar(arr, medio + 1, der);  // ordena derecha
    fusionar(arr, izq, medio, der);// fusiona
}

void fusionar(int[] arr, int izq, int medio, int der) {
    // recorre ambas mitades en paralelo, toma el menor
}
```

**Cuándo usarla:**
- Necesitas garantía de O(n log n)
- Datos externos (discos)
- Necesita ser estable

**Desventaja**: O(n) de espacio extra

##### 3️⃣ Quicksort
```
Complejidad: O(n log n) PROMEDIO, O(n²) peor caso
Mejor/Promedio: O(n log n)
Peor caso: O(n²) si pivote siempre en extremo
Estable: NO
Espacio: O(log n) en pila de recursión

Estrategia: Particiona + Recursión (in-place)
```

```java
void ordenar(int[] arr, int izq, int der) {
    if (izq >= der) return;
    int pivote = particionar(arr, izq, der);
    ordenar(arr, izq, pivote - 1);
    ordenar(arr, pivote + 1, der);
}

int particionar(int[] arr, int izq, int der) {
    int piv = arr[der];
    int i = izq - 1;
    for (int j = izq; j < der; j++) {
        if (arr[j] <= piv) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, der);
    return i + 1;
}
```

**Cuándo usarla:**
- Mejor rendimiento en práctica (caché)
- Espacio limitado
- Datos aleatorios

**Mejoras:**
- Pivote aleatorio → evita O(n²) con datos ordenados
- Mediana de 3 → mejor partición

#### B. SIN COMPARACIÓN (Explotan propiedades de valores)

##### 4️⃣ Counting Sort
```
Complejidad: O(n + k) donde k = rango de valores
Estable: SÍ
Espacio: O(n + k)

Precondición: valores en rango [0, k)
Uso: dígitos, calificaciones, bytes

Estrategia: Cuenta ocurrencias, deduce posiciones
```

```java
void ordenar(int[] arr, int maxVal) {
    int[] conteo = new int[maxVal + 1];
    // Fase 1: contar
    for (int x : arr) conteo[x]++;
    
    // Fase 2: acumular (convertir conteos en posiciones)
    for (int i = 1; i <= maxVal; i++)
        conteo[i] += conteo[i-1];
    
    // Fase 3: colocar (de derecha a izquierda para estabilidad)
    int[] resultado = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
        resultado[conteo[arr[i]] - 1] = arr[i];
        conteo[arr[i]]--;
    }
}
```

**Cuándo usarla:**
- k pequeño (k ≤ 1000)
- Valores discretos
- Datos ya en memoria

##### 5️⃣ Radix Sort
```
Complejidad: O(d × (n + k)) donde d = dígitos, k = base
Usa Counting Sort internamente para cada dígito
Estable: SÍ (usa counting sort estable)
Espacio: O(n + k)

Estrategia: Ordena por dígitos (unidades, decenas, centenas...)
```

**Idea**: Ordena primero por unidades (conteo), luego decenas (conteo), etc.
- Requiere que cada "dígito" sea un valor pequeño

### 📈 Tabla Comparativa de Ordenación

| Algoritmo | Promedio | Peor Caso | Espacio | Estable | Cuándo |
|-----------|----------|-----------|---------|---------|--------|
| Insertion | O(n²) | O(n²) | O(1) | SÍ | Pequeño/casi ordenado |
| Merge | O(n log n) | O(n log n) | O(n) | SÍ | **Garantía necesaria** |
| Quick | O(n log n) | O(n²) | O(log n) | NO | Mejor práctica |
| Counting | O(n+k) | O(n+k) | O(n+k) | SÍ | Rango pequeño |
| Radix | O(d(n+k)) | O(d(n+k)) | O(n+k) | SÍ | Grandes enteros |

### ⚡ Regla de Oro
- **n < 50**: Insertion sort
- **n < 1.000.000 sin orden**: Quicksort (o Merge sort si necesitas estabilidad)
- **n = 1.000.000+ necesitas O(n log n)**: Merge sort
- **Valores en rango acotado pequeño**: Counting sort

---

## 5️⃣ HASHING

### 🎯 Problema Central
**¿Cómo transformo una clave en una posición de acceso directo?**

### 🔑 Función Hash

```
hash(entrada) → número fijo
```

**Propiedades según uso:**

| Propiedad | Tabla Hash | Criptográfica |
|-----------|-----------|---------------|
| Determinista | ✅ | ✅ |
| Distribución uniforme | ✅ CRÍTICA | ✓ deseable |
| Efecto avalancha | ❌ irrelevante | ✅ CRÍTICA |
| Unidireccional | ❌ irrelevante | ✅ CRÍTICA |
| Colisiones tolerables | ✅ SÍ | ❌ NO |
| Rápida | ✅ CRÍTICA | ❌ secundaria |

### 📊 Tabla Hash

```
Estructura: Array de listas enlazadas (encadenamiento)
```

```java
[0] → Lista vacía
[1] → 15 → 22 → NULL
[2] → 8 → NULL
[3] → NULL
...
```

**Operaciones:**
```
insertar(clave, valor):
    pos = hash(clave) % tamaño
    tabla[pos] = Nodo(clave, valor, tabla[pos])  // O(1)

buscar(clave):
    pos = hash(clave) % tamaño
    recorre lista en tabla[pos]  // O(1) promedio, O(n) peor
```

### ⚖️ Factor de Carga

$$\text{Factor} = \frac{\text{elementos}}{\text{posiciones}}$$

- Factor 0.5 → medio elemento por posición → O(1)
- Factor 1.0 → un elemento por posición → O(1)
- Factor 2.0 → dos elementos por posición → más colisiones

**Solución**: Redimensionar cuando factor > umbral (ej: 0.75)

**Coste redimensionamiento**: O(n), pero amortizado es O(1) por inserción.

### 🔐 Hash Criptográfico

```
SHA-256: entrada arbitraria → 256 bits
```

**Propiedades:**
1. **Determinista**: mismo input → mismo output
2. **Avalancha**: 1 bit diferente → totalmente distinto
3. **Unidireccional**: hash → original es imposible
4. **Resistencia de colisiones**: imposible fabricar dos inputs iguales

**Usos:**
- Contraseñas (SHA-256)
- Integridad de datos (Git usa SHA-1 para commits)
- Firmas digitales

---

## 6️⃣ INMUTABILIDAD

### 🎯 Principio
**¿Y si no fuera posible modificar nada?**

### 📋 Clase Inmutable en Java

```java
public class Persona {
    private final String nombre;      // final = no reasignable
    private final String apellido;
    private final int id;

    public Persona(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    // Getters (sin setters)
    public String getNombre() { return nombre; }

    // Withers: devuelven objeto NUEVO
    public Persona withNombre(String nombre) {
        return new Persona(nombre, this.apellido, this.id);
    }
}
```

**Uso:**
```java
Persona ana = new Persona("Ana", "López", 1001);
Persona ana2 = ana.withApellido("Martínez");

// ana → "Ana López"
// ana2 → "Ana Martínez"
// DOS objetos distintos, original NO cambia
```

### ✅ Ventajas

| Ventaja | Beneficio |
|---------|-----------|
| Razonamiento local | No seguir modificaciones en el tiempo |
| Funciones puras | Sin efectos secundarios ocultos |
| Historial gratuito | Versiones anteriores siguen existiendo |
| Concurrencia segura | Sin sincronización (dos hilos no colisionan) |
| Interfaces reactivas | Comparar antes/después es trivial |

### ⚠️ Trampa: Atributos Mutables

```java
// ❌ MAL
public class Equipo {
    private final int[] miembros;  // final, pero mutable
    public int[] getMiembros() {
        return miembros;  // ¡expone referencia!
    }
}

// ✓ BIEN
public class Equipo {
    private final int[] miembros;
    public int[] getMiembros() {
        return Arrays.copyOf(miembros, miembros.length);
    }
}
```

**Regla**: Si atributo es mutable, **copiar al entrar y al salir**.

### 🔄 Operaciones sobre Colecciones

Tres operaciones fundamentales para transformar sin mutación:

#### 1. MAP (Transformar cada elemento)
```java
int[] original = {1, 2, 3};
int[] dobles = new int[original.length];
for (int i = 0; i < original.length; i++) {
    dobles[i] = original[i] * 2;
}
// original sigue siendo {1, 2, 3}
// dobles es {2, 4, 6}
```

#### 2. FILTER (Conservar elementos que cumplen condición)
```java
int[] original = {1, 2, 3, 4, 5, 6};
// Contar pares
int cuenta = 0;
for (int x : original) if (x % 2 == 0) cuenta++;
// Construir resultado
int[] pares = new int[cuenta];
int pos = 0;
for (int x : original) {
    if (x % 2 == 0) pares[pos++] = x;
}
// pares es {2, 4, 6}
```

#### 3. REDUCE (Combinar en un valor)
```java
int[] valores = {1, 2, 3, 4, 5};
int suma = 0;
for (int x : valores) suma += x;
// suma = 15, original no cambia
```

---

## 📋 RESUMEN DE COMPLEJIDADES

### Acceso a Estructuras

| Estructura | Búsqueda | Inserción | Eliminación |
|-----------|----------|-----------|------------|
| Array | O(n) | O(n) | O(n) |
| Array ordenado | O(log n) | O(n) | O(n) |
| Lista enlazada | O(n) | O(1) | O(1) |
| BST | O(log n) | O(log n) | O(log n) |
| BST degenerado | O(n) | O(n) | O(n) |
| Tabla hash | O(1) | O(1) | O(1) |
| Heap | O(n) | O(log n) | O(log n) |

### Ordenación

| Algoritmo | Promedio | Peor | Espacio | Estable |
|-----------|----------|------|---------|---------|
| Bubble | O(n²) | O(n²) | O(1) | SÍ |
| Insertion | O(n²) | O(n²) | O(1) | SÍ |
| Selection | O(n²) | O(n²) | O(1) | NO |
| Merge | O(n log n) | O(n log n) | O(n) | SÍ |
| Quick | O(n log n) | O(n²) | O(log n) | NO |
| Heap | O(n log n) | O(n log n) | O(1) | NO |
| Counting | O(n+k) | O(n+k) | O(n+k) | SÍ |
| Radix | O(d(n+k)) | O(d(n+k)) | O(n+k) | SÍ |

### Búsqueda

| Algoritmo | Precondición | Complejidad |
|-----------|--------------|------------|
| Lineal | ninguna | O(n) |
| Binaria | ordenado + acceso aleatorio | O(log n) |
| BST | balance garantizado | O(log n) |
| Hash | hash uniforme | O(1) |

---

## 🎓 CONCEPTOS CRÍTICOS PARA EL EXAMEN

### 1. Big O vs Big Omega vs Big Theta
- **O**: cota SUPERIOR (peor caso)
- **Ω**: cota INFERIOR (mejor caso)
- **Θ**: cota AJUSTADA (cuando O = Ω)

### 2. Amortizado vs Garantizado
- **Garantizado**: cada operación es así
- **Amortizado**: promediado sobre muchas operaciones
- Ejemplo: HashMap inserción O(1) amortizado (redimensiona cada tanto)

### 3. In-place vs Auxiliar
- **In-place**: O(1) espacio extra (Quicksort)
- **Auxiliar**: O(n) espacio extra (Merge sort)

### 4. Estable vs Inestable
- **Estable**: elementos iguales mantienen orden original (Merge sort)
- **Inestable**: podrían cambiar de orden (Quicksort)

### 5. Precondiciones No Negociables
- Búsqueda binaria: **DEBE estar ordenado**
- BST: **DEBE cumplir invariante**
- Counting sort: **DEBE estar en rango [0, k)**

### 6. El Pivote en Quicksort
- Mejor caso: siempre en la mitad → O(n log n)
- Peor caso: siempre en extremo → O(n²)
- Solución: elegir aleatorio o mediana de 3

### 7. Hashing: Collisión es Inevitable
- Principio del palomar: dominio grande → rango pequeño → colisiones
- Encadenamiento: lista en cada celda
- Factor de carga: n/m (redimensiona cuando > 0.75)

### 8. Recursión: Acceso a la Base
- SIN caso base → infinita
- Caso base mal definido → lógica incorrecta
- Profundidad excesiva → stack overflow

---

## ❓ PREGUNTAS DE REPASO (Prepárate para responder)

### Nivel Básico
1. ¿Cuál es la diferencia entre O(n²) y O(n log n) para n = 1.000.000?
2. ¿Por qué búsqueda binaria requiere que el array esté ordenado?
3. ¿Qué es una colisión en hash y por qué es inevitable?
4. ¿Cuándo usarías Insertion sort en lugar de Merge sort?
5. ¿Qué significa que un algoritmo tenga complejidad O(1) amortizado?

### Nivel Intermedio
6. Ordena estos por velocidad para n = 100.000: O(n²), O(n log n), O(n), O(log n)
7. ¿Por qué Quicksort es más rápido que Merge sort en la práctica si ambos son O(n log n)?
8. ¿Qué ocurre con un BST si insertas elementos en orden: 1,2,3,4,5?
9. ¿Cuál es el factor de carga en HashMap cuando redimensiona?
10. ¿Por qué Merge sort es estable pero Quicksort no?

### Nivel Avanzado
11. Escribe la recurrencia T(n) para Merge sort y resuélvela.
12. ¿Qué pasa si aplicas búsqueda binaria en una lista enlazada?
13. Explica por qué Counting sort es O(n+k) en lugar de O(n log n).
14. Si un objeto es inmutable, ¿cuándo ocurren efectos secundarios?
15. ¿Cómo evitar que un BST degenere en lista?

### Análisis Práctico
16. Diseña un escenario donde Insertion sort supera a Merge sort.
17. ¿Cuál es el peor caso de búsqueda en tabla hash con encadenamiento?
18. Calcula el factor de carga en una tabla hash con 1.000 elementos y 1.024 posiciones.
19. ¿Por qué SHA-256 no es adecuado para tabla hash?
20. Si necesitas gastar O(1) amortizado, ¿qué estructuras son candidatas?

---

## 🚀 ALGORITMOS CLAVE A MEMORIZAR

### Pseudocódigo: Búsqueda Binaria
```
buscar(array, objetivo):
    izq ← 0, der ← length - 1
    mientras izq ≤ der:
        medio ← izq + (der - izq) / 2
        si array[medio] == objetivo: devuelve medio
        si array[medio] < objetivo: izq ← medio + 1
        si no: der ← medio - 1
    devuelve -1
```

### Pseudocódigo: Merge Sort
```
mergeSort(array, izq, der):
    si izq ≥ der: devuelve
    medio ← izq + (der - izq) / 2
    mergeSort(array, izq, medio)
    mergeSort(array, medio+1, der)
    fusionar(array, izq, medio, der)

fusionar(array, izq, medio, der):
    // recorre dos mitades, toma menor, escribe en resultado
```

### Pseudocódigo: Quicksort
```
quickSort(array, izq, der):
    si izq ≥ der: devuelve
    pivote ← particionar(array, izq, der)
    quickSort(array, izq, pivote-1)
    quickSort(array, pivote+1, der)

particionar(array, izq, der):
    piv ← array[der]
    i ← izq - 1
    para j de izq a der-1:
        si array[j] ≤ piv:
            i ← i + 1
            intercambia(array, i, j)
    intercambia(array, i+1, der)
    devuelve i+1
```

---

## 💡 TIPS FINALES PARA EL EXAMEN

### ✅ HAZLO
- Memoriza el **ranking de complejidades**: O(1) < ... < O(n!)
- Aprende **tres líneas** de cada algoritmo principal
- **Entiende por qué**, no solo el cómo
- Conoce **cuándo usar cada uno** (aplicación)
- Ten claro el **compromiso espacio-tiempo**

### ❌ NO HAGAS
- Memorizar código completo (entiende estructura)
- Confundir O(n log n) con O(n²)
- Aplicar búsqueda binaria sin orden
- Ignorar precondiciones
- Pensar que más rápido = mejor siempre (mantenibilidad importa)

### 🎯 SI TE PREGUNTA...
| Si pregunta | Responde |
|-----------|----------|
| "¿Complejidad de...?" | Caso base → recurrencia → resolución |
| "¿Cuándo usarías...?" | Precondiciones, tamaño datos, número operaciones |
| "¿Por qué es O(n²)?" | Bucles anidados → n × n comparaciones |
| "¿Estable o no?" | Depende si intercambias iguales |
| "¿Y si datos están ya...?" | Mejor caso vs peor caso distinto |

---

## 📚 CONCEPTOS QUE NO DEBES OLVIDAR

1. **Precondiciones**: Búsqueda binaria EXIGE orden
2. **Amortización**: O(1) amortizado ≠ O(1) garantizado
3. **Estabilidad**: Merge sort SÍ, Quicksort NO
4. **Compromiso**: Más espacio → más velocidad
5. **Recursión**: Necesita caso base, reduce hacia él
6. **Hash**: Colisiones son matemáticamente inevitables
7. **Immutabilidad**: Crea objeto NUEVO, no modifica original
8. **In-place**: Modifica el array directamente (O(1) espacio)
9. **Peor caso**: Lo que garantizas en ingeniería
10. **Big O**: Asintótico, importa para n grande, no para n pequeño

---

**Última palabra**: Este curso te enseña a **pensar algorítmicamente**: analizar problemas, elegir técnicas, medir eficiencia. Eso es más valioso que memorizar código. El examen prueba si entiendes estos conceptos, no si programas rápido.

**¡A por ello! 💪**

---

*Guía de Estudio Completa - EDA2*  
*Última revisión: 2 horas antes del examen*
