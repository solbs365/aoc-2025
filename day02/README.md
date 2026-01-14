# Día 2: Tienda de Regalos - Gestión de IDs

Este proyecto resuelve el reto de identificación de IDs inválidos mediante un diseño orientado a **componentes desacoplados**.  

---

## Arquitectura del Sistema

El diseño se basa en la **separación de intereses** para cumplir con los estándares de **Software Limpio (Clean Code)**:

### 1. Desacoplamiento de Entrada (IO)

Mediante la interfaz `InputReader`, se abstrae el proceso de lectura de datos.  
La implementación `FileContentReader` se encarga de la gestión física de los recursos, permitiendo que la lógica de negocio sea **independiente del origen de la información**.

### 2. Transformación de Datos (Deserialization)

La clase `RangeDeserializer` actúa como un componente especializado en la **conversión de texto plano a objetos de dominio**.  
Se inyecta en la fuente de datos mediante una **referencia a método** (`RangeDeserializer::convertTextToRange`), demostrando un uso avanzado de la **programación funcional**.

### 3. Lógica de Dominio e Inmutabilidad

- **Range:** Implementado como un `record` de Java para asegurar la integridad de los datos mediante **inmutabilidad**.  
- **IdValidator:** Centraliza las reglas de negocio para determinar la validez de un ID basándose en **patrones de repetición**.

### 4. Uso de Streams y API Funcional

El flujo principal de la aplicación en la clase `Main` utiliza un **pipeline de Streams** para transformar las cadenas de texto en resultados numéricos, evitando estructuras de control imperativas y mejorando la **mantenibilidad** del código.

