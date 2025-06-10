class MicroBlog {
    public String truncate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        int codePointCount = input.codePointCount(0, input.length());
        if (codePointCount <= 5) {
            return input;
        }

        int endIndex = input.offsetByCodePoints(0, 5);
        return input.substring(0, endIndex);
    }
}
