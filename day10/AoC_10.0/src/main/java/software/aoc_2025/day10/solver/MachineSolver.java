package software.aoc_2025.day10.solver;

import software.aoc_2025.day10.model.Button;
import software.aoc_2025.day10.model.Machine;

import java.util.Arrays;
import java.util.List;

public class MachineSolver {
    private static final int IMPOSSIBLE = 100_000_000;

    public int solveAll(List<Machine> machines) {
        int totalSum = 0;
        for (Machine machine : machines) {
            boolean[] initialLights = new boolean[machine.diagramLights().length];
            int result = calculateMinPulses(0, initialLights, machine);

            if (result < IMPOSSIBLE) {
                totalSum += result;
            }
        }
        return totalSum;
    }

    public int calculateMinPulses(int buttonIndex, boolean[] currentLights, Machine machine){

        // Caso Base: si ya hemos llegado al final
        if(buttonIndex == machine.buttons().size()){
            if(Arrays.equals(currentLights, machine.diagramLights())){
                return 0;
            }
            return IMPOSSIBLE;
        }

        // Opcion A: si NO se pulsa este boton
        int nonPressesButton = calculateMinPulses(buttonIndex+1, currentLights, machine);

        // Opcion B: si se pulsa este boton/ aplicar logica del cambio
        boolean[] copyOfLights = currentLights.clone();
        boolean[] changedLights = buttonAplication(copyOfLights, machine.buttons().get(buttonIndex));

        // se suma 1 a la llamada recursiva, para incrementar el contador
        int result = calculateMinPulses(buttonIndex+1, changedLights, machine);

        int pressesButton;
        if(result >= IMPOSSIBLE){
            pressesButton = IMPOSSIBLE;
        }
        else{
            pressesButton = 1 + result;
        }
        return Math.min(nonPressesButton, pressesButton);       // Nos quedamos con el mejor
    }

    private boolean[] buttonAplication(boolean[] currentLights, Button button) {
        // itero por cada uno de los botones -> 1 ,2, 3...
        for(Integer indexLight : button.buttonsWiring()){
            currentLights[indexLight] = !currentLights[indexLight];
        }
        return currentLights;
    }
}
