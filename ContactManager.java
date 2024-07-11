package javaProject;

import java.util.regex.Pattern;

public class ContactManager {
    private Contact[] contacts;
    private int noContact;
    final String red = "\u001B[31m";
    final String resetColor = "\u001B[0m";
    final String green = "\u001B[32m";
    final String yellow = "\u001B[33m";

    public ContactManager(int size) {
        this.contacts = new Contact[size];
        this.noContact = 0;
    }

    public void addContact(Contact contact) {
        if (!isValidEmail(contact.getEmailId())) {
            System.out.println(red+"Invalid email format. Contact not added."+resetColor);
            return;
        }
        if (!isValidPhoneNo(contact.getPhoneNo())) {
            System.out.println(red+"Invalid phone number format. Contact not added."+resetColor);
            return;
        }
        if (noContact < contacts.length) {
            contacts[noContact++] = contact;
            System.out.println(green+"Contact added successfully."+resetColor);
        } else {
            System.out.println(yellow+"Contact list is full."+resetColor);
        }
    }

    public void displayAllContacts() {
        if (noContact == 0) {
            System.out.println(red+"No contacts available."+resetColor);
        } else {
            for (int i = 0; i < noContact; i++) {
                System.out.println("==================================");
                contacts[i].displayContact();
                System.out.println("==================================");
            }
        }
    }

    public void searchContactByName(String name) {
        boolean found = false;
        for (int i = 0; i < noContact; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                contacts[i].displayContact();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(red+"Contact not found!"+resetColor);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    private boolean isValidPhoneNo(String phoneNo) {
        Pattern pat = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        return phoneNo != null && pat.matcher(phoneNo).matches();
    }
}
