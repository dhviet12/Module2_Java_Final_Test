package view;

import model.Contact;
import service.ContactManagement;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ContactManagement contactManagement = new ContactManagement();

    public static void main(String[] args) {
        int choice;
        do {
            showListMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        contactManagement.showAllContact();
                        break;
                    case 2:
                        System.out.println("Enter number of contact you want to add");
                        int number = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < number; i++) {
                            Contact contact = getContact();
                            contactManagement.addContact(contact);
                            System.out.println("Successfully added");
                        }
                        break;
                    case 3:
                        System.out.println("Enter phone number you want to edit");
                        String phoneNumber = scanner.nextLine();
                        Contact newContact = getContact();
                        contactManagement.editContact(phoneNumber, newContact);
                        System.err.println("Successfully edit");
                        break;
                    case 4:
                        System.out.println("Enter phone number you want to remove");
                        phoneNumber = scanner.nextLine();
                        contactManagement.removeContact(phoneNumber);
                        break;
                    case 5:
                        System.out.println("Enter phone number you want to find");
                        phoneNumber = scanner.nextLine();
                        contactManagement.findContactByPhoneNumber(phoneNumber);
                        break;
                    case 6:
                        System.out.println("Enter full name of contact you want to find");
                        String fullName = scanner.nextLine();
                        contactManagement.findContactByFullName(fullName);
                        break;
                    case 7:
                        contactManagement.writeFile();
                        break;
                    case 8:
                        contactManagement.readFile();
                        break;
                    case 0:
                        System.exit(0);

                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    private static Contact getContact() {
        String phoneNumber;
        do {
            System.out.println("Enter phone number with 10 or 11 numbers");
            phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches(REGEX_PHONE_NUMBER)) {
                System.err.println("Invalid phone number");
            }
        } while (!phoneNumber.matches(REGEX_PHONE_NUMBER));
        System.out.println("Enter group of contact");
        String group = scanner.nextLine();
        System.out.println("Enter full name of contact");
        String fullName = scanner.nextLine();
        String gender;
        do {
            System.out.println("Enter gender");
            gender = scanner.nextLine();
            if (!gender.matches(REGEX_VALID_CHARACTERS)) {
                System.err.println("Gender is not allowed digit");
            }
        } while (!gender.matches(REGEX_VALID_CHARACTERS));
        System.out.println("Enter address of contact");
        String address = scanner.nextLine();
        String birthday;
        do {
            System.out.println("Enter birthday dd/mm/yyyy");
            birthday = scanner.nextLine();
            if (!birthday.matches(REGEX_VALID_BIRTHDAY)) {
                System.err.println("Invalid birthday");
            }
        } while (!birthday.matches(REGEX_VALID_BIRTHDAY));
        String email;
        do {
            System.out.println("Enter email");
            email = scanner.nextLine();
            if (!email.matches(REGEX_VALID_EMAIL)) {
                System.err.println("Invalid email");
            }
        } while (!email.matches(REGEX_VALID_EMAIL));
        return new Contact(phoneNumber, group, fullName, gender, address, birthday);
    }

    private static void showListMenu() {
        System.out.println("--------------------");
        System.out.println("Menu");
        System.out.println("1.Show list contact");
        System.out.println("2.Add new contact");
        System.out.println("3.Edit contact");
        System.out.println("4.Remove contact");
        System.out.println("5.Find contact by phone number");
        System.out.println("6.Find contact by full name");
        System.out.println("7.Write file");
        System.out.println("8.Read file");
        System.out.println("0.Exit");
        System.out.println("--------------------");
        System.out.println("Enter your choice");
    }

    private static final String REGEX_PHONE_NUMBER = "^[\\d]{10,11}$";
    private static final String REGEX_VALID_CHARACTERS = "^[A-Za-z]+[A-za-z]$";
    private static final String REGEX_VALID_BIRTHDAY = "^[\\d]{1,2}(/)[\\d]{1,2}(/)[\\d]{4}$";
    private static final String REGEX_VALID_EMAIL = "^[_A-Za-z0-9]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
}
