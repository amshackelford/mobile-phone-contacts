package com.shackman;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;

    public MobilePhone() {
        contacts = new ArrayList<Contact>();
    }

    public void printContacts() {
        System.out.println("There are " + contacts.size() + " contacts.");
        int count = 1;
        for (Contact contact : contacts) {
            System.out.println(count + ". " + contact.getName() + " -> " +contact.getPhoneNumber());
            count++;
        }
    }

    public void addMobileContact(Contact contact) {
        if (contactExists(contact)) {
            System.out.println("Name already exists in contacts");
        } else if (contact.getName() == null || contact.getName().trim().length()== 0) {
            System.out.println("Invalid name");
        } else {
            contacts.add(contact);
            System.out.println("New contact added: name = " + contact.getName() + ", phone = " + contact.getPhoneNumber());
        }
    }

    public void modifyMobileContact(Contact oldContact, Contact newContact) {
        if (contactExists(oldContact)){
            if (newContact.getName() == null || newContact.getName().trim().length()== 0) {
                System.out.println("Invalid name");
            } else if(contactExists(newContact) && (!newContact.getName().equalsIgnoreCase(oldContact.getName()))) {
                System.out.println("Contact with name " + oldContact.getName() + "already exists. Update was not successful.");
            } else {
                contacts.set(contacts.indexOf(getContact(oldContact)), newContact);
                System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
            }
        } else {
            System.out.println("Unable to locate that contact.");
        }
    }

    public void removeMobileContact(Contact contact) {
        if (contactExists(contact)) {
            contacts.remove(getContact(contact));
            System.out.println(contact.getName() + ", was removed.");
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Contact does not exist");
        }
    }

    public void findMobileContact(Contact contact) {
        if (contactExists(contact)) {
            System.out.println("Name: " + contact.getName() + " phone number is " + getContact(contact).getPhoneNumber());
        } else {
            System.out.println(contact.getName() + " was not found in the contact list.");
        }
    }

    private boolean contactExists(Contact contact) {
        Contact tempContact = getContact(contact);
        if (tempContact == null) {
            return false;
        } else {
            return true;
        }
    }

    private Contact getContact(Contact contact) {
        String contactName = contact.getName();
        for (Contact currentContact : contacts) {
            if (currentContact.getName().equalsIgnoreCase(contactName)) {
                return currentContact;
            }
        }

        return null;
    }
}