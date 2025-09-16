import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {
    private enum State { READY, RUNNING, STOPPED }

    private State state;
    private int currentLapTime; 
    private int totalTime;     
    private final List<String> previousLaps;

    public SplitSecondStopwatch() {
        this.state = State.READY;
        this.currentLapTime = 0;
        this.totalTime = 0;
        this.previousLaps = new ArrayList<>();
    }

   
    public void start() {
        if (state == State.READY || state == State.STOPPED) {
            state = State.RUNNING;
        } else {
            throw new IllegalStateException("cannot start an already running stopwatch");
        }
    }

    public void stop() {
        if (state == State.RUNNING) {
            state = State.STOPPED;
        } else {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }
    }

    public void reset() {
        if (state == State.STOPPED) {
            state = State.READY;
            currentLapTime = 0;
            totalTime = 0;
            previousLaps.clear();
        } else {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }
    }

    public void lap() {
        if (state == State.RUNNING) {
            previousLaps.add(formatTime(currentLapTime));
            currentLapTime = 0;
        } else {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }
    }

 
    public String state() {
        return state.name().toLowerCase();
    }

    public String currentLap() {
        return formatTime(currentLapTime);
    }

    public String total() {
        return formatTime(totalTime);
    }

    public List<String> previousLaps() {
        return new ArrayList<>(previousLaps);
    }

  
    public void advanceTime(String timeString) {
        if (state != State.RUNNING) return; // only track time if running
        int seconds = parseTime(timeString);
        currentLapTime += seconds;
        totalTime += seconds;
    }

 
    private String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private int parseTime(String timeString) {
        // Format: "HH:MM:SS"
        String[] parts = timeString.split(":");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid time format: " + timeString);
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
}
