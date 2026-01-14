# Informe de Diseño: Advent of Code 2025 - Day 12 (Christmas Tree Farm)

Este módulo resuelve el reto de optimización de espacio para regalos bajo los árboles de Navidad. El diseño se ha centrado en la mantenibilidad y la flexibilidad mediante una arquitectura desacoplada y el uso de algoritmos de búsqueda con retroceso (backtracking).

## Arquitectura y Principios de Diseño

### 1. Cohesión y Responsabilidad Única (SRP)

El sistema se ha diseñado bajo el concepto de especialización, asegurando que cada módulo se centre en una tarea específica:

- **GiftService:** Es un módulo altamente cohesivo donde todas las funciones y datos están estrechamente relacionados y enfocados en la tarea específica de encajar piezas.

- **InputParser:** Cumple con el Principio de Responsabilidad Única (SRP) al tener una única razón para cambiar: la estructura del archivo de entrada.

- **GiftShape:** Centraliza la lógica de las formas, incluyendo sus transformaciones geométricas, lo que facilita la comprensión y modificación del componente.

### 2. Abstracción y Diseño por Contrato

Se ha utilizado la abstracción para manejar la complejidad, resaltando los comportamientos esenciales mientras se ocultan detalles secundarios:

- **Contratos de Interfaz:** La comunicación entre el Main y el GiftService se basa en contratos claros que especifican qué debe hacer el objeto, pero no cómo lo hace.

- **Principio de Mínima Sorpresa:** El componente de resolución es intuitivo y predecible, evitando efectos secundarios inesperados durante la recursión.

- **Mínimo Compromiso:** La interfaz de las formas solo muestra lo necesario para su operación, reduciendo la dependencia entre diferentes partes del sistema.

### 3. Modularidad y Acoplamiento

El sistema permite el intercambio de componentes sin interrumpir la funcionalidad completa:

- **Reducción del Acoplamiento:** Al limitar las interacciones de los módulos, se reduce la dependencia en la estructura interna de otros componentes.

- **Inyección de Dependencias:** Se separa la creación de objetos de su uso en el flujo principal, permitiendo que las dependencias se "inyecten" desde fuera.

- **Sustitución de Liskov (LSP):** Los records de dominio (GiftShape, RegionProblem) se adhieren a un contrato de comportamiento que garantiza la interoperabilidad segura de los componentes.

## Implementación Técnica

### Procesamiento Funcional (API de Streams)

Se ha implementado el procesamiento de datos de manera declarativa y funcional:

- **Pipeline de Procesamiento:** El uso de streams permite combinar múltiples operaciones (filtrado, mapeo y transformación) de manera eficiente y legible.

- **Operaciones Intermedias:** Se han utilizado métodos como `filter` para descartar líneas inválidas y `map` para convertir texto en objetos de dominio.

### Algoritmo de Resolución (Backtracking)

El motor de resolución implementa una búsqueda en profundidad para gestionar la complejidad del problema:

- **Estrategia de Búsqueda:** El algoritmo intenta colocar una pieza y, si no es posible completar el resto del conjunto, realiza un retroceso (backtrack) para probar una nueva configuración.

- **Poda por Heurística:** Para optimizar el rendimiento y evitar la explosión combinatoria, el sistema ordena los regalos por área descendente, priorizando la colocación de las piezas más restrictivas.

## Estructura del Proyecto

- **io:** Gestión de persistencia y deserialización de datos.

- **model:** Definición de objetos de dominio inmutables (Java Records).

- **service:** Lógica de negocio y algoritmos de empaquetado 2D.

- **app:** Punto de entrada y orquestación del sistema.

