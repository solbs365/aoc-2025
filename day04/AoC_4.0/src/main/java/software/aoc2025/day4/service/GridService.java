package software.aoc2025.day4.service;

import software.aoc2025.day4.model.Grid;
import software.aoc2025.day4.model.Position;

public class GridService {


    public int solve(Grid grid) {
        int total = 0;
        for(int row = 0; row < grid.rows(); row++){
            for(int col = 0; col < grid.cols(); col++){

                if(grid.valueAt(row,col) == '@'){
                    total += countAccesibles(hasAccesibleNeighbors(grid, new Position(row, col)));
                }
            }
        }
        return total;

    }

    // Devuelve true si un rollo de papel es accesible
    public boolean hasAccesibleNeighbors(Grid grid, Position pos) {
        // direcciones: arriba, abajo, izq, dcha, diagIzqArriba, diagIzqAbajo, diagDchArriba, diagDchAbajo
        int[] dRows = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dCols = {0, 0, -1, 1, -1, -1, 1, 1};
        int count = 0;

        for (int i=0; i<8; i++){
            int rowsNeighbors = pos.row() + dRows[i];
            int colsNeighbors = pos.col() + dCols[i];

            if(isBounds(grid, rowsNeighbors, colsNeighbors)){
                if(grid.valueAt(rowsNeighbors, colsNeighbors) == '@'){
                    count ++;
                }
            }

        }
        return isAccessible(count);
    }

    public int countAccesibles(boolean accessible) {
        int c = 0;
        if(accessible){
            c ++;
        }
        return c;
    }

    private boolean isAccessible(int n){
        if(n >= 4){
            return false;
        }
        return true;
    }

    private boolean isBounds(Grid grid, int rowsNeighbors, int colsNeighbors) {
        if(rowsNeighbors < 0 || colsNeighbors < 0 || rowsNeighbors >= grid.rows()|| colsNeighbors >= grid.cols()){
            return false;
        }
        return true;
    }
}
