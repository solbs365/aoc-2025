package software.ulpgc.aoc_2025.service;

import software.ulpgc.aoc_2025.domain.Position;
import software.ulpgc.aoc_2025.domain.TachyonMap;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BeamSolver {

    public int countSplits(TachyonMap grid){

        int count = 0;

        // Posición en la que empieza (dependiendo de donde encuentre la S)
        Position start = grid.findStart();

        Stack<Position> stack = new Stack<>();
        Set<Position> visitedNodes = new HashSet<>();

        stack.push(start);
        visitedNodes.add(start);

        while(!stack.isEmpty()){
            // quitamos de la pila
            Position p = stack.pop();

            // Miramos que simbolo tenia el que acabamos de quitar ("S", ".", "^")
            char symbol = grid.getSymbol(p);

            if(symbol == '^'){
                count++;
                splitBeam(p, grid, stack, visitedNodes);
            }

            else {
                // symbol = "." or "S"
                advanceBeam(p, grid, stack, visitedNodes);
            }
        }
        return count;
    }

    private void advanceBeam(Position p, TachyonMap map, Stack<Position> stack, Set<Position> visitedNodes) {
        Position down = new Position(p.row()+1,  p.col());

        if(!visitedNodes.contains(down) && map.isInside(down)){
            stack.push(down);
            visitedNodes.add(down);
        }
    }

    private void splitBeam(Position p, TachyonMap map, Stack<Position> stack, Set<Position> visitedNodes) {
        // creamos la posicion de la izq, y de la dcha -> serian los vecinos
        Position izq = new Position(p.row(),  p.col()-1);
        Position dcha = new Position(p.row(),  p.col()+1);


        if(!visitedNodes.contains(izq) && map.isInside(izq)){
            stack.push(izq);
            visitedNodes.add(izq);
        }

        if(!visitedNodes.contains(dcha) && map.isInside(dcha)) {

            stack.push(dcha);
            visitedNodes.add(dcha);
        }
    }

}
