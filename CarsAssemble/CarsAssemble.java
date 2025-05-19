public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double result = 0;
        if(speed>=1 && speed <= 4){
            result = 221*speed;
        }else if(speed>=5 && speed <= 8){
            result = 221*speed*0.9;
        }else if(speed == 9){
            result = 221*speed*0.8;
        }else if(speed== 10){
            result = 221*speed*0.77;
        }
        return result;
    }

    public int workingItemsPerMinute(int speed) {
        double hour = productionRatePerHour(speed);
        return (int)(hour/60);
    }
}
