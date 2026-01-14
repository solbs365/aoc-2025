package software.aoc2025.day12.io;

import software.aoc2025.day12.model.GiftShape;
import software.aoc2025.day12.model.RegionProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    public InputData parse(Stream<String> lines) {
        String fullContent = lines.collect(Collectors.joining("\n"));

        // 1. Delegamos la creación de formas a GiftShape
        List<GiftShape> shapes = Arrays.stream(fullContent.split("\n\n"))
                .map(String::trim)
                .filter(GiftShape::isGiftBlock) // Metodo estático en GiftShape
                .map(GiftShape::parse)          // Metodo estático en GiftShape
                .toList();

        // 2. Delegamos la creación de problemas a RegionProblem
        List<RegionProblem> regions = Arrays.stream(fullContent.split("\n"))
                .map(String::trim)
                .filter(RegionProblem::isRegionLine) // Metodo estático en RegionProblem
                .map(RegionProblem::parse)           // Metodo estático en RegionProblem
                .toList();

        return new InputData(shapes, regions);
    }
}
