package software.aoc_2025.day10;

import software.aoc_2025.day10.io.ContentReader;
import software.aoc_2025.day10.io.InputParser;
import software.aoc_2025.day10.model.Machine;
import software.aoc_2025.day10.solver.MachineSolver;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Machine> machines = new InputParser()
                .parseMachines(new ContentReader()
                        .readInput("day10.txt"));

        for (int i = 0; i < machines.size(); i++) {
            Machine machine = machines.get(i);

            // El estado inicial de las luces: (todas apagadas)
            boolean[] initialLights = new boolean[machine.diagramLights().length];

            int result = new MachineSolver().calculateMinPulses(0, initialLights, machine);

        }

        int total = new MachineSolver().solveAll(machines);
        System.out.println(total);

    }
}
