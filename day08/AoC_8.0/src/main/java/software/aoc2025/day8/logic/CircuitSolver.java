package software.aoc2025.day8.logic;

import software.aoc2025.day8.model.Connection;
import software.aoc2025.day8.model.Point3D;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircuitSolver {

    public long solve(List<Point3D> points) {
        // Obtener y filtrar las 1000 mejores conexiones
        List<Connection> connections = findBestConnections(points);
        List<Connection> best = topConnections(connections);

        // Agrupar los puntos (Union-Find)
        UnionFind unionFind = new UnionFind();
        points.forEach(unionFind::makeSet);
        best.forEach(c -> unionFind.union(c.first(), c.second()));

        // Calcular resultado: Multiplicar los 3 grupos más grandes
        return unionFind.getAllGroupSizes().stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(i -> i)
                .reduce(1, (a, b) -> a * b);
    }

    private List<Connection> topConnections(List<Connection> connections) {

        return connections.stream()
                .sorted(Comparator.comparingLong(Connection::distance))
                .limit(1000)
                .toList();
    }


    private List<Connection> findBestConnections(List<Point3D> points){

        List<Connection> connections = new ArrayList<>();

        for(int i=0;i<points.size();i++){
            for(int j= i+1; j<points.size();j++){

                Point3D p1 = points.get(i);
                Point3D p2 = points.get(j);

                long distance = DistanceCalculator.calculate(p1, p2);
                Connection connection = new Connection(p1, p2, distance);
                connections.add(connection);
            }
        }
        return connections;
    }

}

