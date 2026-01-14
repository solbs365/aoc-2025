package software.aoc2025.day10.solver;


import software.aoc2025.day10.model.Machine;

public class MachineSolver {

    private static final int IMPOSSIBLE = 100_000_000;

    public int solveVoltages(int buttonIdx, int[] current, Machine machine) {
        if (buttonIdx == machine.buttons().size()) {
            for (int i = 0; i < current.length; i++) {
                if (current[i] != machine.voltages().get(i)) return IMPOSSIBLE;
            }
            return 0;
        }

        int bestResult = IMPOSSIBLE;

        for (int presses = 0; presses <= 15; presses++) {
            int[] next = current.clone();

            for (int i = 0; i < presses; i++) {
                for (int pos : machine.buttons().get(buttonIdx).buttonsWiring()) {
                    next[pos]++;
                }
            }

            int result = solveVoltages(buttonIdx + 1, next, machine);

            if (result != IMPOSSIBLE) {
                bestResult = Math.min(bestResult, presses + result);
            }
        }
        return bestResult;
    }
}
