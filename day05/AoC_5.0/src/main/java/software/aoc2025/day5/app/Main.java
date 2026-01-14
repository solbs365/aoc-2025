package software.aoc2025.day5.app;

import software.aoc2025.day5.io.InputParser;
import software.aoc2025.day5.model.Range;
import software.aoc2025.day5.service.FreshnessValidator;
import software.aoc2025.day5.io.ContentReader;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ContentReader reader = new ContentReader();

        // hay que crear una variable para obtener el iterador UNA SOLA VEZ
        Iterator<String> stringIterator = reader.readInput("day5.txt").iterator();

        List<Range> freshRanges = InputParser.parseRangesSection(stringIterator);
        List<Long> availableIds = InputParser.parseIdsSection(stringIterator);

        int totalFresh = new FreshnessValidator().countFreshIngredients(freshRanges, availableIds);
        System.out.println("Total fresh ingredients: " + totalFresh);
    }
}
