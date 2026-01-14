package software.aoc2025.day12.model;

import java.util.Arrays;
import java.util.List;

public record RegionProblem(int width, int height, List<Integer> quantities) {
    // Convierte [0,0,0,0,2,0] en una lista de IDs reales: [4, 4]
    public List<Integer> getGiftsToPlace() {
        List<Integer> ids = new java.util.ArrayList<>();
        for (int i = 0; i < quantities.size(); i++) {
            for (int q = 0; q < quantities.get(i); q++) ids.add(i);
        }
        return ids;
    }

    public static boolean isRegionLine(String line) { return line.contains("x") && line.contains(":"); }

    public static RegionProblem parse(String line) {
        String[] parts = line.split(":");
        String[] dims = parts[0].trim().split("x");
        List<Integer> qts = Arrays.stream(parts[1].trim().split("\\s+"))
                .map(Integer::parseInt).toList();
        return new RegionProblem(Integer.parseInt(dims[0]), Integer.parseInt(dims[1]), qts);
    }
}