package software.ulpgc.aoc_2025.app;

import software.ulpgc.aoc_2025.model.ElfMap;
import software.ulpgc.aoc_2025.model.TilePosition;

import java.util.List;

public interface MaxAreaCalculator {
    long findMaxArea(List<TilePosition> tilePositions, ElfMap elfMap);
}
