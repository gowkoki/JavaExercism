public class EliudsEggs {
    public int eggCount(int number) {
        int result = 0;
        
        while (number > 0) {
            if ((number & 1) == 1) {
                result++;
            }
            number >>= 1;
        }
        
        return result;
    }
}
