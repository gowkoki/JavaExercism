public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven(){
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int actualMin){
        int remaining = new Lasagna().expectedMinutesInOven()-actualMin;
        return remaining;  
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int layers){ 
        return layers*2;  
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int layers,int actualMin){ 
        int lay = new Lasagna().preparationTimeInMinutes(layers);
        int total = lay + actualMin;
        return total;  
    }
}
