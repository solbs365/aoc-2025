package software.aoc_2025.day11.io;

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
