# Advent of Code 2025 - Day 6: Software Design Report

Este proyecto ha sido desarrollado bajo los estándares de la Ingeniería del Software, priorizando la calidad del diseño sobre la mera implementación algorítmica.

---

## Decisiones de Arquitectura y Patrones

### 1. Desacoplamiento de la Capa de I/O

Se ha aplicado el Principio de Inversión de Dependencias (DIP) mediante la interfaz `InputReader`.

- La lógica de negocio no depende de archivos físicos.  
- El sistema es agnóstico al origen de los datos, permitiendo intercambiar el `ContentReader` por un lector de red o base de datos sin impacto en el núcleo del programa.

### 2. Transformación de Datos (Data Mapping)

El `InputParser` actúa como una capa de Transformación/Mapping:

- Implementa una transposición de matriz: convierte una estructura de persistencia horizontal (líneas de texto) en una estructura de dominio vertical (objetos `Operation`).  
- Este mapeo asegura que la lógica de resolución trabaje con objetos de negocio y no con tipos primitivos de texto.

### 3. Inmutabilidad en el Modelo de Dominio

Uso de Java Records (`Operation`, `Position`):

- **Thread-Safety:** Al ser inmutables por definición, estos objetos son seguros para el procesamiento en paralelo.  
- **Semántica:** El uso de records reduce el boilerplate code, permitiendo que el desarrollador se centre en la semántica del dominio.

### 4. Cohesión en la Capa de Servicio

El `OperationSolver` presenta una alta cohesión:

- Encapsula exclusivamente las reglas aritméticas de los cefalópodos.  
- Implementa una lógica de resolución centralizada, facilitando el mantenimiento y las pruebas unitarias aisladas.

---

## Principios SOLID Aplicados

| Principio | Aplicación en el Proyecto |
|-----------|--------------------------|
| SRP       | Cada clase tiene una responsabilidad única y bien definida. |
| OCP       | El `OperationSolver` es extensible para nuevos operadores sin alterar el flujo principal. |
| LSP       | Las implementaciones de `InputReader` son sustituibles entre sí. |
| ISP       | Las interfaces son granulares y específicas para la lectura de contenido. |
| DIP       | Los componentes de alto nivel no dependen de los de bajo nivel (uso de abstracciones). |

---

## Flujo de Ejecución (Pipeline)

El sistema opera como un pipeline funcional:  

`Reader (Stream) -> Parser (Matrix/Transposition) -> Solver (Logic) -> Collector (Sum)`

