package software.aoc2025.day10.io;

import software.aoc2025.day10.model.Button;
import software.aoc2025.day10.model.Machine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    public List<Machine> parseMachines(Stream<String> input) {

        return input.map(rawButton -> rawButton.split(" "))
                .map(this::createMachineFrom)
                .toList();
    }

    private Machine createMachineFrom(String[] tokens) {
        List<Button> buttonList = extractRawButtons(tokens).stream()
                .map(s -> new Button(toInt(clearButtonValues(s))))
                .toList();

        return new Machine(clearLightDiagram(tokens), buttonList, clearVoltages(tokens));
    }

    private List<Integer> clearVoltages(String[] tokens) {
         String[] cleanVoltages = tokens[tokens.length - 1]
                .replace("{", "")
                .replace("}", "")
                .trim()
                .split(",");

         return parseIntegerList(cleanVoltages);
    }

    private List<Integer> parseIntegerList(String[] cleanVoltages) {

        return Arrays.stream(cleanVoltages)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    // separa los botones del resto del diagrama
    private List<String> extractRawButtons(String[] tokens) {
        return Arrays.asList(
                Arrays.copyOfRange(
                        tokens, 1, tokens.length - 1));  // para no coger los voltages
    }

    // para limpiar los paréntesis
    private String[] clearButtonValues(String button) {
        return button
                .replace("(", "")
                .replace(")", "")
                .trim()
                .split(",");
    }

    // para limpiar los corchetes
    private boolean[] clearLightDiagram(String[] tokens) {

        char[] cleanTokens = tokens[0]
                .replace("[", "")
                .replace("]", "")
                .toCharArray();

        return toBoolean(cleanTokens);
    }

    private boolean[] toBoolean(char[] cleanTokens) {
        boolean[] result = new boolean[cleanTokens.length];

        for (int i = 0; i < cleanTokens.length; i++) {
            result[i] =(cleanTokens[i] == '#');
        }
        return result;
    }

    private List<Integer> toInt(String[] str) {
        return Arrays.stream(str)
                .map(Integer::parseInt)
                .toList();
    }

}
