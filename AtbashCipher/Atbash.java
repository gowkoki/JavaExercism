import java.util.*;
    
class Atbash {
    private final char[] CODE = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    

    String encode(String input) {
        input = input.toLowerCase();
        StringBuilder encodedWord = new StringBuilder();
        int count = 0;
        for(char c : input.toCharArray()){
            int index  = findIndex(c);
            if(index != -1) {
                encodedWord.append(CODE[25-index]);
                count++;
            }else if(Character.isDigit(c)){
                encodedWord.append(c);
                count++;
            }
            if(count == 5){
                encodedWord.append(" ");
                count =0;
            }
        }

        return encodedWord.toString().trim();

    }

    String decode(String input) {
        input = input.toLowerCase();
        StringBuilder decodedWord = new StringBuilder();
            
        for(char c : input.toCharArray()){
            int index  = findIndex(c);
            if(index != -1) {
                decodedWord.append(CODE[25-index]);
            }else if(Character.isDigit(c)){
                decodedWord.append(c);
            }
        }

        return decodedWord.toString();
    }

    private int findIndex(char c) {
            
        for(int i=0; i<CODE.length; i++){
            if(CODE[i] == c) {
                return i;
            }
        }

        return -1;
    }

}
