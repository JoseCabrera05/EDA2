# Ejemplos de inmutabilidad

| Aspecto | [`Persona` mutable](./e000/Persona.java) | [`Persona` inmutable](./e001/Persona.java) |
|---|---|---|
| **Modificación** | Se modifica el mismo objeto en memoria. | No se modifica. Se crea un objeto nuevo. |
| **Métodos de cambio** | Setters (`setNombre`) alteran el estado interno. | Withers (`withNombre`) devuelven una instancia nueva. |
| **Referencias** | Todas las referencias ven el cambio. | Las referencias anteriores conservan su valor. |
| **Ejemplo de cambio** | `original.setNombre("Nuevo");` | `Persona nueva = original.withNombre("Nuevo");` |
| **¿El objeto original cambia?** | Sí, directamente. | No, permanece igual. |

