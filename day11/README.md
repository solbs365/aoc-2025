# Advent of Code 2025 - Day 11: Reactor Communication

Este proyecto implementa un motor de resolución de rutas para un reactor toroidal, analizando la comunicación entre dispositivos mediante teoría de grafos.

## 📐 Especificaciones de Ingeniería del Software

### 1. Especialización y Cohesión (SRP)

Se ha aplicado una división modular estricta para asegurar que cada componente se centre en una tarea única:

- **Infraestructura (io):** Gestión de persistencia desacoplada mediante interfaces.  
- **Modelo (model):** Definición inmutable de componentes mediante Java Records.  
- **Lógica (Solver):** Implementación de algoritmos de búsqueda de caminos en grafos.

### 2. Abstracción y Diseño por Contrato

- **Interfaz `InputReader`:** Define un contrato explícito para la entrada de datos, permitiendo el cumplimiento del Principio de Sustitución de Liskov (LSP).  
- **Encapsulamiento:** Los detalles de implementación de la lectura y el parseo están ocultos tras métodos públicos descriptivos.

### 3. Procesamiento Funcional y Declarativo

- **API de Streams:** Uso de pipelines funcionales en el parser y el solver para mejorar la legibilidad y reducir el estado mutable.  
- **Optimización de Primitivos:** Empleo de `IntStream` para el conteo de rutas, minimizando la sobrecarga de memoria.

## 🚀 Lógica del Algoritmo

El sistema utiliza un algoritmo recursivo de conteo de caminos en un Grafo Dirigido Acíclico (DAG):

- **Caso Base:** La recursión finaliza cuando el nodo actual coincide con el destino (`out`), retornando 1.  
- **Propagación:** Se suma recursivamente el número de caminos posibles a través de todas las salidas de cada dispositivo intermedio.

