package tsi.stanislaw.notepadmax;

import java.time.LocalDate;

public class Pet extends Record implements Birthday {
    private String name;
    private LocalDate birthdayPet;
    private String comment;

    public LocalDate getBirthdayPet() {
        return birthdayPet;
    }

    public void setBirthdayPet(LocalDate birthdayPet) {
        this.birthdayPet = birthdayPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean hasSubstring(String str) {
        return name.contains(str)
                || comment.contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter a pet's name.");
        name = Main.askString();

        System.out.println("Enter a birthday.");
        birthdayPet = Main.askDate();

        System.out.println("Enter a comment.");
        comment = Main.askString();
    }

    @Override
    public boolean birthdayDay() {
        LocalDate now = LocalDate.now();
        return birthdayPet.isAfter(now);
    }

    @Override
    public LocalDate birthday() {
        return birthdayPet;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + getId() + '\'' +
                ", Name ='" + name + '\'' +
                ", Birthday ='" + birthday().format(Main.DATE_FORMATTER) + '\'' +
                ", Comment ='" + comment + '\'' +
                ", Birthday Month ='" + birthdayDay() + '\'' +
                '}';
    }

}