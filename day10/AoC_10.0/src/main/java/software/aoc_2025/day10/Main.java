package software.aoc_2025.day10;

import software.aoc_2025.day10.io.ContentReader;
import software.aoc_2025.day10.io.InputParser;
import software.aoc_2025.day10.model.Button;
import software.aoc_2025.day10.model.Machine;
import software.aoc_2025.day10.solver.MachineSolver;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        MachineSolver machineSolver = new MachineSolver();
        ContentReader reader = new ContentReader();
        Stream<String> x = reader.readInput("day10.txt");
        InputParser parser = new InputParser();

        // 2. Parseamos la entrada
        List<Machine> machines = parser.parseMachines(x);

        // 3. Resolvemos cada máquina
        for (int i = 0; i < machines.size(); i++) {
            Machine machine = machines.get(i);

            // El estado inicial de las luces: un array de false (todas apagadas)
            boolean[] initialLights = new boolean[machine.diagramLights().length];

            // Llamamos a la lógica recursiva
            int result = machineSolver.calculateMinPulses(0, initialLights, machine);

            // 4. Mostramos el resultado de forma elegante
            System.out.print("Máquina #" + (i + 1) + ": ");
            if (result >= 100_000_000) {
                System.out.println("No tiene solución.");
            } else {
                System.out.println("Mínimo de pulsaciones = " + result);
            }
        }

        int total = machineSolver.solveAll(machines);
        System.out.println(total);

    }
}
