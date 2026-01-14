# Advent of Code 2025 - Día 1: Entrada Secreta

Este proyecto resuelve el primer reto del Advent of Code aplicando los patrones y principios de diseño vistos en la asignatura de **Ingeniería del Software II**.  

---

## Estructura del Proyecto

El código se ha organizado en paquetes para maximizar la cohesión y facilitar el mantenimiento:

- **software.aoc2025.day1.model**  
  Contiene los objetos de dominio (`Dial`, `Rotation`) implementados como **records** para asegurar la inmutabilidad y la consistencia del estado.

- **software.aoc2025.day1.io**  
  Define la abstracción `InputReader` y su implementación para lectura de recursos, desacoplando la lógica de negocio del sistema de archivos.

- **software.aoc2025.day1.service**  
  Clase `DialSecuritySystem` que gestiona el procesamiento de las instrucciones mediante un **pipeline funcional**.

- **software.aoc2025.day1.app**  
  Clase `Main` que actúa como orquestador e inyecta las dependencias necesarias.

---

## Decisiones de Diseño

1. **Programación Funcional**  
   Se ha optado por el uso de **Streams** para el procesamiento de los datos. En lugar de iteraciones manuales, se emplea el método `reduce` para evolucionar el estado del dial de forma **declarativa**, lo que hace el código más legible y eficiente.

2. **SOLID y Patrones**

   - **SRP (Responsabilidad Única):** Cada clase tiene una única razón para cambiar. El modelo calcula el giro, el servicio orquesta y el IO lee datos.  
   - **DIP (Inversión de Dependencias):** El servicio no conoce la implementación real del lector de archivos, solo su interfaz.  
   - **Factory Method:** La creación de objetos `Rotation` está encapsulada en un método estático para limpiar el flujo de datos principal.  
   - **Inmutabilidad:** El uso de estados inmutables previene errores imprevistos y facilita el seguimiento del flujo del programa.
