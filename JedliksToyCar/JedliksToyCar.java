public class JedliksToyCar {
    private int meters;
    private int battery;

    public JedliksToyCar(){
        this.meters = 0;
        this.battery = 100;
    }
    
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven "+this.meters+" meters";
    }

    public String batteryDisplay() {
        if(battery>0){
             return "Battery at "+this.battery+"%";
        }else{
           return "Battery empty";
        }
    }

    public void drive() {
        if(battery > 0){
        this.meters += 20;
        this.battery--;
        }
    }
}
