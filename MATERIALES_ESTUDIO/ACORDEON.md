# 🔥 ACORDEÓN EXAMEN (10 MINUTOS)

---

## 1. COMPLEJIDADES (Memoriza)
```
1 < log n < n < n·log n < n² < 2ⁿ < n!
```

---

## 2. ANÁLISIS RÁPIDO
- **Bucles secuenciales:** suman → O(n + m) = O(n)
- **Bucles anidados:** multiplican → O(n × m)
- **Suma 1+2+...+n = n²/2:** O(n²)
- **Árbol binario altura h:** 2^h nodos, h = log n

---

## 3. RECURSIÓN
- **Caso base:** condición terminal
- **Paso recursivo:** reduce + combina
- **Sin caso base:** INFINITA
- **Profunda (>1000):** Stack overflow
- **O(2ⁿ):** memoizar

---

## 4. BÚSQUEDA
| Tipo | Precondición | Complejidad |
|------|--------------|------------|
| Lineal | NINGUNA | O(n) |
| Binaria | ORDENADO | O(log n) |
| BST | Balanceado | O(log n) |
| Hash | Uniforme | O(1) |

**Búsqueda binaria sin orden = INCORRECTO**

---

## 5. ORDENACIÓN
| Algoritmo | Complejidad | Estable | Cuándo |
|-----------|------------|---------|--------|
| Insertion | O(n²) | SÍ | n<50 |
| Merge | **O(n log n)** | SÍ | Garantía |
| Quick | O(n log n)* | NO | Práctico |
| Counting | O(n+k) | SÍ | k pequeño |

*O(n²) peor caso

---

## 6. HASH
- Factor carga = n/m
- Colisiones = inevitable
- Encadenamiento = listas
- O(1) amortizado

---

## 7. INMUTABILIDAD
```
final atributos
+ constructor completo
+ withers (no setters)
= objeto NO se modifica
```

---

## 8. TRAMPA CRÍTICA
| Pregunta | Respuesta |
|----------|-----------|
| BST orden? | O(n) si no balanceado |
| Bin búsqueda sin orden? | ❌ INCORRECTO |
| Hash sin colisión? | Imposible |
| Recursión sin base? | Infinita |
| Inmutable mutable attr? | Copiar entrada/salida |

---

## 9. FÓRMULA RÁPIDA
Cuando veas: **n × (n-1) / 2** → **O(n²)**

Cuando veas: **log₂(n)** → **O(log n)**

Cuando veas: **2 × 2 × 2...** → **O(2ⁿ)**

---

## 10. ÚLTIMA LÍNEA
**Merge sort = O(n log n) GARANTIZADO**  
**Todo lo demás: depende de condiciones**

---

**¡SUERTE! 🎯**
