# ⚡ CHEAT SHEET - EDA2 (Repaso 5 minutos)

---

## 🔥 COMPLEJIDADES ESENCIALES

```
O(1)      → Constante (acceso array)
O(log n)  → Binaria, BST
O(n)      → Lineal, linea por línea
O(n log n)→ Merge, Quick (promedio)
O(n²)     → Anidados, Insertion, Bubble
O(2ⁿ)     → Exponencial, Fibonacci sin optimizar
O(n!)     → Permutaciones brutas
```

**Ranking:** 1 < log n < n < n log n < n² < 2ⁿ < n!

---

## 🎯 ALGORITMOS EN 3 LÍNEAS

### Búsqueda Lineal
```
Precondición: ninguna
Complejidad: O(n)
Cuándo: pequeño, desordenado, una búsqueda
```

### Búsqueda Binaria
```
Precondición: ORDENADO + acceso aleatorio
Complejidad: O(log n)
Cuándo: múltiples búsquedas, datos grandes
```

### Insertion Sort
```
Complejidad: O(n²) peor, O(n) mejor (ya ordenado)
Estable: SÍ
Cuándo: pequeño (<50), casi ordenado
```

### Merge Sort
```
Complejidad: O(n log n) garantizado
Estable: SÍ
Cuándo: necesitas GARANTÍA, datos externos, mucha memoria ok
```

### Quicksort
```
Complejidad: O(n log n) promedio, O(n²) peor
Estable: NO
Cuándo: mejor en práctica (caché), sin memoria limitada
```

### Counting Sort
```
Complejidad: O(n + k) donde k = rango valores
Estable: SÍ (recorrer de derecha a izquierda)
Cuándo: k pequeño (bytes, dígitos), valores discretos
```

---

## 🔑 HASH

**Factor de carga:** n / m (redimensiona en Java cuando > 0.75)

**Colisiones:** Matemáticamente inevitables (principio palomar)

**Resolución:** Encadenamiento (lista en cada celda)

**Operaciones:** insertar O(1), buscar O(1) promedio, O(n) peor

**SHA-256:** Para criptografía, NO para tabla hash (lenta)

---

## 📊 TABLA COMPARATIVA BÚSQUEDA

| Estructura | Búsqueda | Inserción |
|-----------|----------|-----------|
| Array | O(n) | O(1) |
| Array ordenado | O(log n) | O(n) |
| Tabla hash | O(1) | O(1) |
| BST | O(log n) | O(log n) |
| BST degenerado | O(n) | O(n) |

---

## 📊 TABLA COMPARATIVA ORDENACIÓN

| Algoritmo | Promedio | Peor | Espacio | Estable |
|-----------|----------|------|---------|---------|
| Insertion | O(n²) | O(n²) | O(1) | SÍ |
| Merge | O(n log n) | O(n log n) | O(n) | SÍ |
| Quick | O(n log n) | O(n²) | O(log n) | NO |
| Counting | O(n+k) | O(n+k) | O(n+k) | SÍ |

---

## 🧠 RECURSIÓN CHECKLIST

- ✅ ¿Tiene CASO BASE? (sin él → infinita)
- ✅ ¿REDUCE hacia caso base? (acerca, no aleja)
- ✅ ¿COMBINA resultados? (usa subproblema resuelto)
- ✅ ¿Profundidad aceptable? (< 1000 para evitar stack overflow)
- ✅ ¿MEMOIZACIÓN si O(2ⁿ)? (cacheando resultados)

---

## 💾 INMUTABILIDAD CHECKLIST

- ✅ Atributos `final`
- ✅ Constructor completo (inicializa todo)
- ✅ SIN setters
- ✅ CON withers (devuelven objeto NUEVO)
- ✅ Si atributo mutable: copiar al entrar Y salir

**Operaciones**: map (transformar), filter (conservar), reduce (combinar)

---

## ❌ TRAMPAS COMUNES

| Trampa | Error | Solución |
|--------|-------|----------|
| BST no balanceado | Degeneración O(n) | Usar AVL o Red-Black |
| Búsqueda binaria sin orden | Resultado incorrecto | Verificar PRECONDICIÓN |
| Recursión infinita | Stack overflow | Asegurar caso base |
| Hash mala distribución | Colisiones excesivas | Usar función uniforme |
| Objeto mutable inmutable | Cambios sin saberlo | Copiar al entrar/salir |
| Quicksort peor caso | O(n²) inesperado | Pivote aleatorio |

---

## 🚨 PREGUNTAS TIPO EXAMEN

**"¿Complejidad de...?"**
→ Analiza bucles (anidados = multiplica, secuencial = suma)

**"¿Cuándo usarías...?"**
→ Precondiciones, tamaño datos, número operaciones

**"¿Por qué O(n²)?"**
→ Bucles anidados → n × n

**"¿Estable?"**
→ ¿Elementos iguales mantienen orden? (Merge SÍ, Quick NO)

**"¿Mejor/Peor/Promedio?"**
→ Mejor: datos ideales, Peor: datos adversos, Promedio: típico

---

## 📐 FÓRMULAS CRÍTICAS

**Suma aritmética:** 1 + 2 + 3 + ... + n = n(n+1)/2 ≈ O(n²)

**Suma geométrica:** 1 + 2 + 4 + 8 + ... + 2ⁿ = 2^(n+1) - 1 ≈ O(2�ⁿ)

**Logaritmo binario:** log₂(1.000.000) ≈ 20

**Amortización:** Total / número operaciones

---

## 🎯 SI TIENES 1 MINUTO

1. **Ranking de complejidades**: memorizados
2. **Cuándo usar cada algoritmo**: memorizado
3. **Merge sort = O(n log n) GARANTIZADO**
4. **Búsqueda binaria = precondición ORDEN**
5. **Recursión = caso base + reducción**
6. **Hash = O(1) amortizado, colisiones inevitables**
7. **Inmutable = no muta, crea nuevo**

---

## 🎯 SI TIENES 5 MINUTOS

Relee las **3 líneas** de cada algoritmo:
- Búsqueda lineal
- Búsqueda binaria
- Insertion sort
- Merge sort
- Quicksort
- Counting sort

Verifica **tablas comparativas**.

Revisa **checklist recursión** e **inmutabilidad**.

---

## 🎯 SI TIENES 30 MINUTOS

1. Lee **GUIA_ESTUDIO_EXAMEN.md** completo (velocidad rápida)
2. Haz **3 problemas** de **PROBLEMAS_EXAMEN.md**
3. Relee **secciones críticas** que no entiendas
4. **Descansa 5 minutos**

---

## 💡 CONSEJO FINAL

**Entiende el PORQUÉ, no memorices el CÓMO.**

- ¿Por qué Merge sort es O(n log n)? → log n niveles, n trabajo por nivel
- ¿Por qué necesita búsqueda binaria orden? → divide por 2 cada vez
- ¿Por qué hash tiene O(1)? → acceso directo a posición
- ¿Por qué recursión necesita caso base? → sin él no termina

**La ley de oro:**
> Mejor no saber ningún algoritmo pero entender análisis,  
> que saber todos pero no entender cuándo usarlos.

---

**MUCHO ÉXITO EN TU EXAMEN! 🚀**

*Imprime esto o guarda en teléfono para revisar 30 segundos antes.*
