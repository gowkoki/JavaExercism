class ProductionRemoteControlCar implements RemoteControlCar,Comparable<ProductionRemoteControlCar>{
    private int driveUnits =10;
    private int distanceTravelled;
    private int numberOfVictories;
    
    public void drive() {
        this.distanceTravelled += this.driveUnits;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar other){
        return this.numberOfVictories - other.numberOfVictories;
    }
}
