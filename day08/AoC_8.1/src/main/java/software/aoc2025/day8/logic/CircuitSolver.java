package software.aoc2025.day8.logic;

import software.aoc2025.day8.model.Connection;
import software.aoc2025.day8.model.Point3D;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircuitSolver {

    public long solve(List<Point3D> points) {

        List<Connection> allConnections = findBestConnections(points);
        allConnections.sort(Comparator.comparingLong(Connection::distance));

        UnionFind unionFind = new UnionFind();
        points.forEach(unionFind::makeSet);

        for (Connection connection : allConnections) {

            if (unionFind.find(connection.first()).equals(unionFind.find(connection.second()))) {
                continue;
            }

            // Si no estaban conectados, los unimos
            unionFind.union(connection.first(), connection.second());


            if (unionFind.getGroupCount() == 1) {
                long x1 = connection.first().x();
                long x2 = connection.second().x();
                return x1 * x2;
            }
        }

        return 0; // No debería llegar aquí si el grafo se puede conectar
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

