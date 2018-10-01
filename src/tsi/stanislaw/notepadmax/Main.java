package tsi.stanislaw.notepadmax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Person> info = new ArrayList<>();

    public static void main(String[] args) {
        loadContacts();
        System.out.println("Type 'Help' for command list.");
        while (true) {
            System.out.println("Enter a command:");
            String cmd = scanner.next();
            switch (cmd) {
                case "Create":
                    create();
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
            save();
        }
    }

    private static void loadContacts() {
        File file = new File("person_data.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()) {
                Person p = new Person();
                p.setFirstName() = in.next();
                info.add(p);
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }

    private static void help() {
        System.out.println("Create - creates a new contact.");
        System.out.println("List - list of all contacts.");
        System.out.println("Delete - deletes a contact by ID.");
    }

    private static void delete() {
        System.out.println("Enter ID number.");
        int deleteId = scanner.nextInt();
        info.remove(deleteId - 1);
    }

    private static void list() {
        for (Person p : info) {
            System.out.println(p);
        }
    }


    private static void save() {
        File file = new File("person_data.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (Person p : info) {
                out.printf("%d %s %s %s\n", p.getId(), p.getFirstName(), p.getLastName(), p.getPhoneNumber());
            }
        } catch (IOException e) {
            System.out.println("Error saving to disk.");
        }
    }

    private static void create() {
        Person p = new Person();

        System.out.println("Enter a firstname.");
        String firstName = scanner.next();
        if (firstName.startsWith("\"")){
            String secondName = scanner.next();
            p.setFirstName(firstName + " " + secondName);
        } else {
            p.setFirstName(firstName);
        }

        System.out.println("Enter a lastname.");
        String lastName = scanner.next();
        p.setLastName(lastName);

        System.out.println("Enter a phone number.");
        String phoneNumber = scanner.next();
        p.setPhoneNumber(phoneNumber);

        info.add(p);

        System.out.println(p);
    }
}
