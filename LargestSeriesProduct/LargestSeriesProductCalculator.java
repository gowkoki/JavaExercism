import java.util.*;

class LargestSeriesProductCalculator {
    private String number;
  
    LargestSeriesProductCalculator(String inputNumber) {
        if(!inputNumber.matches("\\d*")){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.number = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits < 0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        
        if(numberOfDigits > number.length()){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        if(numberOfDigits == 0){
            return 1;
        }
        
        long max=0;

        for(int i =0; i<= number.length() - numberOfDigits; i++){
            String num = number.substring(i,i+numberOfDigits);
            max = Math.max(max,product(num));
        }

        return max;
    }
    private long product(String digits) {
    long result = 1;
    for (char c : digits.toCharArray()) {
        result *= c - '0';
    }
    return result;
}

}
