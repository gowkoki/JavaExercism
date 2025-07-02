import java.util.*;

class RotationalCipher {
    private Map<Character, Character> upperMap = new HashMap<>();
    private Map<Character, Character> lowerMap = new HashMap<>();

    RotationalCipher(int shiftKey) {
        shiftKey = shiftKey % 26; 

        for (char c = 'A'; c <= 'Z'; c++) {
            char rotated = (char) ('A' + (c - 'A' + shiftKey) % 26);
            upperMap.put(c, rotated);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            char rotated = (char) ('a' + (c - 'a' + shiftKey) % 26);
            lowerMap.put(c, rotated);
        }
    }

    String rotate(String data) {
        StringBuilder result = new StringBuilder();

        for (char c : data.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(upperMap.getOrDefault(c, c));
            } else if (Character.isLowerCase(c)) {
                result.append(lowerMap.getOrDefault(c, c));
            } else {
                result.append(c); 
            }
        }

        return result.toString();
    }
}
