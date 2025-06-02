class ResistorColor {
    private final String[] colours = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    
    int colorCode(String color) {
        for(int i =0; i < colours.length; i++){
            if(colours[i].equals(color)){
                return i;
            }
        }
        return -1;
    }

    String[] colors() {
       return this.colours;
    }
}
