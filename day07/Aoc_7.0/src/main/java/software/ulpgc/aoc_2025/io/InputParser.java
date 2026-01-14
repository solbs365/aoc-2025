package software.ulpgc.aoc_2025.io;

import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    public List<char[]> parseGrid(Stream<String> lines){
        return lines.map(String::toCharArray)        // convierte a array de caracteres
                .toList();
    }
}
