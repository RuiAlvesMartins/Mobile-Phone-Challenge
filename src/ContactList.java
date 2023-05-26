import java.util.ArrayList;

public class ContactList {

    private static ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    private static ArrayList<Contacts> getContactList() {
        return contactList;
    }

    public void contactListMenu() {
        boolean exit = false;
        int option = 0;
        System.out.println("");
        System.out.println("/////////////////////");
        System.out.println("//  CONTACTS LIST  //");
        System.out.println("/////////////////////");
        contactsListInstructions();
        while(!exit) {
            System.out.println(" ");
            System.out.println("What do you want to do?");
            System.out.println("Press 0 for instructions.\r");
            option = MobilePhone.validIntInput(6, 0);

            switch(option) {
                case 0:
                    contactsListInstructions();
                    break;
                case 1:
                    printContact();
                    break;
                case 2:
                    querryContact();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    exit = true;
                    System.out.println("");
                    System.out.println("/////////////////");
                    System.out.println("//  MAIN MENU  //");
                    System.out.println("/////////////////");
                    break;
            }
        }
    }

    private void contactsListInstructions() {
        System.out.println("\n Press: ");
        System.out.println("\t 1 - to present the contacts list;");
        System.out.println("\t 2 - to look up a contact;");
        System.out.println("\t 3 - to add a new contact;");
        System.out.println("\t 4 - to edit an existing contact;");
        System.out.println("\t 5 - to remove a contact from the list;;");
        System.out.println("\t 6 - to return to the main menu.");
    }

    private void addContact() {
        System.out.println("");
        System.out.println("ADD CONTACT");
        System.out.println("Enter name of contact you want to add: \r");
        String name = MobilePhone.input();
        System.out.println("Enter the number of the contact you want to add: \r");
        int number = MobilePhone.validIntInput(999999999, 100000000);
        if (!existingContact(name, number)) {
            Contacts newContact = new Contacts(name, number);
            contactList.add(newContact);
            System.out.println(newContact.getName()+" added to contacts list.");
        } else {
            System.out.println("Contact already exists!");
            System.out.println("Process aborted.");
        }

    }

    private void printContact() {
        System.out.println("");
        System.out.println("CONTACTS LIST");
        System.out.println(contactList.size()+" contacts:");
        System.out.println("");
        for (int i=0; i<contactList.size(); i++) {
            String name = contactList.get(i).getName();
            int number = contactList.get(i).getNumber();
            System.out.println("\t #" + (i+1) + ". " + name + ": " + number);
        }
    }

    private int querryContact(String searchName) {
        int rank = -1;
        for (int i=0; i<contactList.size(); i++) {
            if (!contactList.get(i).getName().equals(searchName)) {
            }
            else {
                rank = i;
            }
        }
        //System.out.println(rank);
        return rank;
    }

    private int querryContact(int searchNumber) {
        int rank = -1;
        for (int i=0; i<contactList.size(); i++) {
            if (contactList.get(i).getNumber() != searchNumber) {}
            else {
                rank = i;
            }
        }
        //System.out.println(rank);
        return rank;
    }

    private Contacts getContact(int rank) {
        return contactList.get(rank);
    }

    private void querryContact() {
        System.out.println("");
        System.out.println("QUERRY CONTACT");
        System.out.println("Enter name of contact you want to look up: \r");
        int rank = querryContact(MobilePhone.input());
        if (rank >= 0) {
            Contacts contact = getContact(rank);
            System.out.println(contact.getName()+" found on contacts list.");
            System.out.println("Number: "+contact.getNumber());
        }
        else {System.out.println("Contact not found contacts list.");}
    }

    private void editContact() {
        System.out.println("");
        System.out.println("MODIFY CONTACT");
        System.out.println("Enter name of contact to be edited: \r");
        int rank = querryContact(MobilePhone.input());

        if (rank >= 0) {
            Contacts contactToBeModified = getContact(rank);
            String oldContactName = contactToBeModified.getName();
            int oldContactNumber = contactToBeModified.getNumber();

            System.out.println("Editing "+oldContactName+": "+oldContactNumber);
            System.out.println("Insert the new name: \r");
            String newContactName = MobilePhone.input();
            System.out.println("Insert the new number: \r");
            int newContactNumber = MobilePhone.validIntInput(999999999, 100000000);

            if (!existingContact(newContactName, newContactNumber)) {
                contactToBeModified.setName(newContactName);
                contactToBeModified.setNumber(newContactNumber);
                System.out.println("");
                System.out.println("Contact Edited!");
                System.out.println(oldContactName+" --> "+contactToBeModified.getName());
                System.out.println(oldContactNumber+" --> "+contactToBeModified.getNumber());
            } else {
                System.out.println("Contact already exists!");
                System.out.println("Process aborted.");
            }

        } else {
            System.out.println("Contact not found contacts list.");
            System.out.println("Process aborted.");
        }
    }

    private void removeContact() {
        System.out.println("");
        System.out.println("REMOVE CONTACT");
        System.out.println("Enter name of contact to be removed: \r");
        int rank = querryContact(MobilePhone.input());
        if (rank >= 0) {
            Contacts contactToBeDeleted = getContact(rank);
            String contactToBeDeletedName = contactToBeDeleted.getName();
            int contactToBeDeletedNumber = contactToBeDeleted.getNumber();
            System.out.println("");
            System.out.println(contactToBeDeletedName+": "+contactToBeDeletedNumber+" will be removed from your contacts list.");
            System.out.println("Do you wish to proceed?");
            System.out.println("Press 1 to proceed. Press 0 to abort.");
            int deleteConfirm = MobilePhone.validIntInput(1, 0);
            if (deleteConfirm == 1) {
                contactList.remove(contactToBeDeleted);
                System.out.println(contactToBeDeletedName+" removed from contacts list.");
            }
            else {System.out.println("Process aborted.");}
        } else {
            System.out.println("Contact not found contacts list.");
            System.out.println("Process aborted.");
        }
    }

    private boolean existingContact(String name, int number) {
        int nameRank = querryContact(name);
        int numberRank = querryContact(number);
        if (nameRank >= 0 || numberRank >= 0) {return true;}
        return false;
    }

}
