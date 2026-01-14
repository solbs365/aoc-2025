package software.aoc2025.day2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileContentReader implements InputReader {

    public String readInput(String filename){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        if(inputStream == null){
            throw new RuntimeException("File " + filename + " not found");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .collect(Collectors.joining(","));
        } catch (IOException e) {
            throw new RuntimeException("Error!", e);
        }
    }
}
