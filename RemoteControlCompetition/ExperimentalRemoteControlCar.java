public class ExperimentalRemoteControlCar implements RemoteControlCar{
    private int driveUnits = 20;
    private int distanceTravelled;

    public void drive() {
        this.distanceTravelled += this.driveUnits;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
}
