package software.aoc2025.day5.service;

import software.aoc2025.day5.model.Range;

import java.util.List;
import java.util.Optional;


public class FreshnessValidator {


    public int countFreshIngredients(List<Range> ranges, List<Long> ids){
        int count = 0;
        // ids.forEach(id -> isFresh(id));
        for(Long id: ids){
            if(isFresh(ranges,id)){
                count++;
            }
        }
        return count;
    }

    // metodo que devuelve true si el id es fresco
    private boolean isFresh(List<Range>ranges, Long id) {

        Optional<Range> result = ranges.stream()
                .filter(r -> r.start() <= id && r.end() >= id)
                .findFirst();           // devuelve el primer rango encontrado y no itera innecesariamente para buscar los otros una vez lo encuentre

        if(result.isPresent()) {       // Si encuentra un rango
            return true;
        }
        return false;
    }
}
