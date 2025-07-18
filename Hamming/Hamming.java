public class Hamming {
    private final int differences;
    
    public Hamming(String leftStrand, String rightStrand) {
        
        if(leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("strands must be of equal length");
        }
        
        int count =0;
            for(int i = 0;i<leftStrand.length();i++){
                if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                    count++;
                }
            }
        this.differences = count;
    }

    public int getHammingDistance() {
        return this.differences;
    }
}
