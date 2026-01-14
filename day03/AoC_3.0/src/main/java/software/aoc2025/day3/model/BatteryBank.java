package software.aoc2025.day3.model;

public record BatteryBank(String sequence) {

    public static BatteryBank from(String sequence) {
        return new BatteryBank(sequence);
    }
}