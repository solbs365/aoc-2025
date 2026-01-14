package software.ulpgc.aoc2025.app;

import software.ulpgc.aoc2025.io.InputReader;
import software.ulpgc.aoc2025.io.TextFileReader;
import software.ulpgc.aoc2025.model.Grid;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new TextFileReader();

        List<String> lines = reader.readInput("day4.txt")
                .collect(Collectors.toList());

        Grid grid = GridParser.createGrid(lines);
        //System.out.println(grid.solve());
    }
}
