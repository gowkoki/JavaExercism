import java.util.*;

class BracketChecker {
    private final String expression;

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketPairs = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );

        for (char c : expression.toCharArray()) {
            if (bracketPairs.containsValue(c)) {
                stack.push(c);
            } else if (bracketPairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
