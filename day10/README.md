# Informe de Diseño: Advent of Code 2025 - Day 10 (Factory)

Este módulo resuelve el reto de la configuración de luces indicadoras en una fábrica mediante un algoritmo de optimización recursiva, priorizando la mantenibilidad y la especialización de componentes.

## 📐 Fundamentos de Ingeniería de Software Aplicados

### 1. Alta Cohesión y Principio de Responsabilidad Única (SRP)

Siguiendo las directrices académicas, cada módulo se centra en una tarea específica para facilitar su comprensión y modificación.

- **MachineSolver:** Clase altamente cohesiva dedicada exclusivamente a la resolución algorítmica mediante backtracking.  
- **InputParser:** Se encarga únicamente de la transformación de datos planos a objetos de dominio, asegurando que el sistema tenga un enfoque único para cada componente.  
- **record Machine y record Button:** Actúan como portadores de datos inmutables, centrando su responsabilidad en la representación del estado del sistema.

### 2. Abstracción y Diseño por Contrato

Se ha establecido una separación clara entre la visión externa de los objetos y sus detalles internos.

- **Interfaz `InputReader`:** Actúa como un contrato que especifica qué debe hacer el objeto (leer entrada), ocultando el "cómo" (ya sea desde archivos o flujos de red).  
- **Principio de Mínimo Compromiso:** Las interfaces muestran solo lo necesario para su operación, reduciendo la dependencia entre partes del sistema y facilitando la escalabilidad.

### 3. Modularidad y Reducción del Acoplamiento

El sistema ha sido diseñado para permitir el intercambio de sus componentes sin interrumpir la funcionalidad completa.

- **Inyección de Dependencias:** En la clase `Main`, se coordina la interacción entre el lector, el parser y el solver, evitando que las clases creen sus propias dependencias internamente.  
- **Acoplamiento Débil:** El uso de abstracciones permite que los cambios en la infraestructura de lectura (capa io) tengan un impacto nulo en la lógica de resolución (capa solver).

## 🛠️ Implementación Técnica

### Procesamiento Funcional (Streams API)

Se ha utilizado la API de Streams de Java para manejar secuencias de datos de manera declarativa y legible.

- **Pipeline de Procesamiento:** En `InputParser`, el uso de operaciones intermedias como `.map()` y terminales como `.toList()` permite una transformación de datos eficiente y reduce la posibilidad de errores manuales en bucles iterativos.

### Lógica Algorítmica (Backtracking)

El `MachineSolver` implementa una búsqueda recursiva para hallar el mínimo número de pulsaciones:

- **Inmutabilidad:** Se utiliza `.clone()` sobre los arrays de estado para garantizar que cada rama de la recursión trabaje de forma aislada, evitando efectos secundarios imprevistos.  
- **Caso Base:** El algoritmo valida si el estado actual de las luces coincide con el diagrama objetivo especificado en el contrato del manual.

## 📂 Estructura del Proyecto

- **io:** Infraestructura de persistencia y deserialización.  
- **model:** Objetos de dominio inmutables (Records).  
- **solver:** Lógica de negocio y optimización.  
- **app:** Orquestación y ejecución del sistema.

