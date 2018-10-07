package tsi.stanislaw.notepadmax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Record> recordList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Type 'Help' for command list.");
        while (true) {
            System.out.println("Enter a command:");
            String cmd = scanner.next();
            switch (cmd) {
                case "ar":
                case "Add-reminder":
                    createReminder();
                    break;
                case "Search":
                case "se":
                    searchInfo();
                    break;
                case "ac":
                case "Add-contact":
                    createPerson();
                    break;
                case "an":
                case "Add-note":
                    createNote();
                    break;
                case "List":
                    list();
                    break;
                case "Delete":
                    delete();
                    break;
                case  "Help":
                    help();
                    break;
                case "Exit":
                    return;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void createReminder() {
        Reminder r = new Reminder();

        System.out.println("Enter your text to remind.");
        String remindNote = askString();
        r.setRemNote(remindNote);

        System.out.println("Enter your date to remind.");
        String remindDate = askString();
        r.setRemDate(remindDate);

        System.out.println("Enter your time to remind.");
        String remindTime = askString();
        r.setRemTime(remindTime);

        recordList.add(r);

        System.out.println(r);
    }

    private static void searchInfo() {
        System.out.println("Search for what?");
        String str = askString();
        for (Record r : recordList) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            }
        }
    }

    private static void createNote() {
        System.out.println("Enter your text.");
        Notes n = new Notes();

        String notes = askString();
        n.setNewNotes(notes);

        recordList.add(n);

        System.out.println(n);

    }

    private static void help() {
        System.out.println("Add-note or an - adds a new note.");
        System.out.println("Add-contact or ac - creates a new contact.");
        System.out.println("List - list of all contacts.");
        System.out.println("Search or se - find a matching text or character.");
        System.out.println("Delete - deletes a contact by ID.");
        System.out.println("Use quotes to add more information.");
    }

    private static void delete() {
        System.out.println("Enter ID number.");
        int deleteId = scanner.nextInt();
        for (int i = 0; i < recordList.size(); i++) {
            Record p = recordList.get(i);
            if (deleteId == p.getId()) {
                recordList.remove(i);
                break;
            }
        }
    }

    private static void list() {
        for (Record p : recordList) {
            System.out.println(p);
        }
    }

    private static void createPerson() {
        Person p = new Person();

        System.out.println("Enter a firstname.");
        String firstName = askString();
        p.setFirstName(firstName);

        System.out.println("Enter a lastname.");
        String lastName = askString();
        p.setLastName(lastName);

        System.out.println("Enter a phone number.");
        String phoneNumber = askString();
        p.setPhoneNumber(phoneNumber);

        System.out.println("Enter a comment.");
        String comment = askString();
        p.setContactComment(comment);

        recordList.add(p);

        System.out.println(p);
    }

    private static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")) {
            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    String join = String.join(" ", result);
                    return join.substring(1, join.length()-1);
                }
                word = scanner.next();
            } while (true);
        } else {
            return word;
        }
    }
}
