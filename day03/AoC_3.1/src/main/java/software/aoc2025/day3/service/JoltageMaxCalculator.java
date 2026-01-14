package software.aoc2025.day3.service;

import software.aoc2025.day3.model.BatteryBank;

import java.util.ArrayList;
import java.util.List;

public class JoltageMaxCalculator implements JoltageCalculator {


    @Override
    public long calculate(BatteryBank batteryBank) {

        List<String> nums = findLargestSequence(batteryBank);
        String fullNumber = String.join("", nums);
        return Long.parseLong(fullNumber);
    }

    private List<String> findLargestSequence(BatteryBank batteryBank) {
        List<String> result = new ArrayList<>();
        int startLimit = 0;

        // Busca las 11 posiciones restantes
        for(int i=0; i<12; i++){
            // limite final: longitudTotal - 12 + i (para movernos de 1 en 1)
            int endLimit = batteryBank.sequence().length() -12 +i;
            int maxIndex = findMaxIndexInRange(batteryBank, startLimit, endLimit);

            startLimit = maxIndex + 1;
            result.add(String.valueOf(batteryBank.sequence().charAt(maxIndex)));
        }
        return result;
    }


    private int findMaxIndexInRange(BatteryBank batteryBank, int start, int end) {

        int maxDigit = 0;
        int index = 0;

        for(int i= start; i<= end; i++){
            int currentDigit = batteryBank.sequence().charAt(i);

            if(maxDigit < currentDigit){
                maxDigit = currentDigit;
                index = i;
            }
        }
        return index;
    }
}
