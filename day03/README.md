# Día 3: El Vestíbulo - Gestión de Energía

Este proyecto calcula el **joltage máximo** de bancos de baterías para reactivar las escaleras mecánicas del vestíbulo.

---

## Arquitectura y Patrones de Diseño

El enfoque principal de este módulo es la **extensibilidad** y el **bajo acoplamiento**:

### 1. Patrón Strategy (Open/Closed Principle)

Se ha implementado la interfaz `JoltageCalculator` para definir la **estrategia de cálculo**.  
Esto permite que el sistema soporte diferentes reglas de negocio (como el cambio de 2 a 12 baterías) simplemente **intercambiando la implementación concreta**, sin afectar al resto de la arquitectura.

### 2. Alta Cohesión (SRP)

- **Model:** `BatteryBank` encapsula la secuencia de entrada de forma **inmutable**.  
- **Service:** `JoltageService` se encarga exclusivamente de la **orquestación y suma del flujo de datos**, delegando la lógica matemática al calculador específico.  
- **IO:** `ContentReader` gestiona la obtención del flujo de datos de forma **perezosa (lazy)**.

### 3. Programación Funcional

El uso de la **API de Streams** permite procesar cada línea del banco de baterías de manera eficiente.  
Se emplea `mapToLong` para garantizar un **rendimiento óptimo** y evitar sobrecarga de memoria al manejar los grandes valores numéricos requeridos en la segunda parte del reto.

