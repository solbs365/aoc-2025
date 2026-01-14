# Advent of Code 2025 - Day 8: Underground Playground

Este módulo resuelve el reto del parque infantil subterráneo, conectando cajas de conexiones eléctricas en un espacio 3D para formar circuitos optimizados.

---

## Principios de Ingeniería del Software Aplicados

### 1. Alta Cohesión y SRP (Single Responsibility Principle)

Cada componente del sistema tiene una única razón para cambiar:

- **Model:** Uso de records para representar entidades inmutables (`Point3D`, `Connection`).  
- **Logic:** El `CircuitSolver` coordina la solución, delegando el cálculo matemático a `DistanceCalculator` y la gestión de grupos a `UnionFind`.  
- **IO:** Separación entre el cargador de recursos y el parser de datos.

### 2. Desacoplamiento y Modularidad

- **DIP (Dependency Inversion Principle):** El sistema depende de la interfaz `InputReader`, permitiendo intercambiar el origen de los datos sin afectar la lógica de negocio.  
- **LSP (Liskov Substitution Principle):** La arquitectura permite sustituir implementaciones de entrada de manera transparente para el cliente (`Main`).

### 3. Patrones de Comportamiento y Algoritmia

- **Union-Find (DSU):** Implementación eficiente de conjuntos disjuntos con compresión de caminos para la agrupación de circuitos eléctricos.  
- **Declarative Programming:** Uso intensivo de la API de Streams para filtrado, ordenación y reducción de datos, mejorando la legibilidad y mantenimiento del código.

---

## Optimización y Rendimiento

- **Eficiencia Espacial:** Evitamos el uso de `Math.sqrt` comparando distancias al cuadrado, lo que ahorra operaciones costosas de CPU.  
- **Gestión de Primitivos:** Uso de `LongStream` para procesar grandes volúmenes de datos numéricos, reduciendo la sobrecarga de autoboxing.

---

## Estructura del Proyecto

- `software.aoc2025.day8.io`: Abstracción y carga de datos.  
- `software.aoc2025.day8.model`: Representación de datos inmutables.  
- `software.aoc2025.day8.logic`: Algoritmos de agrupación y resolución.  
- `software.aoc2025.day8`: Punto de entrada de la aplicación.

