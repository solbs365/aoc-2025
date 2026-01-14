package software.aoc_2025.day11.io;

import software.aoc_2025.day11.model.Device;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    public Map<String, String[]> parseDevices(Stream<String> lines) {

        return lines.map(this::convertToDevice)
                .collect(Collectors.toMap(Device::name, Device::outputs));
    }

    private Device convertToDevice(String s) {

        String[] outputs = outputDevice(s)
                .trim()
                .split("\\s+");

        return new Device(mainDevice(s), outputs);
    }

    private String mainDevice(String s) {
        return s.substring(0,s.indexOf(":")).trim();
    }

    private String outputDevice(String s) {
        return s.substring(s.indexOf(":")+1);
    }
}
