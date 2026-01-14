package software.aoc2025.day3;

import software.aoc2025.day3.io.ContentReader;
import software.aoc2025.day3.model.BatteryBank;
import software.aoc2025.day3.service.JoltageCalculator;
import software.aoc2025.day3.service.JoltageMaxCalculator;
import software.aoc2025.day3.service.JoltageService;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> rawLines = new ContentReader().readInput("day3.txt");

        // (Strategy Pattern)
        JoltageCalculator strategy = new JoltageMaxCalculator();
        JoltageService service = new JoltageService(strategy);

        long total = service.calculateTotalJoltage(rawLines);
        System.out.println(total);
    }
}
