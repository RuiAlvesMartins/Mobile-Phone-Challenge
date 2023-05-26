import java.util.Scanner;

public class MobilePhone {

    private static Scanner scan = new Scanner(System.in);
    ContactList contactList = new ContactList();

    private void mainMenu() {
        boolean exit = false;
        int option = 0;
        System.out.println("");
        System.out.println("/////////////////");
        System.out.println("//  MAIN MENU  //");
        System.out.println("/////////////////");
        mainMenuInstructions();
        while(!exit) {
            System.out.println(" ");
            System.out.println("What do you want to do?");
            System.out.println("Press 0 for instructions.\r");
            option = MobilePhone.validIntInput(4, 0);

            switch(option) {
                case 0:
                    mainMenuInstructions();
                    break;
                case 1:
                    System.out.println("Work in progress");
                    break;
                case 2:
                    contactList.contactListMenu();
                    break;
                case 3:
                    System.out.println("Work in progress");
                    break;
                case 4:
                    exit = true;
                    System.out.println("Locking phone . . . ");
                    break;
            }
        }
    }

    private void mainMenuInstructions() {
        System.out.println("\n Press: ");
        System.out.println("\t 1 - to access Call Registry;");
        System.out.println("\t 2 - to access Contacts List;");
        System.out.println("\t 3 - to access Messages;");
        System.out.println("\t 4 - to lock phone.");
    }

    public void phoneUnlock() {
        System.out.println("Phone unlocked.");
        mainMenu();
    }

    public static String input() {
        String str = scan.nextLine();
        return str;
    }

    public static int validIntInput(int max, int min) {
        boolean validInt = false;
        int n = min-1;
        while (!validInt) {
            n = scan.nextInt();
            scan.nextLine();
            if (n <= max && n >= min) {
                validInt = true;
            }
            else {
                System.out.println("Invalid input!");
                System.out.println("Please insert a whole number between "+min+" and "+max+".");
            }
        }
        return n;
    }

}
