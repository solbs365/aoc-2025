package software.aoc_2025.day11;

import software.aoc_2025.day11.Solver.Solution;
import software.aoc_2025.day11.io.FileContentReader;
import software.aoc_2025.day11.io.InputParser;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileContentReader reader = new FileContentReader();

        Map<String, String[]> conn = new InputParser().parseDevices(reader.readInput("day11.txt"));

        System.out.println(new Solution()
                .countPaths("you", "out", conn));
    }
}
