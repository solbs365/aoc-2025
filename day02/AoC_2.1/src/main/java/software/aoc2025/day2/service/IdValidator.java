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

        if(isRepeatedSequence(id)) return false;
        return true;
    }

    private static boolean isRepeatedSequence(String id){
        int n = id.length();

        // Probamos todos los posibles tamaños de bloque (i)
        // El bloque más grande posible es la mitad del ID
        for(int i=1; i<=n /2; i++){

            if(n % i == 0){
                String pattern = id.substring(0, i);
                int factor = n / i;

                // Creamos la cadena repetida y comparamos
                if(pattern.repeat(factor).equals(id)){
                    return true;
                }
            }
        }
        return false;
    }
}
