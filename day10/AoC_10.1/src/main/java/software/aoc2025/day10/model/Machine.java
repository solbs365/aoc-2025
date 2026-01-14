package software.aoc2025.day10.model;

import java.util.List;

public record Machine(boolean[] diagramLights, List<Button> buttons, List<Integer> voltages) {
}
