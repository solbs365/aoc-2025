package software.ulpgc.aoc2025.service;

import software.ulpgc.aoc2025.model.Range;

import java.util.*;

import static java.lang.Math.min;


public class FreshnessValidator {

    // Metodo que devuelve cuantos ids son frescos
    public long countFreshIngredients(List<Range> ranges){

        List<Range> rangesCopy = new ArrayList<>(ranges);
        rangesCopy.sort((r1, r2) -> Long.compare(r1.start(), r2.start()));

        long currentStartRange = rangesCopy.getFirst().start();
        long currentEndRange = rangesCopy.getFirst().end();
        long total = 0;

        for(Range r : rangesCopy.stream().skip(1).toList()){

            // si se solapan
            if(currentEndRange >= r.start()){
                currentEndRange = Math.max(currentEndRange, r.end());
            }

            // si no se solapan
            else{
                total += currentEndRange - currentStartRange +1;
                currentStartRange = r.start();
                currentEndRange = r.end();
            }
        }
        total += currentEndRange - currentStartRange +1;
        return total;
    }

}


