package tsi.stanislaw.notepadmax;

public class Person extends Record {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactComment;

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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactComment='" + contactComment + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return firstName.contains(str)
                || lastName.contains(str)
                || phoneNumber.contains(str)
                || contactComment.contains(str);
    }
}
