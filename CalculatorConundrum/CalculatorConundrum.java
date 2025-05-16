class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int cal = 0;

        switch (operation) {
            case "+":
                cal = operand1 + operand2;
                break;
            case "*":
                cal = operand1 * operand2;
                break;
            case "/":
                try{
                    cal = operand1 / operand2;
                }catch(ArithmeticException e){
                    throw new IllegalOperationException("Division by zero is not allowed",e);
                }            
                break;
            default:
                throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return operand1 + " " + operation + " " + operand2 + " = " + cal;
    }
}
