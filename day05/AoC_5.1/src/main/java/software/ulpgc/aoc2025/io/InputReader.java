package software.ulpgc.aoc2025.io;

import java.util.stream.Stream;

public interface InputReader {
    Stream<String> readInput(String filename);
}
