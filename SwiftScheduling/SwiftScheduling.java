import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class SwiftScheduling {

    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        DayOfWeek day = meetingStart.getDayOfWeek();
        LocalTime time = meetingStart.toLocalTime();

        if (description.equals("NOW")) {
            return meetingStart.plusHours(2);
        }

        if (description.equals("ASAP")) {
            if (time.isBefore(LocalTime.of(13, 0))) {
                return LocalDateTime.of(meetingStart.toLocalDate(), LocalTime.of(17, 0));
            } else {
                return LocalDateTime.of(meetingStart.toLocalDate().plusDays(1), LocalTime.of(13, 0));
            }
        }

        if (description.equals("EOW")) {
            if (day.getValue() <= 3) { // Mon-Wed
                LocalDate thisFriday = meetingStart.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).toLocalDate();
                return LocalDateTime.of(thisFriday, LocalTime.of(17, 0));
            } else { // Thu or Fri
                LocalDate thisSunday = meetingStart.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toLocalDate();
                return LocalDateTime.of(thisSunday, LocalTime.of(20, 0));
            }
        }

        if (description.matches("\\d{1,2}M")) {
            int targetMonth = Integer.parseInt(description.replace("M", ""));
            int currentMonth = meetingStart.getMonthValue();
            int year = (currentMonth < targetMonth) ? meetingStart.getYear() : meetingStart.getYear() + 1;

            LocalDate firstDay = LocalDate.of(year, targetMonth, 1);
            while (!isWorkday(firstDay)) {
                firstDay = firstDay.plusDays(1);
            }
            return LocalDateTime.of(firstDay, LocalTime.of(8, 0));
        }

        if (description.matches("Q[1-4]")) {
            int quarter = Integer.parseInt(description.substring(1));
            int meetingMonth = meetingStart.getMonthValue();
            int currentQuarter = (meetingMonth - 1) / 3 + 1;

            int year = (currentQuarter <= quarter) ? meetingStart.getYear() : meetingStart.getYear() + 1;
            int endMonth = quarter * 3;

            LocalDate lastDay = LocalDate.of(year, endMonth, Month.of(endMonth).length(Year.isLeap(year)));
            while (!isWorkday(lastDay)) {
                lastDay = lastDay.minusDays(1);
            }
            return LocalDateTime.of(lastDay, LocalTime.of(8, 0));
        }

        throw new IllegalArgumentException("Unsupported description: " + description);
    }

    private static boolean isWorkday(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        return dow != DayOfWeek.SATURDAY && dow != DayOfWeek.SUNDAY;
    }
}
