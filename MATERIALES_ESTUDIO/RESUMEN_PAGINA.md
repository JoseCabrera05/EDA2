# 📄 RESUMEN UNA PÁGINA - EDA2

---

## 🔥 LAS 10 COSAS MÁS IMPORTANTES

| # | Concepto | Detalles |
|---|----------|----------|
| 1 | **Big O Ranking** | 1 < log n < n < n·log n < n² < 2ⁿ |
| 2 | **Búsqueda Binaria** | O(log n) pero REQUIERE orden |
| 3 | **Merge Sort** | O(n log n) GARANTIZADO, estable, O(n) espacio |
| 4 | **Quicksort** | O(n log n) promedio, O(n²) peor, O(1) espacio |
| 5 | **Recursión** | Necesita caso base + reducción |
| 6 | **Hash** | O(1) amortizado, colisiones inevitables |
| 7 | **Estabilidad** | Merge SÍ, Quick NO |
| 8 | **Precondiciones** | Búsqueda binaria EXIGE orden |
| 9 | **Amortización** | O(1) promediado, no garantizado |
| 10 | **Inmutabilidad** | Crea objeto NUEVO, no muta |

---

## 📊 DECISIONES EN 30 SEGUNDOS

### ¿Cómo BUSCAR?
- **Datos pequeños, desordenados:** Lineal O(n)
- **Datos grandes, ordenados:** Binaria O(log n)
- **Múltiples búsquedas:** Hash O(1)
- **Estructura es dato:** BST O(log n)

### ¿Cómo ORDENAR?
- **n < 50:** Insertion O(n²)
- **Necesitas garantía:** Merge O(n log n)
- **Mejor práctica:** Quicksort O(n log n)
- **Rango pequeño:** Counting O(n+k)

### ¿COMPLEJIDAD de...?
- **Bucles anidados:** O(n²)
- **Divide & vencerás:** O(n log n)
- **Recursión exponencial:** O(2ⁿ)
- **Suma 1+2+...+n:** O(n²)

---

## ✅ CHECKLIST EXAMEN

- [ ] ¿Identifiqué bucles? → Cuento multiplicación
- [ ] ¿Preguntan precondiciones? → Busco ORDEN
- [ ] ¿Hay recursión? → Busco CASO BASE
- [ ] ¿Comparo algoritmos? → Considero CONTEXTO
- [ ] ¿Sobre inmutabilidad? → CREA objeto nuevo

---

## ⚡ ALGORITMOS EN 30 SEGUNDOS

```
BÚSQUEDA BINARIA: while izq ≤ der → medio → compara → ajusta
MERGE SORT: divide → ordena → fusiona → O(n log n) garantizado
QUICKSORT: elige pivote → particiona → recursión → O(n log n) promedio
COUNTING: cuenta → acumula → coloca → O(n+k)
HASH: función → módulo → colisiones → O(1) amortizado
```

---

## 🚨 ERRORES MÁS COMUNES

| Error | Corrección |
|-------|-----------|
| "Búsqueda binaria sin orden" | ❌ INCORRECTO |
| "Hash sin colisiones" | Imposible (palomar) |
| "BST siempre O(log n)" | Solo si balanceado |
| "Recursión sin caso base" | Infinita |
| "Mutable sin copiar" | No es inmutable |

---

## 💾 ESPACIO vs TIEMPO

| Algoritmo | Tiempo | Espacio | Mejor para |
|-----------|--------|---------|-----------|
| Merge | O(n log n) | O(n) | Garantía |
| Quick | O(n log n) | O(log n) | Práctica |
| Insertion | O(n²) | O(1) | Pequeño |
| Hash | O(1) | O(n) | Acceso rápido |

---

## 🎯 PREGUNTAS MODELO

### Pregunta 1: "¿Complejidad?"
**Respuesta:** Analizo bucles → 1 bucle = O(n), anidados = O(n²), etc.

### Pregunta 2: "¿Cuándo usar?"
**Respuesta:** Considero precondiciones, tamaño datos, número operaciones.

### Pregunta 3: "¿Por qué O(n²)?"
**Respuesta:** Dos bucles anidados → n × n comparaciones.

### Pregunta 4: "¿Mejor que..."?
**Respuesta:** Comparo complejidad + contexto del problema.

---

## 💡 FRASE CLAVE

> "**Merge Sort = O(n log n) GARANTIZADO**"  
> Todo lo demás depende de condiciones.

---

## 🏁 PLAN FINAL

| Tiempo | Acción |
|--------|--------|
| T-30 min | Lee GUIA completa |
| T-20 min | Resuelve 5 problemas |
| T-10 min | Lee ACORDEON.md |
| T-5 min | Respira profundo |
| T-0 | Entra confiado |

---

**LEE ESTO ÚLTIMOANTES DE ENTRAR:**

✅ Sé cuándo usar cada algoritmo  
✅ Entiendo complejidades  
✅ Identifiqué precondiciones  
✅ Practiqué problemas  
✅ Estoy listo  

---

**¡A por ello! 🚀**

