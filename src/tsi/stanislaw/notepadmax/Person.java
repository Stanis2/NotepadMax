package tsi.stanislaw.notepadmax;

import java.time.LocalDate;

public class Person extends Record implements Birthday {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactComment;
    private LocalDate birthdayPerson;

    public LocalDate getBirthdayPerson() {
        return birthdayPerson;
    }

    public void setBirthdayPerson(LocalDate birthdayPerson) {
        this.birthdayPerson = birthdayPerson;
    }

    public String getContactComment() {
        return contactComment;
    }

    public void setContactComment(String contactComment) {
        this.contactComment = contactComment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String surname) {
        this.lastName = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + getId() + '\'' +
                ", Firstname ='" + firstName + '\'' +
                ", Lastname ='" + lastName + '\'' +
                ", Phone Number ='" + phoneNumber + '\'' +
                ", Birthday ='" + birthday().format(Main.DATE_FORMATTER) + '\'' +
                ", Comment ='" + contactComment + '\'' +
                ", Birthday Month ='" + birthdayDay() + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return firstName.contains(str)
                || lastName.contains(str)
                || phoneNumber.contains(str)
                || contactComment.contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter a firstname.");
        firstName = Main.askString();

        System.out.println("Enter a lastname.");
        lastName = Main.askString();

        System.out.println("Enter a phone number.");
        phoneNumber = Main.askPhone();

        System.out.println("Enter a birthday.");
        birthdayPerson = Main.askDate();

        System.out.println("Enter a comment.");
        contactComment = Main.askString();
    }

    @Override
    public LocalDate birthday() {
        return birthdayPerson;
    }

    @Override
    public boolean birthdayDay() {
        LocalDate now = LocalDate.now();
        return birthdayPerson.isAfter(now);
    }
}
