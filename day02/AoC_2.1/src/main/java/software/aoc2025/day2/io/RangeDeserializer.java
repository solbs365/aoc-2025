package software.aoc2025.day2.io;

import software.aoc2025.day2.model.Range;


public class RangeDeserializer {

    // metodo para separar la String que me pasan por parametro
    public static String[] tokenize(String str) {
        return str.split(",");
    }


    public static Range convertTextToRange(String s){

        int hyphenSeparator = s.indexOf("-");

        long firstRange = toLong(s.substring(0, hyphenSeparator));
        long lastRange = toLong(s.substring(hyphenSeparator + 1));

        return createRange(firstRange, lastRange);
    }


    private static Range createRange(long start, long end) {
        return new Range(start, end);
    }

    public static Long toLong(String s) {
        return Long.parseLong(s);
    }

}
