package software.aoc2025.day3.service;

import software.aoc2025.day3.model.BatteryBank;

import java.util.stream.Stream;

public class JoltageService {

    private final JoltageCalculator calculator;

    public JoltageService(JoltageCalculator calculator) {
        this.calculator = calculator;
    }

    public long calculateTotalJoltage(Stream<String> rawLines){
        return rawLines.map(BatteryBank::from)
                .mapToLong(calculator::calculate)
                .sum();
    }


}
