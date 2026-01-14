package software.aoc2025.day12.service;

import software.aoc2025.day12.model.GiftShape;
import software.aoc2025.day12.model.RegionProblem;

import java.util.List;

public class GiftService {


    public boolean canFitAll(RegionProblem region, List<GiftShape> allShapes) {
        // 1. PODA POR ÁREA (Heurística rápida)
        // Si la suma de bloques '#' de los regalos es mayor que el área total, ni lo intentamos.
        int totalRequiredArea = region.getGiftsToPlace().stream()
                .mapToInt(id -> countBlocks(allShapes.get(id)))
                .sum();
        if (totalRequiredArea > (region.width() * region.height())) return false;

        boolean[][] board = new boolean[region.height()][region.width()];

        // 2. ORDENACIÓN (Heurística de dificultad)
        // Ordenamos los regalos de mayor a menor tamaño.
        // Es mucho más eficiente colocar las piezas "grandes" y "difíciles" primero.
        List<List<GiftShape>> targets = region.getGiftsToPlace().stream()
                .map(id -> allShapes.stream().filter(s -> s.id() == id).findFirst().get().getAllOrientations())
                .sorted((a, b) -> Integer.compare(countBlocks(b.get(0)), countBlocks(a.get(0))))
                .toList();

        return backtrack(board, targets, 0, totalRequiredArea);
    }

    private boolean backtrack(boolean[][] board, List<List<GiftShape>> targets, int index, int remainingArea) {
        if (index == targets.size()) return true;

        // 3. PODA POR ESPACIO RESTANTE
        // Si el área libre del tablero es menor que lo que nos queda por poner, fallamos rápido.
        if (countFreeSpace(board) < remainingArea) return false;

        for (GiftShape orientation : targets.get(index)) {
            int shapeArea = countBlocks(orientation);
            for (int y = 0; y <= board.length - orientation.height(); y++) {
                for (int x = 0; x <= board[0].length - orientation.width(); x++) {
                    if (canPlace(board, orientation, x, y)) {
                        place(board, orientation, x, y, true);
                        if (backtrack(board, targets, index + 1, remainingArea - shapeArea)) return true;
                        place(board, orientation, x, y, false);
                    }
                }
            }
        }
        return false;
    }

    // Métodos auxiliares para la lógica de conteo
    private int countBlocks(GiftShape s) {
        int count = 0;
        for (boolean[] row : s.grid()) for (boolean val : row) if (val) count++;
        return count;
    }

    private int countFreeSpace(boolean[][] board) {
        int count = 0;
        for (boolean[] row : board) for (boolean val : row) if (!val) count++;
        return count;
    }

    private boolean canPlace(boolean[][] board, GiftShape s, int x, int y) {
        for (int i = 0; i < s.height(); i++) {
            for (int j = 0; j < s.width(); j++) {
                if (s.grid()[i][j] && board[y + i][x + j]) return false;
            }
        }
        return true;
    }

    private void place(boolean[][] board, GiftShape s, int x, int y, boolean state) {
        for (int i = 0; i < s.height(); i++) {
            for (int j = 0; j < s.width(); j++) {
                if (s.grid()[i][j]) board[y + i][x + j] = state;
            }
        }
    }
}