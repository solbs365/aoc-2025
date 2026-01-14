package software.ulpgc.aoc_2025.app;

import software.ulpgc.aoc_2025.model.ElfMap;
import software.ulpgc.aoc_2025.model.TilePosition;

import java.util.List;

import static java.lang.Math.abs;

public class RectangleScanMaxAreaCalculator implements MaxAreaCalculator {

    @Override
    public long findMaxArea(List<TilePosition> tilePositions, ElfMap elfMap) {
        long maxArea = 0;

        for(int i = 0; i< tilePositions.size(); i++){
            for(int j = i+1; j< tilePositions.size(); j++) {

                TilePosition p1 = tilePositions.get(i);
                TilePosition p2 = tilePositions.get(j);

                if (isValidRectangle(p1, p2, elfMap)) {
                    long rectangleArea = calculateArea(p1,p2);

                    if(rectangleArea > maxArea){
                        maxArea = rectangleArea;
                    }
                }
            }
        }
        return maxArea;
    }

    private boolean isValidRectangle(TilePosition p1, TilePosition p2, ElfMap elfMap){

        // Calculamos las dimensiones del rectangulo candidato con las dimensiones iniciales
        double minX = Math.min(p1.x(),  p2.x());
        double minY = Math.min(p1.y(),  p2.y());
        double width = Math.abs(p1.x() - p2.x());
        double height = Math.abs(p1.y() - p2.y());

        // ¿Es valido para nuestro mapa?
        return elfMap.containsRectangle(minX,minY,width,height);
    }

    private static long calculateArea(TilePosition p1, TilePosition p2) {
        return (abs(p1.x() - p2.x()) + 1) * (abs(p2.y() - p1.y()) +1);
    }
}
