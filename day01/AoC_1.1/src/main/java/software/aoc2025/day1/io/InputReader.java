package software.aoc2025.day1.io;

import java.util.stream.Stream;

public interface InputReader {
    Stream<String> readInput(String filename);
}
