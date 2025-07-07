import java.util.*;

class SumOfMultiples {
    private int sum;
    
    SumOfMultiples(int number, int[] set) {
        Set<Integer> unique = new HashSet<>();
        int sumMul = 0;
        
        for(int s : set){
            if(s <= 0) continue;
            for(int i = 1; i*s<number;i++){
                int mul = i*s;
                if(unique.add(mul)){
                    sumMul += mul;
                }
            }
        }
        this.sum = sumMul;
    }

    int getSum() {
        return this.sum;
    }
}
