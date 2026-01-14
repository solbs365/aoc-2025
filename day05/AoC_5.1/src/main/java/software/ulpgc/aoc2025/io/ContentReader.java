package software.ulpgc.aoc2025.io;

// Clase que se encarga de leer el archivo
// haré una separación leyendo hasta que encuentre una linea en blanco -> y los almaceno en la clase Rango
// el resto de las lineas -> son los ingredientes

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines();
    }
}
