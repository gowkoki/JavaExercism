public class Lasagna {
    
    public int expectedMinutesInOven(){
        return 40;
    }
    
    public int remainingMinutesInOven(int actualMin){
        int remaining = new Lasagna().expectedMinutesInOven()-actualMin;
        return remaining;  
    }

    public int preparationTimeInMinutes(int layers){ 
        return layers*2;  
    }

    public int totalTimeInMinutes(int layers,int actualMin){ 
        int lay = new Lasagna().preparationTimeInMinutes(layers);
        int total = lay + actualMin;
        return total;  
    }
}
