package software.aoc2025.day6.io;

import software.aoc2025.day6.model.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputParser {


    public static List<String[]> readInputMatrix(Stream<String> lines) {

        return lines
                .filter(i -> !i.isBlank())                          // quitamos lineas que no tienen nada
                .map(String::trim)                                        // quitamos espacios del principio y final
                .map(i -> i.split("\\s+"))
                .toList();
    }

    public static List<Operation> getOperations(List<String[]> matrix) {
        List<Operation> operations = new ArrayList<>();
        
        for(int col = 0; col < matrix.getFirst().length; col++){
            List<String> currentColumn = new ArrayList<>();

            for(int row = 0; row < matrix.size(); row++){
                currentColumn.add(matrix.get(row)[col]);            // Lista de cada columna
            }
             operations.add(buildOperation(currentColumn));
        }
        return operations;
    }

    private static Operation buildOperation(List<String> column) {
        String operatorSymbol = column.getLast();

        // quitar el ultimo elemento (el operador)
        List<String> operands = column.subList(0, column.size() - 1);
        return convertToOperation(operands, operatorSymbol);
    }


    private static Operation convertToOperation(List<String> numbers, String operator) {
        return new Operation(toLong(numbers), operator);
    }

    private static List<Long> toLong(List<String> numbers) {
        List<Long> result = new ArrayList<>();

        for(String num : numbers){
            result.add(Long.parseLong(num));
        }
        return result;
    }


}
