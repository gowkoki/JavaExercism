class PigLatinTranslator {

    public String translate(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(" ");
            result.append(translateWord(words[i]));
        }

        return result.toString();
    }

    private String translateWord(String word) {
        // Rule 1: starts with vowel, "xr", or "yt"
        if (isVowel(word.charAt(0)) || word.startsWith("xr") || word.startsWith("yt")) {
            return word + "ay";
        }

        // Rule 3a: starts with "qu"
        if (word.startsWith("qu")) {
            return word.substring(2) + "quay";
        }

        // Rule 3b: consonant(s) + "qu" (no vowel before "qu")
        int quIndex = word.indexOf("qu");
        if (quIndex > 0 && noVowelBefore(word, quIndex)) {
            return word.substring(quIndex + 2) + word.substring(0, quIndex + 2) + "ay";
        }

        // Rule 4: consonant(s) followed by "y" and no vowels before y
        int yIndex = word.indexOf("y");
        if (yIndex > 0 && noVowelBefore(word, yIndex)) {
            return word.substring(yIndex) + word.substring(0, yIndex) + "ay";
        }

        // Rule 2: consonant(s) followed by vowel
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                return word.substring(i) + word.substring(0, i) + "ay";
            }
        }

        return word + "ay"; // fallback
    }

    private boolean noVowelBefore(String word, int index) {
        for (int i = 0; i < index; i++) {
            if (isVowel(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
