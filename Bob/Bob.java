import java.util.regex.*;
        
class Bob {

    String hey(String input) {
         input = input.trim();
        
        boolean hasLetters = Pattern.compile("[a-zA-Z]").matcher(input).find();
        boolean isShouting = hasLetters && input.equals(input.toUpperCase());
        boolean isQuestion = input.endsWith("?");

        if (input.equals("")) {
            return "Fine. Be that way!";
        } else if (isShouting && isQuestion) {
            return "Calm down, I know what I'm doing!";
        } else if (isQuestion) {
            return "Sure.";
        } else if (isShouting) {
            return "Whoa, chill out!";
        } else {
            return "Whatever.";
        }
    }
}
