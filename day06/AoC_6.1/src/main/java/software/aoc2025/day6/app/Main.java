package software.aoc2025.day6.app;

import software.aoc2025.day6.io.ContentReader;
import software.aoc2025.day6.io.InputParser;
import software.aoc2025.day6.solver.OperationSolver;


public class Main {
    public static void main(String[] args) {
        ContentReader reader  = new ContentReader();


        long total = InputParser.getOperations(InputParser.prepareMatrix(InputParser.readInputMatrix(reader.readInput("day6.txt"))))
                .stream()
                .map(OperationSolver::solve)
                .mapToLong(Long::longValue)
                .sum();

        System.out.println("Total: " + total);
    }
}
