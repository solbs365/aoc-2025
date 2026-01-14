package software.aoc2025.day10;

import software.aoc2025.day10.io.ContentReader;
import software.aoc2025.day10.io.InputParser;
import software.aoc2025.day10.model.Machine;
import software.aoc2025.day10.solver.MachineSolver;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        MachineSolver machineSolver = new MachineSolver();
        ContentReader reader = new ContentReader();
        InputParser parser = new InputParser();


        Stream<String> lines = reader.readInput("day10.txt");

        List<Machine> machines = parser.parseMachines(lines);


        for(int i = 0; i < machines.size(); i++) {
            Machine machine = machines.get(i);

            int[] initialVoltages = new int[machine.voltages().size()];
            int total = machineSolver.solveVoltages(0,initialVoltages, machine);
            System.out.println(total);
        }

    }
}
