package software.aoc2025.day8;

import software.aoc2025.day8.io.FileContentReader;
import software.aoc2025.day8.io.InputParser;
import software.aoc2025.day8.logic.CircuitSolver;
import software.aoc2025.day8.model.Point3D;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        FileContentReader reader = new FileContentReader();
        Stream<String> lines = reader.readInput("day8.txt");

        InputParser parser = new InputParser();
        List<Point3D> aa = parser.parsePoints(lines);

        CircuitSolver solution = new CircuitSolver();
        System.out.println(solution.solve(aa));
    }
}
