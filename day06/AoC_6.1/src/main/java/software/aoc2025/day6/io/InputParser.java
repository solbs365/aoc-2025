package software.aoc2025.day6.io;

import software.aoc2025.day6.model.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    // lee linea por linea para almacenar en una Lista
    public static List<String> readInputMatrix(Stream<String> lines) {

        return lines
                .filter(i -> !i.isBlank())                          // quitamos lineas que no tienen nada
                .toList();
    }

    // Conseguimos el tamaño de la linea mas grande
    public static int maxWidth(List<String> rawLines) {
        return rawLines
                .stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    // Recorremos la lista para rellenar cada linea con espacios hasta maxWidth
    public static List<String[]> prepareMatrix(List<String> rawLines) {

        List<String[]> listSeparatedByDigits = new ArrayList<>();
        int maxWidth = maxWidth(rawLines);

        for(String line: rawLines){
            while(line.length() < maxWidth){
                // rellenamos
                line += " ";
            }
            String[] x = line.split("");
            listSeparatedByDigits.add(x);
        }
        return listSeparatedByDigits;           // [ ["0", "2",..], ["1", "", "4"], ["5", "", ""] ]
    }

    public static List<Operation> getOperations(List<String[]> matrix) {
        List<Operation> operations = new ArrayList<>();
        List<List<String>> acumulator = new ArrayList<>();

        for(int col = matrix.getFirst().length -1; col >= 0; col--){
            List<String> currentColumn = new ArrayList<>();

            for(int row = 0; row < matrix.size(); row++){
                currentColumn.add(matrix.get(row)[col]);            // Lista de cada columna
            }

            // comprobamos si no es un espacio (para poder almacenar mas columnas, No de una en una)
            if(!currentColumn.stream().allMatch(s -> s.equals(" "))){
                acumulator.add(currentColumn);
            }
            else{
                // Encontramos un " " por lo que acabamos de leer la operación completa
                operations.add(buildOperation(acumulator));
                acumulator.clear();
            }

        }
        operations.add(buildOperation(acumulator));
        return operations;
    }


    private static Operation buildOperation(List<List<String>> columns) {
        String operatorSymbol = "";
        List<String> operands =  new ArrayList<>();

        for(List<String> col : columns){
            operatorSymbol = col.getLast();

            // quitar el ultimo elemento (el operador)
            List<String> digits = col.subList(0, col.size() - 1);
            String fullNumber = String.join("", digits).trim();
            operands.add(fullNumber);
        }

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
