package software.aoc2025.day2;

import software.aoc2025.day2.io.FileContentReader;
import software.aoc2025.day2.io.RangeDeserializer;
import software.aoc2025.day2.source.TextRangeSource;
import software.aoc2025.day2.service.IdValidator;

public class Main {

    public static void main(String[] args) {

        long totalResult = new TextRangeSource(
                new FileContentReader().readInput("day2.txt"),
                RangeDeserializer::convertTextToRange
                ).getRanges().mapToLong(IdValidator::calculate)
                .sum();
        System.out.println(totalResult);
    }
}
