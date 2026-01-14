package software.aoc2025.day9.app;

import software.aoc2025.day9.io.ContentReader;
import software.aoc2025.day9.io.PositionParser;


public class Main {
    public static void main(String[] args) {

        long result = new RectangleSolver()
                .findMaxArea(new PositionParser()
                        .parse(new ContentReader()
                                .readInput("day9.txt")));

        System.out.println(result);
    }
}
