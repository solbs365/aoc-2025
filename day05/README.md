# Advent of Code 2025 - Day 5: Cafetería (Gestión de Inventario)

Este módulo resuelve el problema de clasificación de ingredientes frescos frente a estropeados mediante la validación de rangos numéricos.

---

## Decisiones de Diseño y Modelado

### 1. Consumo Eficiente de Datos (InputParser)

Dada la naturaleza del archivo de entrada (dos bloques de datos separados por una línea en blanco), se ha implementado un sistema de **Parsing Secuencial**:

- Se utiliza un `Iterator<String>` derivado del Stream original.  
- Esto permite extraer primero los objetos `Range` y luego los IDs en un único paso por el flujo de datos, minimizando el impacto en memoria.

### 2. Arquitectura Stateless en la Capa de Servicio

Se ha refinado el `FreshnessValidator` para eliminar estados internos:

- **Desacoplamiento:** El servicio no "conoce" los rangos de antemano; los recibe como argumento.  
- **Transparencia:** El comportamiento del servicio es determinista y depende exclusivamente de los parámetros de entrada, siguiendo los principios de la programación funcional.

### 3. Inmutabilidad y Semántica

- **Records:** Se mantiene el uso de records (`Range`) para definir los intervalos de frescura.  
- **Validación Óptima:** La comprobación de frescura utiliza `Stream.filter().findFirst()`, lo que garantiza que el proceso de búsqueda se detenga inmediatamente al encontrar una coincidencia.

---

## Estructura del Proyecto

- **io:** Contiene el `ContentReader` y el `InputParser`, encargados de la transformación de texto plano a objetos de dominio.  
- **model:** Define el record `Range`, la unidad básica de información.  
- **service:** Contiene la lógica de validación de frescura.

---

## Conceptos Clave para la Exposición

- **Separación de Responsabilidades:** El Parser sabe "leer", el Servicio sabe "validar".  
- **Short-circuiting:** Optimización en la búsqueda de rangos.  
- **Escalabilidad:** Uso de tipos `long` para manejar grandes volúmenes de IDs.

