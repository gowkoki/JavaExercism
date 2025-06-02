import java.util.*;

class ResistorColorDuo {
    private final String[] colours = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int indexOf(String color){
        for(int i =0; i<colours.length;i++){
            if(colours[i].equals(color)){
                return i;
            }
        }
        return -1;
    }
    
    int value(String[] colors) {
        if(colors.length < 1){
            return -1;
        }
        
        int first = indexOf(colors[0]);
        int second = colors.length > 1 ? indexOf(colors[1]) : 0;
        
        return (first*10)+second;
    }
}
