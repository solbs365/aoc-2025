package software.ulpgc.aoc_2025.domain;

import java.util.List;

public class TachyonMap {

    private final List<char[]> grid;

    public TachyonMap(List<char[]> grid) {
        this.grid = grid;
    }

    // Recibe una Position y comprueba si esta dentro del grid
    public boolean isInside(Position pos) {

        return (pos.row() < grid.size() && pos.col() < grid.get(0).length &&
                pos.row() >= 0 && pos.col() >= 0);
    }

    public Position findStart(){

        for(int i=0; i < grid.size();  i++){
            for(int j=0; j < grid.getFirst().length; j++){
                if(grid.get(i)[j] == 'S'){
                    return new Position(i, j);
                }
            }
        }
        throw new RuntimeException("S not found in Map");
    }

    public char getSymbol(Position pos){
        return grid.get(pos.row())[pos.col()];
    }

}
