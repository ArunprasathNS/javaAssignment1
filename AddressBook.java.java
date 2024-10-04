import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookApp {

   
    static class Contact {
        private String name;
        private String phoneNumber;
        private String emailAddress;

        
        public Contact(String name, String phoneNumber, String emailAddress) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.emailAddress = emailAddress;
        }

        
        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

  
        public void setName(String name) {
            this.name = name;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        
     
        public String toString() {
            return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
        }
    }

  
    static class AddressBook {
        private List<Contact> contacts;

        
        public AddressBook() {
            contacts = new ArrayList<>();
        }

       
        public void addContact(Contact contact) {
            contacts.add(contact);
        }

        public void viewContacts() {
            if (contacts.isEmpty()) {
                System.out.println("No contacts available.");
            } else {
                for (Contact contact : contacts) {
                    System.out.println(contact);
                }
            }
        }

        
        public void searchContactByName(String name) {
            boolean found = false;
            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    System.out.println(contact);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Contact not found.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean running = true;

        while (running) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Add a new contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                   
                    addressBook.viewContacts();
                    break;
                case 3:
                   
                    System.out.print("Enter the name of the contact to search: ");
                    String searchName = scanner.nextLine();
                    addressBook.searchContactByName(searchName);
                    break;
                case 4:
                   
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
