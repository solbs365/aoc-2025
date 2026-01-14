package software.ulpgc.aoc_2025.model;

public record TilePosition(long x, long y) {

    public static TilePosition of(long x, long y) {
        return new TilePosition(x, y);
    }
}
