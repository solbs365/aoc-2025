package software.aoc2025.day9.app;

import software.aoc2025.day9.model.Position;

import java.util.List;

import static java.lang.Math.abs;

public class RectangleSolver implements AreaSolver{

    public long findMaxArea(List<Position> positions){
        long maxArea = 0;

        for(int i=0;i<positions.size();i++){                // posicion
            for(int j=i+1;j<positions.size();j++) {          // siguiente posicion

                Position p1 = positions.get(i);
                Position p2 = positions.get(j);

                long rectangleArea = calculateArea(p1,p2);

                if(rectangleArea > maxArea){
                    maxArea = rectangleArea;
                }
            }

        }
        return maxArea;
    }

    private static long calculateArea(Position p1, Position p2) {
        return (abs(p1.x() - p2.x()) + 1) * (abs(p2.y() - p1.y()) +1);
    }
}
