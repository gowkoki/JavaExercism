import java.util.*;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        phrase = phrase.toLowerCase();
        Set<Character> set = new HashSet<>();
        
        for(char c : phrase.toCharArray()){
            if(Character.isLetter(c)){
                if(!set.add(c)){
                    return false;
                }
            }
        }
        return true;
    }

}
