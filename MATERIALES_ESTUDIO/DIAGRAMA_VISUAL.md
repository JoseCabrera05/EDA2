# 📊 DIAGRAMA VISUAL - EDA2 RÁPIDO

---

## 🌳 ÁRBOL DE DECISIÓN: ¿QUÉ ALGORITMO USAR?

```
                          ¿QUÉ HACER?
                                |
                    ____________|____________
                   |                        |
                BUSCAR                   ORDENAR
                   |                        |
        ___________|___________        _____|_____
       |                      |       |          |
    LINEAL                BINARIA   PEQUEÑO  GRANDE
    O(n)                 O(log n)      |        |
    Datos sin         Datos        n<50       n>50
    orden          ordenados      Insertion  Merge
                                  O(n²)    O(n log n)
                                    |        |
                              Ya          Necesitas
                             estable?    garantía?
                              SÍ/NO       SÍ/NO
```

---

## 📈 RANKING DE VELOCIDAD

```
PARA n = 1.000.000

O(1):          1 comparación
O(log n):      20 comparaciones
O(n):          1.000.000 comparaciones
O(n log n):    ~20.000.000 operaciones
O(n²):         ~1.000.000.000.000 operaciones ❌❌❌

Diferencia entre O(n log n) y O(n²):
Algo que tarda 1 segundo en O(n log n)
tardará 50.000 segundos en O(n²) = 14 horas ❌
```

---

## 🔄 ÁRBOL DE RECURSIÓN VISUAL

### Ejemplo: Merge Sort T(n) = 2T(n/2) + O(n)

```
Nivel 0:              [n]                          → n operaciones
                      / \
Nivel 1:          [n/2] [n/2]                      → n operaciones
                  /  \   /  \
Nivel 2:      [n/4][n/4][n/4][n/4]                 → n operaciones
             /  \  /  \ /  \ /  \
Nivel 3:    [.] [.] [.] [.] [.] [.] [.] [.]       → n operaciones

Profundidad = log₂(n) niveles
Total = n × log₂(n) = O(n log n)
```

---

## 🎯 COMPARATIVA EN TABLA

```
┌─────────────┬────────────────────────────────────────────────────┐
│ ALGORITMO   │ O(1)         O(log n)     O(n)       O(n²)        │
├─────────────┼────────────────────────────────────────────────────┤
│ n=100       │ Instant      Instant      Instant    Quick        │
│ n=1,000     │ Instant      Instant      Fast       Slow         │
│ n=1,000,000 │ Instant      20ms         1 segundo  1000 seg ❌  │
│ n=1,000,000 │ Instant      20ms         1 segundo  CRASH ❌     │
│ (Big Data)  │              (Binaria)    (Lineal)   (Cuadrática) │
└─────────────┴────────────────────────────────────────────────────┘

CONCLUSIÓN: Para datos grandes, O(n²) es INVIABLE
```

---

## 🔍 BÚSQUEDA: VISUALIZACIÓN

### Búsqueda Lineal
```
Array: [3, 7, 2, 9, 1, 4, 8]
Target: 9

Paso 1: ¿3 == 9? NO
Paso 2: ¿7 == 9? NO
Paso 3: ¿2 == 9? NO
Paso 4: ¿9 == 9? SÍ ENCONTRADO
Pasos: 4 (peor caso 7)
```

### Búsqueda Binaria
```
Array: [1, 2, 3, 4, 9, 7, 8] ← REQUIERE ORDEN
Ordenado: [1, 2, 3, 4, 7, 8, 9]
Target: 9

Paso 1: Medio[3] = 4 < 9 → derecha
        [7, 8, 9]
Paso 2: Medio[1] = 8 < 9 → derecha
        [9]
Paso 3: ¿9 == 9? SÍ ENCONTRADO
Pasos: 3 (en array ordenado)

sin Orden? INCORRECTO ❌
```

---

## 🎪 ORDENACIÓN: COMPARATIVA VISUAL

### Insertion Sort (pequeño)
```
Inicio:   [5, 2, 8, 1, 9]
Paso 1:   [5, 2, 8, 1, 9]  ← sin cambios
Paso 2:   [2, 5, 8, 1, 9]  ← inserta 2
Paso 3:   [2, 5, 8, 1, 9]  ← 8 en posición
Paso 4:   [1, 2, 5, 8, 9]  ← inserta 1
Paso 5:   [1, 2, 5, 8, 9]  ← 9 en posición
Estable: SÍ, O(n²) peor
```

### Merge Sort (grande)
```
Inicio:   [5, 2, 8, 1, 9]
Divide:   [5,2] [8,1,9]
Divide:   [5] [2] [8] [1,9]
Ordena:   [5] [2] [8] [1] [9]
Fusiona:  [2,5] [1,8,9]
Fusiona:  [1,2,5,8,9]
Garantía: O(n log n), Estable: SÍ
```

