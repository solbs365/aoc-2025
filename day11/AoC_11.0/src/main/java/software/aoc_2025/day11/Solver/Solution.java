package software.aoc_2025.day11.Solver;

import java.util.Arrays;
import java.util.Map;

public class Solution {
    
    public int countPaths(String start, String end, Map<String, String[]> connections){

        // Caso base: start = end  (out)
        if(start.equals(end)){
            return 1;
        }

        // Si no hay mas salidas desde aqui, este camino no sirve
        String[] outputs = connections.get(start);
        if(outputs == null){
            return 0;
        }

        return Arrays.stream(outputs)
                .mapToInt(s -> countPaths(s, end, connections))
                .sum();
    }
}
