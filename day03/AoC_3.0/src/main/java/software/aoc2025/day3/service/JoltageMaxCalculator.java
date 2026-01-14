package software.aoc2025.day3.service;

import software.aoc2025.day3.model.BatteryBank;

public class JoltageMaxCalculator implements JoltageCalculator {


    @Override
    public long calculate(BatteryBank batteryBank) {
        return toLong(findMaxTensDigit(batteryBank) + findMaxUnitsDigit(batteryBank));
    }

    private String findMaxTensDigit(BatteryBank batteryBank){


        String range =  batteryBank.sequence().substring(0, batteryBank.sequence().length()-1);

        int maxDigit = range.chars()
                .map(Character::getNumericValue)       // Convierte ASCII a int real
                .max()                                 // Encuentra el mayor(OptionalInt)
                .orElse(0);                      // Si no encuentra un numero devuelve 0 para que no salte null

        return String.valueOf(maxDigit);
    }

    private String findMaxUnitsDigit(BatteryBank batteryBank){
        String range = batteryBank
                .sequence()
                .substring(batteryBank.sequence()
                        .indexOf(findMaxTensDigit(batteryBank))+1);

        int maxDigit = range.chars()
                .map(Character::getNumericValue)
                .max()
                .orElse(0);

        return String.valueOf(maxDigit);
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
