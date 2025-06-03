class ResistorColorTrio {
     private final String[] colours = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    
    String label(String[] colors) {
        int first = indexOf(colors[0]);
        int second = indexOf(colors[1]);
        int third = indexOf(colors[2]);

        if(first == -1 || second == -1 || third == -1){
            throw new IllegalArgumentException("Invalid Input");
        }
        long value = (first * 10 + second) * (long) Math.pow(10,third);
        
        if (value >= 1_000_000_000L) {
            return (value / 1_000_000_000) + " gigaohms";
        } else if (value >= 1_000_000) {
            return (value / 1_000_000) + " megaohms";
        } else if (value >= 1_000) {
            return (value / 1_000) + " kiloohms";
        } else {
            return value + " ohms";
        }
    }

    int indexOf(String color){
        for(int i =0; i<colours.length;i++){
            if(colours[i].equals(color)){
                return i;
            }
        }
        return -1;
    }
}
