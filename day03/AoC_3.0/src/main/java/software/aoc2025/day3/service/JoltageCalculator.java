package software.aoc2025.day3.service;

import software.aoc2025.day3.model.BatteryBank;

public interface JoltageCalculator {
    long calculate(BatteryBank batteryBank);
}
