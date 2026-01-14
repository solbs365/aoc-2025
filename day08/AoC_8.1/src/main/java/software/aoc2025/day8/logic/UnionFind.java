package software.aoc2025.day8.logic;

import software.aoc2025.day8.model.Point3D;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    private final Map<Point3D, Point3D> parentMap =  new HashMap<>();
    private final Map<Point3D, Integer> groupSizeMap = new HashMap<>();

    private int groupCount = 0;

    public void makeSet(Point3D p) {
        parentMap.put(p, p);
        groupSizeMap.put(p, 1);
        groupCount++;
    }

    public Point3D find(Point3D p) {

        if(!parentMap.containsKey(p)) return null;

        Point3D root = parentMap.get(p);
        if(root.equals(p)) return root;

        Point3D newValue = find(root);
        parentMap.put(p, newValue);
        return newValue;
    }

    public void union(Point3D p1, Point3D p2) {
        Point3D root1 = find(p1);
        Point3D root2 = find(p2);

        if(root1 == null || root2 == null || root1.equals(root2)){
            return;
        }

        // root2 es el padre de root1
        parentMap.put(root1, root2);

        // Actualizamos el tamaño del grupo
        int newSize = groupSizeMap.get(root1) + groupSizeMap.get(root2);
        groupSizeMap.put(root2, newSize);

        groupCount--;        // Al unir dos grupos, el numero total baja en 1

    }

    public int getGroupCount() {
        return groupCount;
    }

}
