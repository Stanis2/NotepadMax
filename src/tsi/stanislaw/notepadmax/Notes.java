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
                "id='" + getId() + '\'' +
                "newNotes='" + newNotes + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return newNotes.contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter your text.");
        newNotes = Main.askString();
    }
}
