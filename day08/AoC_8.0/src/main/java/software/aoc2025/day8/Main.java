package software.aoc2025.day8;

import software.aoc2025.day8.io.FileContentReader;
import software.aoc2025.day8.io.InputParser;
import software.aoc2025.day8.io.InputReader;
import software.aoc2025.day8.logic.CircuitSolver;
import software.aoc2025.day8.model.Point3D;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new FileContentReader();
        Stream<String> lines = reader.readInput("day8.txt");

        System.out.println(
                new CircuitSolver()
                        .solve(new InputParser()
                                .parsePoints(lines)));
    }
}
