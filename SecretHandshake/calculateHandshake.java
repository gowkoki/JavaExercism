import java.util.*;

class HandshakeCalculator {
    
    List<Signal> calculateHandshake(int number) {
        List<Signal> result = new ArrayList<>();
        int index =0;
        
         while (number > 0) {
            if ((number & 1) == 1) {
                if(index == 0){
                    result.add(Signal.WINK);
                }else if(index == 1){
                    result.add(Signal.DOUBLE_BLINK);
                }else if(index == 2){
                    result.add(Signal.CLOSE_YOUR_EYES);
                }else if(index == 3){
                    result.add(Signal.JUMP);
                }else if(index == 4){
                    Collections.reverse(result);
                    break;
                }
            }
            index++;
            number >>= 1;
        }

        return result;
    }
}
