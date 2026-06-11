# 📚 ÍNDICE COMPLETO - MATERIALES DE ESTUDIO EDA2

## 📖 DOCUMENTOS CREADOS

### 1. **GUIA_ESTUDIO_EXAMEN.md** ⭐ PRINCIPAL
- **Duración:** 20-30 minutos lectura  
- **Contenido:** Todos los 6 temas con ejemplos, fórmulas, y explicaciones detalladas
- **Para:** Entender profundo cada tema
- **Recomendado:** Lee primero este

### 2. **ACORDEON.md** ⚡ REPASO ULTRARRÁPIDO
- **Duración:** 5-10 minutos  
- **Contenido:** Lo más esencial, tablas comprimidas
- **Para:** Repaso de último minuto
- **Recomendado:** Lee justo antes de entrar al examen

### 3. **CHEAT_SHEET.md** 📋 REFERENCIA RÁPIDA
- **Duración:** 10-15 minutos  
- **Contenido:** Algoritmos en 3 líneas, fórmulas, checklist
- **Para:** Verificar rápidamente un concepto
- **Recomendado:** Consulta mientras estudias

### 4. **PROBLEMAS_EXAMEN.md** 🧪 PRÁCTICA
- **Duración:** 20-30 minutos resolviéndolos  
- **Contenido:** 35+ ejercicios tipo examen con respuestas
- **Para:** Practicar antes del examen
- **Recomendado:** Haz 10-15 problemas

---

## ⏰ PLAN DE ESTUDIO (120 MINUTOS)

### FASE 1: Lectura Principal (30 min)
```
1. Abre GUIA_ESTUDIO_EXAMEN.md
2. Lee bloques 1-3 (Análisis, Recursión, Búsqueda)
3. Para en Ordenación, haz descanso
```

### FASE 2: Ordenación & Hash (25 min)
```
1. Continúa GUIA_ESTUDIO_EXAMEN.md
2. Lee bloques 4-5 (Ordenación, Hashing)
3. Consulta CHEAT_SHEET.md para tablas
```

### FASE 3: Práctica (35 min)
```
1. Abre PROBLEMAS_EXAMEN.md
2. Resuelve 8-10 problemas (2-3 min cada uno)
3. Consulta respuestas
4. Si no entiendes: vuelve a GUIA
```

### FASE 4: Inmutabilidad & Repaso (20 min)
```
1. Lee Inmutabilidad en GUIA_ESTUDIO_EXAMEN.md
2. Repasa secciones donde tengas dudas
3. Haz 3-4 problemas más
```

### FASE 5: Último Minuto (10 min)
```
1. Lee ACORDEON.md completo
2. Repasa CHEAT_SHEET resumen
3. Respira 2-3 veces
4. Entra al examen
```

---

## 🎯 ESTRUCTURA DE TEMAS

### Bloque 1: Instrumental
- ✅ **Análisis de Algoritmos** → GUIA sección 1️⃣
  - Big O, peor/mejor caso, análisis iterativo/recursivo
  - PROBLEMAS 1.1 - 1.4
  
- ✅ **Recursión** → GUIA sección 2️⃣
  - Caso base, paso recursivo, memoización
  - PROBLEMAS 2.1 - 2.3

### Bloque 2: Acceso Eficiente
- ✅ **Orden y Búsqueda** → GUIA sección 3️⃣
  - Búsqueda lineal/binaria, BST
  - PROBLEMAS 3.1 - 3.4
  
- ✅ **Ordenación** → GUIA sección 4️⃣
  - Insertion, Merge, Quick, Counting sort
  - PROBLEMAS 4.1 - 4.5

### Bloque 3: Avanzado
- ✅ **Hashing** → GUIA sección 5️⃣
  - Función hash, tabla hash, colisiones, SHA-256
  - PROBLEMAS 5.1 - 5.5
  
- ✅ **Inmutabilidad** → GUIA sección 6️⃣
  - Clases inmutables, withers, map/filter/reduce
  - PROBLEMAS 6.1 - 6.5

---

## 📊 RESUMEN COMPLEJIDADES (MEMORIZA)

```
O(1)       Constante
O(log n)   Búsqueda binaria, BST
O(n)       Búsqueda lineal, recorrido
O(n log n) Merge sort, Quick sort (promedio)
O(n²)      Insertion sort, Bubble sort
O(2ⁿ)      Fibonacci sin optimizar
O(n!)      Permutaciones brutas
```

**Ranking:** 1 < log n < n < n·log n < n² < 2ⁿ < n!

---

## 🚀 ALGORITMOS PRINCIPALES

| Algoritmo | Complejidad | Uso |
|-----------|-----------|-----|
| **Búsqueda Binaria** | O(log n) | Datos ordenados |
| **Merge Sort** | O(n log n) | Garantía |
| **Quicksort** | O(n log n) prom | Mejor práctica |
| **Counting Sort** | O(n+k) | Rango pequeño |
| **Tabla Hash** | O(1) | Acceso rápido |

---

