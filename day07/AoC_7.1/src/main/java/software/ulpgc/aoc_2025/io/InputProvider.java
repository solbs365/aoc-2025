package software.ulpgc.aoc_2025.io;

import java.util.stream.Stream;

public interface InputProvider {
    Stream<String> readInput(String filename);
}
