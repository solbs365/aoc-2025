package software.ulpgc.aoc2025.model;


import java.util.*;

public class Grid {

    private final char[][] matrix;

    public Grid(char[][] matrix) {
        this.matrix = matrix;
    }

    // Devuelve cuantos son accesibles
    public int solve() {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '@') {
                    total += bfs(row, col);
                }
            }
        }
        return total;

    }

    // Devuelve true si un rollo de papel es accesible (menos de 4 vecinos)
    public boolean hasAccesibleNeighbors(Position pos) {
        // direcciones: arriba, abajo, izq, dcha, diagIzqArriba, diagIzqAbajo, diagDchArriba, diagDchAbajo
        int[] dRows = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dCols = {0, 0, -1, 1, -1, -1, 1, 1};
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int rowsNeighbors = pos.row() + dRows[i];
            int colsNeighbors = pos.col() + dCols[i];

            if (isBounds(rowsNeighbors, colsNeighbors)) {
                if (matrix[rowsNeighbors][colsNeighbors] == '@') {
                    count++;
                }
            }

        }
        return isAccessible(count);
    }

    public int countAccesibles(boolean accessible) {
        int c = 0;
        if (accessible) {
            c++;
        }
        return c;
    }

    private boolean isAccessible(int n) {
        if (n >= 4) {
            return false;
        }
        return true;
    }

    private boolean isBounds(int rowsNeighbors, int colsNeighbors) {
        if (rowsNeighbors < 0 || colsNeighbors < 0 || rowsNeighbors >= matrix.length || colsNeighbors >= matrix[0].length) {
            return false;
        }
        return true;
    }

    // PARTE 2 -> solucion a partir de aqui...

    // BFS -> No hace falta la lista de visited, porque los que visitamos ya lo marcamos con una x
    public int bfs(int row, int col) {
        Queue<Position> queue = new LinkedList<>();
        int count = 0;

        if(matrix[row][col] == '@' && hasAccesibleNeighbors(new Position(row, col))) {
            queue.add(new Position(row, col));
            matrix[row][col] = 'x';
            count++;
        }

        while (!queue.isEmpty()) {
            Position v = queue.poll();

            // Recorremos los vecinos de v
            for (Position w: neighborsOf(v)) {
                if (matrix[w.row()][w.col()] == '@' && hasAccesibleNeighbors(w)) {
                    queue.offer(w);
                    matrix[w.row()][w.col()] = 'x';
                    count++;
                }
            }
        }
        return count;
    }

    // Para ver todos los vecinos de una posicion
    private List<Position> neighborsOf(Position pos) {
        // direcciones: arriba, abajo, izq, dcha, diagIzqArriba, diagIzqAbajo, diagDchArriba, diagDchAbajo
        int[] dRows = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dCols = {0, 0, -1, 1, -1, -1, 1, 1};
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int rowsNeighbors = pos.row() + dRows[i];
            int colsNeighbors = pos.col() + dCols[i];

            if (isBounds(rowsNeighbors, colsNeighbors)) {
                positions.add(new Position(rowsNeighbors, colsNeighbors));
            }
        }
        return positions;
    }
}
