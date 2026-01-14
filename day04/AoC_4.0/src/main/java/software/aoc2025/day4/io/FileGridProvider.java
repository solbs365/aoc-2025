package software.aoc2025.day4.io;

import software.aoc2025.day4.app.GridProvider;
import software.aoc2025.day4.model.Grid;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileGridProvider implements GridProvider {

    private final Stream<String> lines;
    private final Function<List<String>, Grid> deserialize;

    public FileGridProvider(Stream<String> lines, Function<List<String>, Grid> deserialize) {
        this.lines = lines;
        this.deserialize = deserialize;
    }

    @Override
    public Grid getGrid() {
        List<String> listOfLines = lines.filter(line -> !line.isEmpty())
                .collect(Collectors.toList());

        return deserialize.apply(listOfLines);
    }

}
