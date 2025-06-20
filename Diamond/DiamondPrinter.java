import java.util.*;

class DiamondPrinter {

    private int length;

    List<String> printToList(char a) {
    List<String> result = new ArrayList<>();

    if (a == 'A') {
        result.add("A");
        return result;
    }

    this.length = (a - 'A') * 2;

    List<String> topHalf = new ArrayList<>();

    for (int i = 0; i <= length / 2; i++) {
        char currentChar = (char) ('A' + i);
        String row = rowCreate(currentChar, i);
        topHalf.add(row);
    }
    
    result.addAll(topHalf);
    
    for (int i = topHalf.size() - 2; i >= 0; i--) {
        result.add(topHalf.get(i));
    }

    return result;
}


    private String rowCreate(char c, int offset) {
        int width = length + 1;
        StringBuilder row = new StringBuilder(" ".repeat(width));
        int center = length / 2;

        row.setCharAt(center - offset, c);
        if (offset != 0) {
            row.setCharAt(center + offset, c);
        }

        return row.toString();
    }
}
