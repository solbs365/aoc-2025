package software.aoc_2025.day11;

import software.aoc_2025.day11.Solver.Solution;
import software.aoc_2025.day11.io.ContentReader;
import software.aoc_2025.day11.io.InputParser;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ContentReader reader = new ContentReader();

        System.out.println(new Solution()
                .countPaths("svr", "out", new InputParser().parseDevices(reader.readInput("day11.txt")),
                        false, false, new HashSet<>()));
    }
}
