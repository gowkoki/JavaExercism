class SpaceAge {

    private double seconds;
    private final double EARTH_SECONDS = 31557600;
    private final double MERCURY = 0.2408467;
    private final double VENUS = 0.61519726;
    private final double EARTH = 1.0;
    private final double MARS = 1.8808158;
    private final double JUPITER = 11.862615;
    private final double SATURN = 29.447498;
    private final double URANUS = 84.016846;
    private final double NEPTUNE = 164.79132;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        return this.seconds/(EARTH_SECONDS*EARTH);
    }

    double onMercury() {
        return this.seconds/(EARTH_SECONDS*MERCURY);
    }

    double onVenus() {
        return this.seconds/(EARTH_SECONDS*VENUS);
    }

    double onMars() {
        return this.seconds/(EARTH_SECONDS*MARS);
    }

    double onJupiter() {
        return this.seconds/(EARTH_SECONDS*JUPITER);
    }

    double onSaturn() {
        return this.seconds/(EARTH_SECONDS*SATURN);
    }

    double onUranus() {
        return this.seconds/(EARTH_SECONDS*URANUS);
    }

    double onNeptune() {
        return this.seconds/(EARTH_SECONDS*NEPTUNE);
    }

}
