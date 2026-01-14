package software.ulpgc.aoc_2025.model;

import java.awt.geom.Path2D;
import java.util.List;

public class ElfMap {

    private final Path2D.Double grid;

    public ElfMap(List<TilePosition> corners) {
        this.grid = new Path2D.Double();
        buildGrid(corners);
    }

    private void buildGrid(List<TilePosition> corners) {

        TilePosition first = corners.get(0);
        grid.moveTo(first.x(), first.y());

        for(int i = 1; i < corners.size(); i++) {
            TilePosition second = corners.get(i);
            // Dibuja una linea desde donde estoy hasta el nuevo punto
            grid.lineTo(second.x(), second.y());
        }
        grid.closePath();
    }

    public boolean containsRectangle(double x, double y, double width, double height) {
        // Le preguntamos a la libreria si cabe
        return grid.contains(x, y, width, height);
    }
}
