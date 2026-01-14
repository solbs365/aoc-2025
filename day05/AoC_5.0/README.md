* SOBRE LA IMPLEMENTACION:
    - Al tratarse de un archivo en el que tenemos que leer dos partes distintas, usar Streams para ambas partes no se
    puede. Ya que si leemos la primera parte con Streams, desapareceria con la operacion terminal (ya que es de un solo uso).
    Soluciones:

    1. Implementar Iterator <> ya que tenemos como un "marcador" para saber por donde nos quedamos leyendo.
       Es decir leeriamos la primera parte (iterator.has.next(), iterator.next()) y luego leemos la segunda parte usando
       el mismo iterator.

    2. Todo con Streams. Leemos todo y lo procesamos en una Lista, y luego tenemos libertad para usar tantos streams 
       como queramos. DESVENTAJA: que ocupa más memoria
