package tsi.stanislaw.notepadmax;

import java.time.LocalTime;

public class Alarm extends Notes implements Expirable {
    private LocalTime alarmTime;

    public LocalTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalTime remTime) {
        this.alarmTime = remTime;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id='" + getId() + '\'' +
                "newNotes='" + getNewNotes() + '\'' +
                "remTime=" + alarmTime.format(Main.TIME_FORMATTER) +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || alarmTime.format(Main.TIME_FORMATTER).contains(str);
    }

    @Override
    public void askQuestions() {
        super.askQuestions();

        System.out.println("Enter your time.");
        alarmTime = Main.askTime();
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return alarmTime.isBefore(now);
    }
}
