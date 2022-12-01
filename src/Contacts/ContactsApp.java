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
    static Path path = Paths.get("./src/Contacts/contacts.txt");
//getting the path of contacts
    public static void viewContactList() throws IOException{
        Path path = Paths.get("./src/Contacts/contacts.txt");
        printString(path);
        //prints the path method
    }
    public static void addNewContact() throws IOException {
        //adding the new contact method
        boolean found = false;
        List<String> newContact = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("name");
        String input2 = in.nextLine();
        System.out.println("Add number of new contact");
        String input22 = in.nextLine();
        List<String> contact1 = readAllLines(path);
        for (String s : contact1) {
            //if exists boolean true
            if (s.toLowerCase().contains(input2.toLowerCase())) {
                System.out.println("contact already exits");
                found = true;
                break;
            }
        }if(!found) {
            //if not exists add new contact
            String str = String.format("%-20s" + " | " + "%-18s" + " |", input2, input22.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
            newContact.add(str);
            System.out.println("You added " + input2 + " to the Jedi Archives");
            Files.write(path, newContact, StandardOpenOption.APPEND);
        }
    }
    public static void searchContact() throws IOException {
        //search contact method
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
        //delete contact method
        Path path = Paths.get("./src/Contacts/contacts.txt");
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter name of contact you wish to delete.");
        String input4 = in.nextLine();
        List<String> contact1 = readAllLines(path);
        for (int i = 0; i < contact1.size(); i++) {
            if (contact1.get(i).toLowerCase().contains(input4.toLowerCase())) {
                contact1.remove(contact1.get(i));
                //when it is erased
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
            //if else displaying methods
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
    }
}
