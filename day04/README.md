# Advent of Code 2025 - Day 4: Optimización del Departamento de Impresión

Este proyecto resuelve el reto del Día 4, enfocado en el análisis de proximidad dentro de una cuadrícula de materiales (rollos de papel).

---

## Diseño y Modelado de Software

El enfoque principal de esta solución es la **mantenibilidad** y el **desacoplamiento**.

### 1. Modelo de Dominio (Domain Model)

Se han utilizado Java Records para representar las entidades principales:

- **Grid:** Representa la matriz de caracteres de forma inmutable, proporcionando métodos de utilidad como `valueAt(row, col)`.  
- **Position:** Un record ligero para gestionar coordenadas `(x, y)`.

### 2. Capa de Servicio (Stateless Service)

La lógica de cálculo reside en `GridService`. Este servicio se ha diseñado para ser **sin estado (stateless)**:

- El método `solve(Grid grid)` recibe la información necesaria por parámetro.  
- Facilita la **testabilidad** y cumple con los estándares de diseño empresarial, permitiendo procesar múltiples mallas con una única instancia del servicio.

### 3. Abstracción en la Entrada de Datos (I/O)

Para cumplir con los principios SOLID, la lectura de datos se basa en interfaces:

- **InputReader:** Interfaz que define el contrato de lectura.  
- **TextFileReader:** Implementación concreta para archivos del sistema de archivos.  
- **GridProvider:** Abstracción para la obtención y deserialización de objetos Grid.


## Ejecución

El programa lee el archivo `day4.txt` desde los recursos, procesa la cuadrícula y determina cuántos rollos de papel son accesibles basándose en la regla de negocio: **un rollo es accesible si tiene menos de 4 vecinos ocupados**.
