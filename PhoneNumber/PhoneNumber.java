class PhoneNumber {
    private final String number;

    PhoneNumber(String numberString) {
        StringBuilder result = new StringBuilder();

        for (char c : numberString.toCharArray()) {
            if (Character.isLetter(c)) {
                throw new IllegalArgumentException("letters not permitted");
            } else if (Character.isDigit(c)) {
                result.append(c);
            } else if (!Character.isWhitespace(c) && "()-.+".indexOf(c) == -1) {
                throw new IllegalArgumentException("punctuations not permitted");
            }
        }

        String digits = result.toString();

        if (digits.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        } else if (digits.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        } else if (digits.length() == 11) {
            if (digits.charAt(0) == '1') {
                digits = digits.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }

        if (digits.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (digits.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (digits.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (digits.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }

        this.number = digits;
    }

    String getNumber() {
        return this.number;
    }
}
