package service;

import model.Contact;
import storage.WriteAndReadFile;

import java.util.ArrayList;
import java.util.List;

public class ContactManagement {
    private static final String FILE_PATH = "contact.dat";
    private List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void showAllContact() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    public void editContact(String phoneNumber, Contact newContact) {
        boolean notFoundInList = true;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                notFoundInList = false;
                contactList.set(i, newContact);
            }
        }
        if (notFoundInList) {
            System.err.println("Not found this contact in list");
        }
    }

    public void removeContact(String phoneNumber) {
        boolean notFoundInList = true;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                notFoundInList = false;
                contactList.remove(i);
            }
        }
        if (notFoundInList) {
            System.err.println("Not found this contact in list");
        }
    }

    public void findContactByPhoneNumber(String phoneNumber) {
        boolean notFoundInList = true;
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                notFoundInList = false;
                System.out.println(contact);
            }
        }
        if (notFoundInList) {
            System.err.println("Not found this contact in list");
        }
    }

    public void findContactByFullName(String fullName) {
        boolean notFoundInList = true;
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equalsIgnoreCase(fullName)) {
                notFoundInList = false;
                System.out.println(contact);
            }
        }
        if (notFoundInList) {
            System.err.println("Not found this contact in list");
        }
    }

    public void writeFile() {
        WriteAndReadFile.writeObjectToFile(FILE_PATH, contactList);
    }

    public void readFile() {
        contactList = (List<Contact>) WriteAndReadFile.readObjectFromFile(FILE_PATH);
    }
}
