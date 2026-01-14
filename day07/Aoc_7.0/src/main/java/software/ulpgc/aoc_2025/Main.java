package software.ulpgc.aoc_2025;

import software.ulpgc.aoc_2025.io.InputProvider;
import software.ulpgc.aoc_2025.io.ResourceLoader;
import software.ulpgc.aoc_2025.io.InputParser;
import software.ulpgc.aoc_2025.domain.TachyonMap;
import software.ulpgc.aoc_2025.service.BeamSolver;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        InputProvider loader = new ResourceLoader();
        InputParser parser = new InputParser();
        BeamSolver solver = new BeamSolver();

        // 2. La tubería (Pipeline)
        int resultado = Stream.of("day7.txt")
                .map(loader::readInput)             // Convierte nombre -> Stream de líneas
                .map(parser::parseGrid)             // Convierte líneas -> List<char[]>
                .map(TachyonMap::new)               // Convierte lista -> Objeto TachyonMap
                .map(solver::countSplits)           // Ejecuta la lógica y devuelve el int
                .findFirst()                        // Captura el valor
                .orElse(0);                   // Manejo de error básico

        System.out.println("Resultado de divisiones: " + resultado);
    }
}
