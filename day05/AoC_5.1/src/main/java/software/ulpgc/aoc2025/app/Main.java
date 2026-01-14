package software.ulpgc.aoc2025.app;

import software.ulpgc.aoc2025.io.InputParser;
import software.ulpgc.aoc2025.service.FreshnessValidator;
import software.ulpgc.aoc2025.io.ContentReader;

import java.util.Iterator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ContentReader reader = new ContentReader();

        System.out.println(
                new FreshnessValidator()
                        .countFreshIngredients(
                                InputParser.parseRangesSection(reader.readInput("day5.txt"))));
    }


}
