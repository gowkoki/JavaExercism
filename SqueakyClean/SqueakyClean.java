class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < identifier.length(); i++) {
            char ch = identifier.charAt(i);

              if (ch == ' ') {
                str.append('_');
            } else if(ch == '-'){str.append(Character.toUpperCase(identifier.charAt(++i)));
            }else if (ch == '4') {
                str.append('a');
            } else if (ch == '3') {
                str.append('e');
            } else if (ch == '0') {
                str.append('o');
            } else if (ch == '1') {
                str.append('l');
            } else if (ch == '7') {
                str.append('t');
            } else if (Character.isLetter(ch)) {
                str.append(ch);
            }
        }

        return str.toString();
    }
}
