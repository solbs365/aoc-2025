package software.aoc2025.day3.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ContentReader implements InputReader{

    public Stream<String> readInput(String filename){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        if(inputStream == null){
            throw new RuntimeException("File " + filename + " not found");
        }

        // OJO: Ya no usamos el 'try' aquí, porque eso cerraría el fichero inmediatamente. -> AHORA ES RESPONSABILIDAD DEL MAIN CERRARLO
        // Creamos el reader y devolvemos su flujo de líneas directamente.
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines();
    }
}
