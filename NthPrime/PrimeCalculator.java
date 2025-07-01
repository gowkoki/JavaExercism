class PrimeCalculator {

    int nth(int nth) {
        if(nth < 1) {
            throw new IllegalArgumentException("Invalid Input");
        }
        
        int num = 1;
        int count =0;
        
        while(count < nth){
            num++;
           if(isPrime(num)){
               count++;
           }
        }

        return num;
    }

    private boolean isPrime(int num){
        for(int i =2;i<=Math.sqrt(num);i++){
            if(num%i ==0){
                return false;
            }
        }
        return true;
    }

}
