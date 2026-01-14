package software.aoc2025.day6.solver;

import software.aoc2025.day6.model.Operation;

import java.util.List;

public class OperationSolver {
    
    public static long solve(Operation operation) {

        if(operation.operator().equals("+")){
            return solveSum(operation.nums());
        }
        else{
            return solveMultiplication(operation.nums());
        }
    }

    private static long solveMultiplication(List<Long> nums) {
        long count = 1;
        for(Long num : nums){
            count *= num;
        }
        return count;
    }

    private static long solveSum(List<Long> nums) {
        long count = 0;
        for(Long num : nums){
            count += num;
        }
        return count;
    }


}