### Quicksort (práctico)
```
Inicio:   [5, 2, 8, 1, 9]
Pivote:   9
Particiona: [5,2,8,1] [9] ← 9 en posición final
Recursión sobre [5,2,8,1]
Resultado: [1,2,5,8,9]
Promedio: O(n log n), NO estable
```

---

## 🔗 HASH: COLISIÓN VISUAL

```
Función: hash(clave) = clave % 5

Array Hash (tamaño 5):
┌─────┐
│  0  │ → NULL
├─────┤
│  1  │ → [Ana:90] → [Bob:85] → NULL
├─────┤
│  2  │ → [Carlos:78] → NULL
├─────┤
│  3  │ → NULL
├─────┤
│  4  │ → [Diana:92] → NULL
└─────┘

Búsqueda "Bob":
1. hash("Bob") = ? % 5 = 1
2. Recorre lista en posición 1
3. Encuentra [Bob:85]
Complejidad: O(1) + O(lista) = O(1) promedio

Factor de carga: 4 personas / 5 posiciones = 0.8
```

---

## 🎨 INMUTABILIDAD: ANTES vs DESPUÉS

### CON MUTACIÓN (Mutable)
```
Persona persona = new Persona("Ana", "López");
persona.setApellido("Martínez");  // ← MUTA original

persona.nombre     = "Ana"
persona.apellido   = "Martínez" (cambió!)

PROBLEMA: Si otro código tenía referencia a persona
          vería el cambio sin haberlo hecho
```

### SIN MUTACIÓN (Inmutable)
```
Persona ana = new Persona("Ana", "López");
Persona anaMartinez = ana.withApellido("Martínez");

ana.nombre         = "Ana"
ana.apellido       = "López" (NO cambió!)

anaMartinez.nombre     = "Ana"
anaMartinez.apellido   = "Martínez" (nuevo objeto)

VENTAJA: Dos objetos distintos, original intacto
```

---

## 🌳 BST: BALANCEADO vs DEGENERADO

### Balanceado (bien)
```
          50
         /  \
       30   70
      / \   / \
    20 40 60 80

Búsqueda: max 3 pasos → O(log 8) = O(log n)
```

### Degenerado (mal) 
```
    1
     \
      2
       \
        3
         \
          4
           \
            5

Búsqueda 5: 5 pasos → O(n)
Es una LISTA ENLAZADA ❌

Solución: AVL tree (autobalanceo)
```

---

## 📊 ESTADÍSTICAS PARA n = 1.000.000

```
Algoritmo         Tiempo        Memoria      Uso
─────────────────────────────────────────────────────
O(log n)          20 ops        mínima       Binaria, BST
O(n)              1M ops        1 segundo    Lineal, Hash build
O(n log n)        20M ops       1 segundo    Merge, Quick
O(n²)             1T ops        ❌ CRASH    Insertion, Bubble
O(2ⁿ)             2^1M ops      UNIVERSO    Fib sin optimizar

CONCLUSIÓN:
- Preferible O(n log n) para datos grandes
- O(n²) es PROHIBITIVO para n grande
```

---

## 🧠 MAPA MENTAL: CONCEPTOS CONECTADOS

```
                    PROBLEMA
                        |
            ____________|____________
           |                        |
       BUSCAR                    ORDENAR
         |                          |
    Requiere?              Requiere?
         |                          |
      ORDEN           Size, Estable?, K
         |                    |
    Sí: Binaria         Pequeño: Insertion
    No: Lineal          Grande:  Merge/Quick
                        K pequeño: Counting
```

---

## ⚡ RESUMEN VISUAL DE COMPLEJIDADES

```
      Peor Caso
         |
    _____|_____
   |          |
O(n!)      O(2ⁿ)      Exponencial (EVITAR)
   |          |
   ⬇️        ⬇️
  O(n²)     Cuadrático (para n>1000 ❌)
   |
   ⬇️
O(n·log n)  Optimo (para ordena)
   |
   ⬇️
  O(n)      Lineal (aceptable)
   |
   ⬇️
O(log n)    Excelente (binaria)
   |
   ⬇️
  O(1)      Perfecto (hash, acceso)
```

---

## 🎯 REGLA DE TRES

```
SI...                          ENTONCES...
─────────────────────────────────────────────
Datos sin orden               → Búsqueda lineal O(n)
Datos con orden               → Búsqueda binaria O(log n)
Múltiples búsquedas           → Tabla hash O(1)
Necesita garantía O(n log n)  → Merge sort
Mejor rendimiento práctico    → Quicksort
n pequeño (<50)               → Insertion sort
Rango valores pequeño         → Counting sort
Recursión genera exponencial  → Memoización
Objeto cambia en tiempo       → Inmutabilidad
```

---

**ESTOS DIAGRAMAS = Lo esencial en imágenes**

Combina con **GUIA_ESTUDIO_EXAMEN.md** para profundidad.

