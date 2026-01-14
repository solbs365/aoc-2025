package software.aoc2025.day12;

import software.aoc2025.day12.io.ContentReader;
import software.aoc2025.day12.io.InputData;
import software.aoc2025.day12.io.InputParser;
import software.aoc2025.day12.service.GiftService;

public class Main {
    public static void main(String[] args) {
        ContentReader reader = new ContentReader();
        InputParser parser = new InputParser();
        GiftService service = new GiftService();

        InputData input = parser.parse(reader.readInput("day12.txt"));

        long successfulRegions = input.regions().stream()
                .filter(region -> service.canFitAll(region, input.shapes()))
                .mapToLong(region -> (long) region.width() * region.height())
                .sum(); // solo cambian estas 2 lineas

        System.out.println(successfulRegions);
    }
}
