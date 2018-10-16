package tsi.stanislaw.notepadmax;

import java.time.LocalTime;

public class Alarm extends Notes {
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
                "remTime=" + alarmTime.format(Main.TIME_FORMATTER) +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return alarmTime.format(Main.TIME_FORMATTER).contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter your time.");
        alarmTime = Main.askTime();
    }
}
