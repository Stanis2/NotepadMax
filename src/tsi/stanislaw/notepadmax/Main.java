package tsi.stanislaw.notepadmax;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public final static String DATE_FORMAT = "dd.MM.yyyy";
    public final static DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public final static String TIME_FORMAT = "HH:mm";
    public final static DateTimeFormatter TIME_FORMATTER
            = DateTimeFormatter.ofPattern(TIME_FORMAT);

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Record> recordList = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println("Type 'Help' for command list.");
        while (true) {
            System.out.println("Enter a command:");
            String cmd = scanner.next();
            switch (cmd) {
                case "exp":
                case "Expired":
                    showExp();
                    break;
                case "aa":
                case "Add-alarm":
                    createAlarm();
                    break;
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
                case "Show":
                    show();
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

    private static void showExp() {
        for (Record r : recordList.values()) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (e.isExpired()) {
                    System.out.println(e);
                }
            }
        }
    }

    private static void searchInfo() {
        System.out.println("Search for what?");
        String str = askString();
        for (Record r : recordList.values()) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            } else {
                System.out.println("Not found.");
            }
        }
    }

    private static void help() {
        System.out.println("Add-contact or ac - creates a new contact.");
        System.out.println("Add-note or an - creates a new note.");
        System.out.println("Add-reminder or ar - creates a new reminder with note.");
        System.out.println("Add-alarm or aa - creates a new alarm.");
        System.out.println("List - list of all IDs, contacts, notes, reminders and alarms.");
        System.out.println("Show - shows content by ID.");
        System.out.println("Search or se - find a matching text, character or number.");
        System.out.println("Delete - deletes a content by ID.");
        System.out.println("Use quotes to add more/longer information.");
        System.out.println("Date and time format - dd.mm.yyyy - hh:hh - only numbers.");
    }

    private static void delete() {
        System.out.println("Enter ID number.");
        int deleteId = askInt();
        recordList.remove(deleteId);
    }

    private static void show() {
        System.out.println("Enter ID number.");
        int showId = askInt();
        System.out.println(recordList.get(showId));
    }

    private static void list() {
        for (Record p : recordList.values()) {
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

    private static int askInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // skip wrong input
                System.out.println("Use only numbers.");
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
                    return join.substring(1, join.length() - 1);
                }
                word = scanner.next();
            } while (true);
        } else {
            return word;
        }
    }

    public static LocalDate askDate() {
        String d = askString();
        LocalDate date = LocalDate.parse(d, DATE_FORMATTER);
        return date;
    }

    public static LocalTime askTime() {
        String t = askString();
        LocalTime time = LocalTime.parse(t, TIME_FORMATTER);
        return time;
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

    private static void createAlarm() {
        Alarm a = new Alarm();
        addRecord(a);
    }

    private static void addRecord(Record p) {
        p.askQuestions();
        recordList.put(p.getId(), p);
        System.out.println(p);
    }
}
