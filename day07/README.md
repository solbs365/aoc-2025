# Advent of Code 2025 - Day 7: Colectores de Taquiones

Este módulo simula la propagación y división de rayos de taquiones en un colector de laboratorio mediante técnicas de recorrido de grafos.

---

## Arquitectura y Decisiones de Ingeniería

### 1. Gestión de Estado y Ciclos

Dada la naturaleza del problema (donde varios rayos pueden converger en un mismo punto), se ha implementado un control de Nodos Visitados:

- **Estructura:** `Set<Position>` para garantizar unicidad.  
- **Eficiencia:** Evita la redundancia de cálculo y previene bucles infinitos en configuraciones de divisores complejos.

### 2. Simulación no Bloqueante (DFS)

Para la propagación del rayo, se ha optado por un enfoque iterativo sobre uno recursivo:

- Se utiliza una estructura de **Pila (Stack)** para simular la profundidad del rayo.  
- Esto aumenta la robustez del sistema ante diagramas de gran escala, eliminando el riesgo de errores por desbordamiento de pila del sistema.

### 3. Modelado de Dominio Rico (TachyonMap)

A diferencia de un modelo anémico, `TachyonMap` centraliza las reglas espaciales:

- **Responsabilidad:** Sabe dónde empieza el rayo (`findStart`) y valida los límites físicos (`isInside`).  
- **Abstracción:** El servicio `BeamSolver` no interactúa con arrays, sino con el objeto de dominio.

### 4. Pipeline de Datos en Main

El punto de entrada utiliza un patrón de **Tubería y Filtros (Pipeline):**

`Nombre de Archivo -> InputProvider -> InputParser -> Dominio -> Solver`

- Este enfoque permite una trazabilidad clara del flujo de datos y un manejo de errores centralizado mediante el uso de `Optional` (`findFirst().orElse()`).

---

## Principios de Diseño Aplicados

- **SRP (Single Responsibility Principle):** El `Solver` solo simula, el `Mapa` solo contiene, el `Loader` solo lee.  
- **Inmutabilidad:** Uso de `record Position` para asegurar que las coordenadas no sean alteradas durante el cálculo.  
- **Stateless Service:** El motor de resolución no mantiene estado entre llamadas, garantizando la seguridad en entornos concurrentes.

