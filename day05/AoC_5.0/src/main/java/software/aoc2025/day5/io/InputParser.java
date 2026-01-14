package software.aoc2025.day5.io;

import software.aoc2025.day5.model.Range;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputParser {

    public static List<Range> parseRangesSection(Iterator<String> iterator) {

        List<Range> ranges = new ArrayList<>();

        // El stream se ha convertido en iterator
        while(iterator.hasNext()) {
            String line = iterator.next();

            if(line.isBlank())break;
            ranges.add(convertToRange(line));
        }
        return ranges;
    }

    // Metodo para procesar la segunda parte del archivo
    public static List<Long> parseIdsSection(Iterator<String> iterator) {
        List<Long> IdProducts = new ArrayList<>();
        while(iterator.hasNext()) {
            String line = iterator.next();
            IdProducts.add(Long.parseLong(line));
        }
        return IdProducts;
    }


    private static Range convertToRange(String line) {
        int hyphen = line.indexOf('-');

        long start = Long.parseLong(line.substring(0, hyphen));
        long end = Long.parseLong(line.substring(hyphen+1));

        return new Range(start, end);
    }
}
