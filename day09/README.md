# Advent of Code 2025 - Day 9: The Cinema

Solución avanzada para la identificación de áreas rectangulares máximas en cuadrículas de baldosas mediante diseño orientado a objetos.

---

## Arquitectura y Principios de Ingeniería

### 1. Responsabilidad Única y Cohesión

Cada módulo está diseñado para ser altamente cohesivo:

- **Position (Model):** Representación inmutable de coordenadas.  
- **PositionParser (IO):** Mapping declarativo de datos planos a objetos de dominio.  
- **RectangleSolver (Service):** Motor de cálculo geométrico especializado.

### 2. Diseño Basado en Abstracciones

- Se ha implementado el Diseño por Contrato para asegurar la predictibilidad del sistema.  
- El uso de la interfaz `AreaSolver` permite que la lógica de negocio sea independiente de la implementación algorítmica específica.  
- La interfaz `InputReader` desacopla la aplicación de la infraestructura de persistencia.

### 3. Modularidad y Escalabilidad

- El sistema sigue un enfoque modular que reduce el acoplamiento fuerte.  
- **Flexibilidad:** Posibilidad de añadir decoradores o nuevas estrategias de resolución sin modificar el núcleo del sistema.  
- **Mantenibilidad:** Estructura de paquetes organizada para facilitar la navegación y comprensión del código.

---

## Implementación Técnica
Cálculo de área basado en esquinas opuestas mediante la fórmula: 

$$
Area = (|x_1 - x_2| + 1) \times (|y_1 - y_2| + 1)
$$


