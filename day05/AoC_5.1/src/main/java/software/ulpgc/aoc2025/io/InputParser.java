package software.ulpgc.aoc2025.io;

import software.ulpgc.aoc2025.model.Range;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    public static List<Range> parseRangesSection(Stream<String> lines) {

        return lines.takeWhile(l -> !l.isBlank())
                .map(InputParser::convertToRange)
                .collect(Collectors.toList());
    }

    private static Range convertToRange(String line) {
        int hyphen = line.indexOf('-');

        long start = Long.parseLong(line.substring(0, hyphen));
        long end = Long.parseLong(line.substring(hyphen+1));

        return new Range(start, end);
    }
}
