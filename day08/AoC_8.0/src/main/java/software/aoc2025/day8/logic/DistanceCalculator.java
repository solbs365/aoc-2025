package software.aoc2025.day8.logic;


import software.aoc2025.day8.model.Point3D;


public class DistanceCalculator {
    public static long calculate(Point3D p1, Point3D p2) {

        return (long) (p2.x() - p1.x()) * (p2.x() - p1.x()) +
                (long) (p2.y() - p1.y()) * (p2.y() - p1.y()) +
                (long) (p2.z() - p1.z()) * (p2.z() - p1.z());
    }

}
