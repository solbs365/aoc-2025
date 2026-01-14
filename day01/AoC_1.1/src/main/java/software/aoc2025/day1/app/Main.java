package software.aoc2025.day1.app;

import software.aoc2025.day1.io.ContentReader;
import software.aoc2025.day1.model.Dial;
import software.aoc2025.day1.service.DialSecuritySystem;


public class Main {

    public static void main(String[] args) {

        Dial result = new DialSecuritySystem(
                new ContentReader()).resolvePassword(
                new ContentReader().readInput("day1.txt"));

        System.out.println(result);
    }
}
