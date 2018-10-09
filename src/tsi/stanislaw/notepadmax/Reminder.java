package tsi.stanislaw.notepadmax;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder extends Notes {
    private LocalTime remTime;
    private LocalDate remDate;
    private String remNote;

    public LocalTime getRemTime() {
        return remTime;
    }

    public void setRemTime(LocalTime remTime) {
        this.remTime = remTime;
    }

    public LocalDate getRemDate() {
        return remDate;
    }

    public void setRemDate(LocalDate remDate) {
        this.remDate = remDate;
    }

    public String getRemNote() {
        return remNote;
    }

    public void setRemNote(String remNote) {
        this.remNote = remNote;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id='" + getId() + '\'' +
                "remTime='" + remTime.format(Main.TIME_FORMATTER) + '\'' +
                ", remDate='" + remDate.format(Main.DATE_FORMATTER) + '\'' +
                ", remNote='" + remNote + '\'' +
                '}';
    }



    @Override
    public boolean hasSubstring(String str) {
        return remNote.contains(str)
                || remDate.format(Main.DATE_FORMATTER).contains(str)
                || remTime.format(Main.TIME_FORMATTER).contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter your text to remind.");
        remNote = Main.askString();

        System.out.println("Enter your date.");
        remDate = Main.askDate();

        System.out.println("Enter your time.");
        remTime = Main.askTime();
    }
}
