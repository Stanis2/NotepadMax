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
                case "ac":
                case "Add-contact":
                    createPerson();
                    break;
                case "an":
                case "Add-note":
                    createNote();
                    break;
                case "se":
                case "Search":
                    searchInfo();
                    break;
                case "List":
                    list();
                    break;
                case "Delete":
                    delete();
                    break;
                case "Help":
                    help();
                    break;
                case "Exit":
                    return;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void searchInfo() {
        System.out.println("Search for what?");
        String str = askString();
        for (Record r : recordList) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            } else {
                System.out.println("Not found.");
            }
        }
    }

    private static void help() {
        System.out.println("Add-contact or ac - creates a new contact.");
        System.out.println("Add-note or an - adds a new note.");
        System.out.println("Add-reminder or ar - creates a new reminder with note.");
        System.out.println("List - list of all IDs, contacts, notes and reminders.");
        System.out.println("Search or se - find a matching text or character.");
        System.out.println("Delete - deletes a content by ID.");
        System.out.println("Use quotes to add more information.");
        System.out.println("Date and time format - dd.mm.yyyy - hh:hh - only numbers.");
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

    public static String askPhone() {
        while (true) {
            String phone = askString();
            if (phone.length() >= 4) {
                return phone;
            } else {
                System.out.println("Phone number is too short!");
            }
        }
    }

    public static String askDate() {
        while (true) {
            String date = askString();
            if (date.length() == 10) {
                return date;
            } else {
                System.out.println("Wrong date format. (dd.mm.yyyy)");
            }
        }
    }

    public static String askTime() {
        while (true) {
            String time = askString();
            if (time.length() == 5) {
                return time;
            } else {
                System.out.println("Wrong time format. (hh:hh)");
            }
        }
    }

    public static String askString() {
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

    private static void createPerson() {
        Person p = new Person();
        addRecord(p);
    }

    private static void createNote() {
        Notes n = new Notes();
        addRecord(n);
    }

    private static void createReminder() {
        Reminder r = new Reminder();
        addRecord(r);
    }

    private static void addRecord(Record p) {
        p.askQuestions();
        recordList.add(p);
        System.out.println(p);
    }
}
