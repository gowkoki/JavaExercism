import java.util.*;

public class PangramChecker {

    public boolean isPangram(String input) {
        input = input.toLowerCase();
        Set<Character> set = new HashSet<>();
        
        for(int i =0;i <input.length();i++){
            if(Character.isLetter(input.charAt(i))){
                set.add(input.charAt(i));
            }
        }
        return set.size() == 26;
    }

}
