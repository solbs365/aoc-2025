package software.ulpgc.aoc_2025.service;

import software.ulpgc.aoc_2025.domain.Position;
import software.ulpgc.aoc_2025.domain.TachyonMap;

import java.util.*;

public class BeamSolver {

    private Map<Position, Long> path = new HashMap<>();

    public long countSplits(Position pos, TachyonMap grid) {

        // Si ya está almacenado, devolver numero
        if (path.containsKey(pos)) {
            return path.get(pos);
        }

        // si se sale del mapa, terminamos
        if (!grid.isInside(pos)) {
            return 1;
        }

        long result;
        char symbol = grid.getSymbol(pos);

        if (symbol == '^') {

            long izq = countSplits(new Position(pos.row(), pos.col() - 1), grid);
            long der = countSplits(new Position(pos.row(), pos.col() + 1), grid);
            result = izq + der;
        } else {
            result = countSplits(new Position(pos.row() + 1, pos.col()), grid);
        }
        path.put(pos, result);
        return result;
    }
}
