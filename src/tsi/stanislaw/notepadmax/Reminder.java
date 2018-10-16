package tsi.stanislaw.notepadmax;

import java.time.LocalDate;

public class Reminder extends Alarm {
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
                "remTime='" + getAlarmTime().format(Main.TIME_FORMATTER) + '\'' +
                ", remDate='" + remDate.format(Main.DATE_FORMATTER) + '\'' +
                ", remNote='" + getNewNotes() + '\'' +
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
}
