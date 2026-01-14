package software.ulpgc.aoc_2025.io;

import software.ulpgc.aoc_2025.model.TilePosition;

import java.util.List;
import java.util.stream.Stream;

public class TilePositionParser {

    public List<TilePosition> parse(Stream<String> lines){

        return lines.map(s -> s.split(","))
                .map(this::convertToPosition)
                .toList();
    }

    private TilePosition convertToPosition(String[] coordinates) {
        return TilePosition.of(
                Long.parseLong(coordinates[0]),
                Long.parseLong(coordinates[1]));
    }


}
