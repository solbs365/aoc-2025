package software.aoc2025.day9.io;

import software.aoc2025.day9.model.Position;

import java.util.List;
import java.util.stream.Stream;

public class PositionParser {

    public List<Position> parse(Stream<String> lines){

        return lines.map(s -> s.split(","))
                .map(this::convertToPosition)
                .toList();
    }

    private Position convertToPosition(String[] coordinates) {
        return Position.of(
                Long.parseLong(coordinates[0]),
                Long.parseLong(coordinates[1]));
    }


}
