import java.util.*;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        Set<Integer> excludedSet = new HashSet<>(exclude);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, cageSum, cageSize, new ArrayList<>(), result, excludedSet);
        return result;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }

    private void backtrack(int start, int remainingSum, int remainingSize, List<Integer> current, List<List<Integer>> result, Set<Integer> excluded) {
        if (remainingSum < 0 || remainingSize < 0) return;
        if (remainingSum == 0 && remainingSize == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (excluded.contains(i)) continue;
            current.add(i);
            backtrack(i + 1, remainingSum - i, remainingSize - 1, current, result, excluded);
            current.remove(current.size() - 1);
        }
    }

}
