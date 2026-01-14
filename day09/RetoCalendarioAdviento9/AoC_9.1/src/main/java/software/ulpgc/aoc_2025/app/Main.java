package software.ulpgc.aoc_2025.app;

import software.ulpgc.aoc_2025.io.ContentReader;
import software.ulpgc.aoc_2025.io.TilePositionParser;
import software.ulpgc.aoc_2025.model.ElfMap;
import software.ulpgc.aoc_2025.model.TilePosition;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // 1. Leer posiciones de #
        List<TilePosition> tilePositions =
                new TilePositionParser()
                        .parse(new ContentReader()
                                .readInput("day9.txt"));


        RectangleScanMaxAreaCalculator calculator = new RectangleScanMaxAreaCalculator();

        Long x = calculator.findMaxArea(tilePositions, new ElfMap(tilePositions));
        System.out.println(x);
    }
}
