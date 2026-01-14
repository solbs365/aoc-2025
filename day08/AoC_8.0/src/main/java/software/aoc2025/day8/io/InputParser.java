package software.aoc2025.day8.io;

import software.aoc2025.day8.model.Point3D;

import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    public List<Point3D> parsePoints(Stream<String> lines) {
        return lines.map(this::convertToPoint3D)
                .toList();
    }

    private Point3D convertToPoint3D(String line) {
        String[] coord = line.split(",");
        return new Point3D(
                Integer.parseInt(coord[0]),
                Integer.parseInt(coord[1]),
                Integer.parseInt(coord[2])
        );
    }
}
