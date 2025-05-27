class ArmstrongNumbers {
    boolean isArmstrongNumber(int numberToCheck) {
        int orgNum = numberToCheck;
        int len = String.valueOf(orgNum).length();
        int sum =0;
        
        while(numberToCheck !=0){
            int num = numberToCheck%10;
            sum += Math.pow(num,len);
            numberToCheck/=10;
        }
        
        return sum == orgNum;
    }
}
