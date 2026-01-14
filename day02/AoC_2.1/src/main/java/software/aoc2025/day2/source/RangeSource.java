package software.aoc2025.day2.source;

import software.aoc2025.day2.model.Range;

import java.util.stream.Stream;

public interface RangeSource {
    Stream<Range> getRanges();
}
