package ro.danut.banking.manager;

import java.util.Scanner;


public class Menu {

    static BankManager bankManager = new BankManager();

    public static void principalMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        boolean exit = false;
        int choice;

        while (!exit) {

            System.out.println("What would you like to do?\n");
            System.out.println("  1. Create a bank");
            System.out.println("  2. Quit");
            System.out.println();
            System.out.println("Enter Choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bankManager.createBank();
                        break;
                    case 2:
                        System.out.println("Quit");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose 1-2");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                principalMenu();
            }

        }
    }
}
