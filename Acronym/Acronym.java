class Acronym {

    private final StringBuilder acronym;

    Acronym(String phrase) {
        acronym = new StringBuilder();
        phrase = phrase.replace('-', ' ').toUpperCase();
        String[] words = phrase.split(" ");

        for (String word : words) {
            word = word.trim();
            
            if (word.isEmpty()) continue;
           
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    acronym.append(c);
                    break; 
                }
            }
        }
    }

    String get() {
        return acronym.toString();
    }
}
