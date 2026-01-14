1. El principio DRY (Don't Repeat Yourself) ♻️
   Fíjate en los métodos hasAccesibleNeighbors y neighborsOf. Ambos definen dos arrays: dRows y dCols.

Pregunta guía: Si decidieras cambiar las reglas del juego para que solo se permitan movimientos en cruz (arriba, abajo, izquierda, derecha) y no en diagonal, ¿en cuántos sitios tendrías que modificar tu código ahora mismo?

Sugerencia: ¿Cómo podrías extraer esos arrays para que sean una "única fuente de verdad" accesible por toda la clase?

2. Simplificación de Lógica Booleana 🧠
   Mira tu método isBounds. Tiene una estructura if (condicion_mala) return false; return true;. Y isAccessible hace algo similar con if (n >= 4).

En programación, las comparaciones (como n < 4 o row >= 0) ya devuelven un valor true o false por sí mismas.

Pregunta guía: ¿Cómo podrías reescribir esos métodos para que tengan una sola línea de código, eliminando los if y los else por completo?

3. "Números Mágicos" y Constantes 🔮
   En el método isAccessible usas el número 4. En los bucles for, usas el número 8. A esto se le llama "números mágicos" porque aparecen de la nada sin explicar qué significan.

Pregunta guía: Si otra persona lee tu código, ¿sabrá por qué es un 4 y no un 5? ¿Qué pasaría si extraes ese 4 a una constante con un nombre descriptivo al principio de la clase, como private static final int MAX_NEIGHBORS = 4;?

4. Naming (Nombrado Intencional) 🏷️
   Tienes un método llamado bfs. Ese nombre describe el algoritmo (Búsqueda en Anchura), pero no describe lo que hace en el contexto de tu problema (negocio).

Pregunta guía: El método bfs elimina rollos de papel conectados y devuelve la cantidad eliminada. ¿Qué nombre le pondrías para que alguien que no sepa informática entienda qué está ocurriendo con los rollos de papel? (Ejemplo: removeConnectedRolls o clearAccessibleArea).

APLICAR CLEAN CODE A LA CLASE GRID (mirar si neighborsOf lo puedo pasar a la clase Position)