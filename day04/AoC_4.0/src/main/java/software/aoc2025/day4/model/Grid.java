package software.aoc2025.day4.model;


public record Grid(char[][] matrix){

    public int rows(){
        return matrix.length;
    }
    public int cols(){
        return matrix[0].length;
    }
    public char valueAt(int row, int col){
        return matrix[row][col];
    }
}
