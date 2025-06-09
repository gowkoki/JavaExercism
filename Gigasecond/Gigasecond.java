import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private final LocalDateTime dateTime;
    private static final long GIGASECOND = 1_000_000_000L;
   
    public Gigasecond(LocalDate moment) {
        this.dateTime = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }
   
    public Gigasecond(LocalDateTime moment) {
        this.dateTime = moment.plusSeconds(GIGASECOND);
    }
    
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }
}
