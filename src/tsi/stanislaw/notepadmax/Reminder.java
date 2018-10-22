package tsi.stanislaw.notepadmax;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reminder extends Alarm implements Expirable {
    private LocalDate remDate;

    public LocalDate getRemDate() {
        return remDate;
    }

    public void setRemDate(LocalDate remDate) {
        this.remDate = remDate;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id='" + getId() + '\'' +
                ", Reminder Time ='" + getAlarmTime().format(Main.TIME_FORMATTER) + '\'' +
                ", Reminder Date ='" + remDate.format(Main.DATE_FORMATTER) + '\'' +
                ", Reminder Note ='" + getNewNotes() + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || remDate.format(Main.DATE_FORMATTER).contains(str)
                || getAlarmTime().format(Main.TIME_FORMATTER).contains(str);
    }

    @Override
    public void askQuestions() {
        super.askQuestions();

        System.out.println("Enter your date.");
        remDate = Main.askDate();
    }

    @Override
    public boolean isExpired() {
        LocalTime time = getAlarmTime();
        LocalDateTime dt = LocalDateTime.of(remDate, time);
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(dt);
    }
}