## 💡 CONCEPTOS CRÍTICOS

### NO CONFUNDAS
1. **Lineal O(n)** vs **Lineal-logarítmica O(n log n)**
2. **Garantizado** vs **Amortizado**
3. **In-place** vs **Auxiliar**
4. **Estable** vs **Inestable**
5. **Precondición** vs **Suposición**

### RECUERDA
- Búsqueda binaria **REQUIERE** orden
- Hash es O(1) **en promedio**
- Recursión **NECESITA** caso base
- Merge sort **GARANTIZA** O(n log n)
- Inmutabilidad **CREA** objeto nuevo

---

## 🎓 TIPOS DE PREGUNTAS EN EXAMEN

### Tipo 1: Análisis de Código
> "¿Cuál es la complejidad de este algoritmo?"
- **Estrategia:** Cuenta bucles (anidados = multiplica)
- **Ver:** PROBLEMAS 1.1, 1.2

### Tipo 2: Selección de Algoritmo
> "Tienes N elementos. ¿Qué algoritmo usarías?"
- **Estrategia:** Considera precondiciones, tamaño, operaciones
- **Ver:** PROBLEMAS 7.1 - 7.5

### Tipo 3: Corrección de Código
> "¿Hay algún problema? ¿Cómo lo arreglarías?"
- **Estrategia:** Busca caso base, orden, precondiciones
- **Ver:** PROBLEMAS 2.2, 6.3

### Tipo 4: Comparación
> "¿Cuál es mejor: A o B?"
- **Estrategia:** Compara complejidad + contexto
- **Ver:** PROBLEMAS 7.3

---

## ⚠️ PREGUNTAS TRAMPA

| Pregunta | Trampa | Respuesta Correcta |
|----------|--------|-------------------|
| "¿Es O(1) siempre rápido?" | O(1) amortizado espera a veces | Depende del factor de carga |
| "¿BST es siempre O(log n)?" | Si no está balanceado | Es O(n) si degenerado |
| "¿Búsqueda binaria sin orden?" | Parece funcionar a veces | Es incorrecto, resultado impredecible |
| "¿Hash sin colisiones?" | Es imposible | Principio del palomar |
| "¿Recursión sin límite?" | Parece funcionar para n pequeño | Stack overflow eventualmente |

---

## 📋 CHECKLIST PRE-EXAMEN

- [ ] Leíste GUIA_ESTUDIO_EXAMEN.md completo
- [ ] Entiendes los 6 temas principales
- [ ] Resolviste 10+ problemas
- [ ] Conoces ranking de complejidades
- [ ] Memorizaste 3 algoritmos clave
- [ ] Leíste ACORDEON.md
- [ ] Tienes CHEAT_SHEET disponible para consultar
- [ ] Descansaste 5+ minutos
- [ ] Respiraste profundo

---

## 🎯 FOCUS AREAS (Si solo tienes 30 minutos)

1. **ABSOLUTAMENTE CRÍTICO** (léelo sí o sí)
   - Ranking de complejidades
   - Búsqueda binaria precondiciones
   - Merge sort O(n log n) garantizado
   - Recursión caso base

2. **MUY IMPORTANTE** (aprende bien)
   - Insertion vs Merge vs Quicksort
   - Hash factor de carga
   - BST degeneración
   - Estabilidad

3. **IMPORTANTE** (ten noción)
   - Counting sort
   - Inmutabilidad
   - Análisis recursivo avanzado
   - Interpolation search

---

## 🎮 SIMULACIÓN MENTAL (5 min)

Imagina que el examen te pregunta:

1. **"Analiza este código"** → Cuento bucles → Doy complejidad
2. **"¿Qué algoritmo usarías?"** → Considero tamaño/precondición → Justifico
3. **"¿Por qué esto es O(n²)?"** → Explico bucles anidados → 1+2+...+n
4. **"Mejora esta solución"** → Sugiero estructura mejor → Justifico complejidad

---

## 📞 ÚLTIMO RECURSO

Si en el examen ves algo desconocido:

1. **¿Parece bucles?** → Analiza anidamiento
2. **¿Parece recursión?** → Busca caso base
3. **¿Busca algo?** → ¿Precondición orden?
4. **¿Ordena algo?** → ¿Tamaño datos? ¿Estabilidad?
5. **¿Hash?** → Factor de carga, colisiones

---

## 🏁 ÚLTIMA RECOMENDACIÓN

**PRIORIDAD:**
1. GUIA_ESTUDIO_EXAMEN.md (léelo completo)
2. PROBLEMAS_EXAMEN.md (resuelve 10+)
3. ACORDEON.md (repasa en último minuto)
4. CHEAT_SHEET.md (consulta mientras estudias)

**TIEMPO:**
- 40 min: Lectura GUIA
- 35 min: Resolver PROBLEMAS
- 25 min: Repasar dudas
- 20 min: ACORDEON + descanso

---

**¡MUCHO ÉXITO EN TU EXAMEN!** 🚀

Domina estos conceptos y verás que todo el resto sigue naturalmente.

