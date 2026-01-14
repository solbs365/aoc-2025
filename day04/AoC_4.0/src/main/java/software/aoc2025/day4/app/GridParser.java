package software.aoc2025.day4.app;

import software.aoc2025.day4.model.Grid;

import java.util.List;


public class GridParser {

    public static List<String> stringList(String line){

        return line.lines()
                .map(String::trim)
                .toList();
    }

    private static int numRows(List<String> lines){
        return lines.size();
    }

    private static int numCols(List<String> lines){
        return lines.getFirst().length();
    }

    public static Grid createGrid(List<String> lines){
        char[][] matrix = new char[numRows(lines)][numCols(lines)];

        for(int i = 0; i < lines.size(); i++){
            matrix[i] = lines.get(i).toCharArray();
        }

        return new Grid(matrix);
    }
}
