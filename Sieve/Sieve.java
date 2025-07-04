import java.util.*;

class Sieve {
    private int maxPrime;
    
    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> result = new ArrayList<>();

        for(int i = 2;i<=maxPrime;i++){
            if(isPrime(i)){
                result.add(i);
            }
        }

        return result;
    }

    private boolean isPrime(int num){
    if (num == 2 || num == 3) return true;
    if (num % 2 == 0 || num % 3 == 0) return false;

    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) return false;
    }

    return true;
    }
}
