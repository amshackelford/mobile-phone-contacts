package com.shackman;

import java.util.Scanner;

public class Main {
    public static MobilePhone mobilePhone = new MobilePhone();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        printOptions();

        while (!quit) {
            System.out.print("\nEnter your selection (Press 0 to see options): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
            }
        }
    }

    public static void printOptions() {
        System.out.println("Available Options: ");
        System.out.println("\t0. Show options");
        System.out.println("\t1. Show contact list.");
        System.out.println("\t2. Add a new contact. ");
        System.out.println("\t3. Update a contact");
        System.out.println("\t4. Delete a contact ");
        System.out.println("\t5. Search for a contact ");
        System.out.println("\t6. Quit");
    }

    public static void addContact() {
        System.out.print("Enter contact name: ");
        String contactName = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        Contact newContact = new Contact(contactName, contactNumber);
        mobilePhone.addMobileContact(newContact);
    }

    public static void updateContact() {
        System.out.print("Enter the name of the contact you want to change: ");
        String name = scanner.nextLine();
        System.out.print("Enter the new name of the contact: ");
        String newName = scanner.nextLine();
        System.out.print("Enter the new phone of the contact: ");
        String phone = scanner.nextLine();
        Contact oldContact = new Contact(name, null);
        Contact newContact = new Contact(newName, phone);
        mobilePhone.modifyMobileContact(oldContact, newContact);
    }

    public static void removeContact() {
        System.out.print("Enter the name of the contact you want to remove: ");
        String name = scanner.nextLine();
        Contact removeThis = new Contact(name, null);
        mobilePhone.removeMobileContact(removeThis);
    }

    public static void findContact() {
        System.out.print("Enter the contact you want to find: ");
        String name = scanner.nextLine();
        Contact searchContact = new Contact(name, null);
        mobilePhone.findMobileContact(searchContact);
    }
}
