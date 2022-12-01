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
            System.out.printf(" %s\n", fileContents.get(i));
        }
    }


//--------------------------------------------------------------------------------------

    static List<String> contacts = new ArrayList<>();
    static List<String> contactList = new ArrayList<>();
    static Path path = Paths.get("./src/Contacts/contacts.txt");

    public static void viewContactList() throws IOException{
        Path path = Paths.get("./src/Contacts/contacts.txt");
        printString(path);
    }


    public static void addNewContact() throws IOException {
        List<String> newContact = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("name");
        String input2 = in.nextLine();
        System.out.println("Add number of new contact");
        String input22 = in.nextLine();
        String str = String.format("%-8s" + " | " + input22.replaceFirst( "(\\d{3})(\\d{3})(\\d+)" , "($1) $2-$3" ), input2);
        newContact.add(str);
        System.out.println("You added " + input2 + " to the Jedi Archives");
        Files.write(path, newContact,StandardOpenOption.APPEND);
    }


    public static void searchContact() throws IOException {
        System.out.println("Please enter name.");
        Scanner in = new Scanner(System.in);
        String input3 = in.next();
        List<String> contact1 = readAllLines(path);
        for (String s : contact1) {
            if (s.toLowerCase().contains(input3.toLowerCase())) {
                System.out.println(s);
            }
        }
    }



    public static void deleteContact() throws IOException {
        Path path = Paths.get("./src/Contacts/contacts.txt");
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter name of contact you wish to delete.");
        String input4 = in.nextLine();
        List<String> contact1 = readAllLines(path);
        if(!contact1.contains(input4)) {
            System.out.println("Contact " + input4 + " does not exist");
        }

        for (int i = 0; i < contact1.size(); i++) {
            if (contact1.get(i).toLowerCase().contains(input4.toLowerCase())) {
                contact1.remove(contact1.get(i));
                System.out.println( input4 + " has been erased from the Jedi Archives");
                Files.write(path, contact1);
                printString(path);
            }
        }

    }

//---------------------------------------------------------------------------















    public static void main(String[] args) throws IOException {
        int input;
        System.out.println("----------(   |   )---------");
        System.out.println("----------(   |   )---------");
        System.out.println("----------(   |   )---------");
        System.out.println("-----------(  *  )----------");
        System.out.println("------------( | )-----------");
        System.out.println("Welcome to the Jedi Archives");


        do {
            System.out.println(" ");
            System.out.println("-------------------------------");
            System.out.println("1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete existing contact\n5. Exit");
            System.out.println("-------------------------------");
            System.out.println(" ");
            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            if (input == 1) {
                viewContactList();
            } else if (input == 2) {
                addNewContact();
            } else if (input == 3) {
                searchContact();
            } else if (input == 4){
                deleteContact();
            } else{
                System.out.println("Bye");
            }
        } while (input > 0 && input < 5);










//        List<String> contacts = new ArrayList<>();
//        contacts.add("Anakin Skywalker | 123-234-4566");
//        contacts.add("Obi Wan Kenobi | 123-234-4566");
//        contacts.add("Boba Fett | 123-234-4566");
//        contacts.add("Mace Windu | 123-234-4566");
//        contacts.add("Padme | 123-234-4566");
//
//        Path path = Paths.get("./src/Contacts/contacts.txt");
//        Files.write(path, contacts);
//
//        do {
//            System.out.println(" ");
//            System.out.println("-------------------------------");
//            System.out.println("1. View contacts\n2. Add a new contact\n3. Search a contact by name\n4. Delete existing contact\n5. Exit");
//            System.out.println("-------------------------------");
//            System.out.println(" ");
//
//            Scanner in = new Scanner(System.in);
//            input = in.nextInt();
//
//            if (input == 1) {
//                printString(path);
//
//            } else if (input == 2) {
//                System.out.println("First name");
//                String input2 = in.next();
//                System.out.println("Last name");
//                String input21 = in.next();
//                System.out.println("Add number of new contact");
//                String input22 = in.next();
//                String str = String.format("%s %s | %s", input2, input21, input22);
//                contacts.add(str);
//                Files.write(path, contacts);
//                for (String contact : contacts) {
//                    if (contact.contains(input2)) {
//                        System.out.println("You added " + contact + " to the Jedi Archives");
//                    }
//                }
//
//            } else if (input == 3) {
//                System.out.println("Please enter name.");
//                String input3 = in.next();
//                for (String contact : contacts) {
//                    if (contact.contains(input3)) {
//                        System.out.println(contact);
//                    }
//                }
//            } else if (input == 4){
//                List<String> contacts1 = Files.readAllLines(path);
//                System.out.println("Please enter full name and number of contact you wish to delete.");
//                String input4 = in.nextLine();
//                for (String contact : contacts1) {
//                    System.out.println(input4);
//                    if (contact.equals(input4)) {
//                        contacts1.remove(input4);
//                        System.out.println(contact + " has been erased from the Jedi Archives");
//                        Files.write(path, contacts1);
//                        printString(path);
//                        System.out.println(contact);
//                    }
//                }
//            }else {
//                System.out.println("Bye");
//            }
////            Files.write(path, contacts);
//        } while (input > 0 && input < 5);
//    }
    }
}
