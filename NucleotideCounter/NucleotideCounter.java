import java.util.*;

class NucleotideCounter {
    private Map<Character, Integer> map;

    NucleotideCounter(String sequence) {
        map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        for(char c : sequence.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                throw new IllegalArgumentException("INVALID");
            }
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return map;
    }

}
