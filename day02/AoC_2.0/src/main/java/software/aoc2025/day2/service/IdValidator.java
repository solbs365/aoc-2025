package software.aoc2025.day2.service;

import software.aoc2025.day2.model.Range;


public class IdValidator {

    public static long calculate(Range range){
        long total = 0;
        for(long i= range.startId();i<=range.endId();i++){
            if(!isValid(toString(i))){
                total += i;
            }
        }
        return total;
    }

    private static String toString(long i) {
        return Long.toString(i);
    }

    private static boolean isValid(String id) {

        if(id.length()%2 != 0){
            return true;   // si es impar, es valido
        }
        if(isRepeatedSequence(id)) return false;
        return true;
    }

    private static boolean isRepeatedSequence(String id){
        int idHalfLength = id.length()/2;

        String firstPartId = id.substring(0, idHalfLength);
        String secondPartId = id.substring(idHalfLength);

        return firstPartId.equals(secondPartId); // devuelve true si la secuencia está repetida
    }

}
