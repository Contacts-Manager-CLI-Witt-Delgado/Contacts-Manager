package Contacts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;

public class ContactsApp {
    public static void printString(Path path) throws
            IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(path);
        // we need List as .readAllLines returns datatype
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
        }
    }

    public static void main(String[] args) throws
            IOException {
        int input;
        System.out.println("----------(   |   )---------");
        System.out.println("----------(   |   )---------");
        System.out.println("----------(   |   )---------");
        System.out.println("-----------(  *  )----------");
        System.out.println("------------( | )-----------");
        System.out.println("Welcome to the Jedi Archives");

        List<String> contacts = new ArrayList<>();
        contacts.add("Anakin Skywalker | 123-234-4566");
        contacts.add("Obi Wan Kenobi | 123-234-4566");
        contacts.add("Boba Fett | 123-234-4566");
        contacts.add("Mace Windu | 123-234-4566");
        contacts.add("Padme | 123-234-4566");

        Path path = Paths.get("./src/Contacts/contacts.txt");
        Files.write(path, contacts);

        do {
            System.out.println(" ");
            System.out.println("-------------------------------");
            System.out.println("1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete existing contact\n5. Exit");
            System.out.println("-------------------------------");
            System.out.println(" ");

            Scanner in = new Scanner(System.in);
            input = in.nextInt();

            if (input == 1) {
                printString(path);

            } else if (input == 2) {
                System.out.println("First name");
                String input2 = in.next();
                System.out.println("Last name");
                String input21 = in.next();
                System.out.println("Add number of new contact");
                String input22 = in.next();
                String str = String.format("%s %s | %s", input2, input21, input22);
                contacts.add(str);
                Files.write(path, contacts);
                for (String contact : contacts) {
                    if (contact.contains(input2)) {
                        System.out.println("You added " + contact + " to the Jedi Archives");
                    }
                }

            } else if (input == 3) {
                System.out.println("Please enter name.");
                String input3 = in.next();
                for (String contact : contacts) {
                    if (contact.contains(input3)) {
                        System.out.println(contact);
                    }
                }
            } else if (input == 4){
                List<String> contacts1 = Files.readAllLines(path);
                System.out.println("Please enter full name and number of contact you wish to delete.");
                String input4 = in.nextLine();
                for (String contact : contacts1) {
                    System.out.println(input4);
                    if (contact.equals(input4)) {
                        contacts1.remove(input4);
                        System.out.println(contact + " has been erased from the Jedi Archives");
                        Files.write(path, contacts1);
                        printString(path);
                        System.out.println(contact);
                    }
                }
            }else {
                System.out.println("Bye");
            }
//            Files.write(path, contacts);
        } while (input > 0 && input < 5);
    }
}

