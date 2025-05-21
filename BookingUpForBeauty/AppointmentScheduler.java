import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    private static final DateTimeFormatter SCHEDULE_FORMATTER =
        DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    private static final DateTimeFormatter DESCRIPTION_FORMATTER =
        DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a");
    
    public LocalDateTime schedule(String appointmentDateDescription) {
                return LocalDateTime.parse(appointmentDateDescription, SCHEDULE_FORMATTER);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        
        int hour = appointmentDate.getHour();
        return hour>=12 && hour<18;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        return "You have an appointment on " + appointmentDate.format(DESCRIPTION_FORMATTER) + ".";
    }

    public LocalDate getAnniversaryDate() {
       return LocalDate.of(LocalDate.now().getYear(),9,15);
    }
}
