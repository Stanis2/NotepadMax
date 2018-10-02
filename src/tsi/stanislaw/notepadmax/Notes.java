package tsi.stanislaw.notepadmax;

public class Notes extends Record {
    private String newNotes;

    public String getNewNotes() {
        return newNotes;
    }

    public void setNewNotes(String newNotes) {
        this.newNotes = newNotes;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "newNotes='" + newNotes + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return newNotes.contains(str);
    }
}
