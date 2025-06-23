class CustomCheckedException extends Exception {
    
    CustomCheckedException() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    CustomCheckedException(String message) {
        super(message);
    }

}
