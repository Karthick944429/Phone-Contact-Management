package javaProject;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager contactManager = new ContactManager(20);
        final String red = "\u001B[31m";
        final String resetColor = "\u001B[0m";
        final String green = "\u001B[32m";
        final String yellow = "\u001B[33m";
        while (true) {
            System.out.println("==================================");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("0. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    Contact contact = new Contact(name, phoneNumber, email);
                    contactManager.addContact(contact);
                    break;
                case 2:
                    contactManager.displayAllContacts();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    contactManager.searchContactByName(searchName);
                    break;
                case 0:
                    System.out.println(yellow+"Exiting..."+resetColor);
                    sc.close();
                    return;
                default:
                    System.out.println(red + "Invalid choice. Please try again...." + resetColor);
            }
        }
    }
}