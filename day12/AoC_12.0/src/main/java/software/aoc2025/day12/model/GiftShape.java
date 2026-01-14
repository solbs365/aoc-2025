package software.aoc2025.day12.model;

import java.util.*;

public record GiftShape(int id, boolean[][] grid, int width, int height) {

    public static boolean isGiftBlock(String block) {
        String firstLine = block.split("\n")[0].trim();
        return firstLine.endsWith(":") && !firstLine.contains("x");
    }

    public static GiftShape parse(String block) {
        String[] lines = block.split("\n");
        int id = Integer.parseInt(lines[0].replace(":", "").trim());
        int h = lines.length - 1;
        int w = lines[1].length();
        boolean[][] grid = new boolean[h][w];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                grid[y][x] = lines[y + 1].charAt(x) == '#';
            }
        }

        return new GiftShape(id, grid, w, h);
    }

    // Genera todas las orientaciones únicas (rotaciones y flips)
    public List<GiftShape> getAllOrientations() {
        Set<GiftShape> orientations = new HashSet<>();
        boolean[][] current = this.grid;
        for (int f = 0; f < 2; f++) { // Con y sin flip
            for (int r = 0; r < 4; r++) { // 4 rotaciones
                orientations.add(new GiftShape(id, current, current[0].length, current.length));
                current = rotate(current);
            }
            current = flip(grid);
        }
        return new ArrayList<>(orientations);
    }

    private boolean[][] rotate(boolean[][] m) {
        boolean[][] res = new boolean[m[0].length][m.length];
        for (int r = 0; r < m.length; r++)
            for (int c = 0; c < m[0].length; c++) res[c][m.length - 1 - r] = m[r][c];
        return res;
    }

    private boolean[][] flip(boolean[][] m) {
        boolean[][] res = new boolean[m.length][m[0].length];
        for (int r = 0; r < m.length; r++)
            for (int c = 0; c < m[0].length; c++) res[r][m[0].length - 1 - c] = m[r][c];
        return res;
    }

    // Necesario para que el Set filtre duplicados
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GiftShape other)) return false;
        return Arrays.deepEquals(grid, other.grid);
    }

    @Override
    public int hashCode() { return Arrays.deepHashCode(grid); }
}