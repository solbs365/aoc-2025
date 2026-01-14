package software.aoc2025.day1.service;

import software.aoc2025.day1.io.InputReader;
import software.aoc2025.day1.model.Dial;
import software.aoc2025.day1.model.Rotation;

import java.util.stream.Stream;

public class DialSecuritySystem {

    private final InputReader reader;

    public DialSecuritySystem(InputReader reader) {
        this.reader = reader;
    }

    public Dial resolvePassword(Stream<String> instruccions) {
        Dial initialDial = new Dial(50,0);

        return instruccions.map(Rotation::of)
                .reduce(initialDial, Dial::rotate, (d1,d2) -> d1);
    }
}
