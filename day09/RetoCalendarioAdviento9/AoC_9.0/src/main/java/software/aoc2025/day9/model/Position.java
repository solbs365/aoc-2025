package software.aoc2025.day9.model;

public record Position(long x, long y) {

    public static Position of(long x, long y) {
        return new Position(x, y);
    }
}
