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
        System.out.println("1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete existing contact\n5. Exit");

        List<String> contacts = new ArrayList<>();
        contacts.add("Anakin Skywalker | 123-234-4566");
        contacts.add("Obi Wan Kenobi | 123-234-4566");
        contacts.add("Boba Fett | 123-234-4566");
        contacts.add("Mace Windu | 123-234-4566");
        contacts.add("Padme | 123-234-4566");

        Path path = Paths.get("./src/Contacts/contacts.txt");
        Files.write(path, contacts);
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
//        while (true) {
            if (input.equals("1")) {
                printString(path);
            } else if (input.equals("2")) {
                System.out.println("Add new contact");
                String input2 = in.nextLine();
                contacts.add(input2);
                Files.write(path, contacts);
                System.out.println(contacts);
            } else if (input.equals("3")) {
                for (String contact : contacts){
                    String input3 = in.nextLine();
                    if(contact.contains(input3)){
                        System.out.println(contact);
                    }else {
                        System.out.println("Sorry contact not found");
                    }
                }
            } else if(input.equals("4")){

//            } else  (input.equals("5")) {
//                break;
            }
            System.out.println("bye");

        }

    }
//}
