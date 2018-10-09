package tsi.stanislaw.notepadmax;

public class Reminder extends Notes {
    private String remTime;
    private String remDate;
    private String remNote;

    public String getRemTime() {
        return remTime;
    }

    public void setRemTime(String remTime) {
        this.remTime = remTime;
    }

    public String getRemDate() {
        return remDate;
    }

    public void setRemDate(String remDate) {
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
                "remTime='" + remTime + '\'' +
                ", remDate='" + remDate + '\'' +
                ", remNote='" + remNote + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return remNote.contains(str)
                || remDate.contains(str)
                || remTime.contains(str);
    }
}
