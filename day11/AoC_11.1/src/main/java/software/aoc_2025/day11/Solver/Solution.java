package software.aoc_2025.day11.Solver;

import java.util.*;

public class Solution {
    private Map<String, Long> memo = new HashMap<>();

    public long countPaths(String start, String end, Map<String, String[]> connections, boolean foundDac, boolean foundFft, Set<String> visited) {

        if(start.equals("dac")) foundDac = true;
        if(start.equals("fft")) foundFft = true;

        String key = start + "|" + foundDac + "|" + foundFft;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Caso base: start = end  (out)
        if(start.equals(end)){
            // Solo contamos este camino como valido si hemos visto los dos
            if(foundDac && foundFft){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(visited.contains(start))return 0;
        visited.add(start);

        // Si no hay mas salidas desde aqui, este camino no sirve
        String[] outputs = connections.get(start);
        long total = 0;

        if(outputs != null){
            for(String next: outputs){
                total += countPaths(next, end, connections, foundDac, foundFft, new HashSet<>(visited));
            }
        }
        memo.put(key, total);
        return total;
    }
}
