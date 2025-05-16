class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distance;
    private int battery ;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.battery = 100;
        this.distance = 0;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getBatteryDrain(){
        return this.batteryDrain;
    }

    public boolean batteryDrained() {
        return this.battery < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        int checkB = this.battery - this.batteryDrain;
        if(checkB >=0 ){
            this.battery -= this.batteryDrain;
            this.distance += speed;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }
}

class RaceTrack {
    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int maxdrive = 100/car.getBatteryDrain();
        int maxDistance = maxdrive * car.getSpeed();
        return maxDistance >= this.distance;
    }
}
