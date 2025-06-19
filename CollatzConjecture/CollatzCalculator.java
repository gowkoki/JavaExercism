class CollatzCalculator {

    int computeStepCount(int start) {
        if(start <= 0){
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        
        int count =0;
        while(start !=1){
            count++;
            start = start%2 ==0 ? start/2 : (start *3)+1;
        }
        return count;
    }

}
