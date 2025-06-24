class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int count = 10;
        int cal = 0;
        int digitCount = 0;

        for (int i = 0; i < stringToVerify.length(); i++) {
            char ch = stringToVerify.charAt(i);

            if (Character.isDigit(ch)) {
                if (count == 0) return false;
                int num = ch - '0';
                cal += num * count;
                count--;
                digitCount++;
            } else if (ch == 'X') {
                if (count != 1) return false;
                cal += 10 * count;
                count--;
                digitCount++;
            } else if (ch != '-' && ch != ' ') {
                return false;
            }
        }

       
        return (cal % 11 == 0 && digitCount == 10);
    }
}
