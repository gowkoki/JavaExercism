public class LuhnValidator {

    public boolean isValid(String candidate) {
        if (candidate == null) {
            return false;
        }

        String sanitized = candidate.replaceAll("\\s", "");
        if (sanitized.length() < 2 || !sanitized.matches("\\d+")) {
            return false;
        }

        int sum = 0;
        boolean doubleDigit = false;
       
        for (int i = sanitized.length() - 1; i >= 0; i--) {
            int digit = sanitized.charAt(i) - '0';

            if (doubleDigit) {
                digit = digit * 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}
