package software.aoc2025.day1.model;

public record Rotation(String direction, int distance) {

    public static Rotation of(String text) {
        String dir = text.substring(0, 1);
        int dist = Integer.parseInt(text.substring(1));

        return new Rotation(dir, dist);
    }

}
