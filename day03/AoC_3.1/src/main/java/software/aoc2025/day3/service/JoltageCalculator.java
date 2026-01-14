package software.aoc2025.day3.service;

import software.aoc2025.day3.model.BatteryBank;

import java.util.List;

public interface JoltageCalculator {
    long calculate(BatteryBank batteryBank);
}
