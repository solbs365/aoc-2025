package software.aoc2025.day4.app;

import software.aoc2025.day4.io.InputReader;
import software.aoc2025.day4.io.TextFileReader;
import software.aoc2025.day4.model.Grid;
import software.aoc2025.day4.service.GridService;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> lines = new TextFileReader()
                .readInput("day4.txt")
                .collect(Collectors.toList());

        int result = new GridService()
                .solve(GridParser.createGrid(lines));

        System.out.println(result);
    }
}
