package software.aoc2025.day2.source;

import software.aoc2025.day2.model.Range;

import java.util.Arrays;

import java.util.function.Function;
import java.util.stream.Stream;

import static software.aoc2025.day2.io.RangeDeserializer.tokenize;


public class TextRangeSource implements RangeSource {

    private final String text;
    private Function<String, Range> deserializer;

    public TextRangeSource(String text, Function<String, Range> deserializer) {
        this.text = text;
        this.deserializer = deserializer;
    }

    @Override
    public Stream<Range> getRanges() {
        return Arrays.stream(tokenize(text))
                .map(deserializer);

    }

}
