import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {



    static BankManager bankManager = new BankManager();

    public static void principalMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        boolean exit = false;
        int choice;
        while (!exit) {
            exit = true;
            System.out.println("What would you like to do?\n");
            System.out.println("  1. Create a bank");
            System.out.println("  2. Create an user");
            System.out.println("  3. Create an account");
            System.out.println("  4. Quit");
            System.out.println();
            System.out.println("Enter Choice: ");

            choice = scanner.nextInt();


            switch (choice) {
                case 1:

//                    Bank.addBank();
                    bankManager.createBank();
                    break;

                case 2:
//                    User.createUser();

                    bankManager.createUser();
                    break;

                case 3:
//                    Account.createAccount();
//                    Account.checkAccount();
                    bankManager.createAccount();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-4");

            }
        }
    }
//    private static Account getAccountName(String name, String password){
//        for (Account account : Menu.accountList){
//            if (Objects.equals(account.getName(), name) && Objects.equals(account.getPasswordKey(), password)){
//                return account;
//            }
//        }
//        return null;
//    }
//    private static User getUserByPin(int pin) {
//        for (User user : Menu.userList) {
//            if (user.getPin() == pin) {
//                return user;
//            }
//        }
//        return null;
//    }


    public static void printMenu() {

        Scanner scanner = new Scanner(System.in);
        int choice;


        boolean exit = false;
        while (!exit) {


                System.out.println("Welcome. What would you like to do?");
                System.out.println("  1. Show account Transaction history");
                System.out.println("  2. Withdraw");
                System.out.println("  3. Deposit");
                System.out.println("  4. Exchange");
                System.out.println("  5. Exit");
                System.out.println();
                System.out.println("Enter Choice: ");
                choice = scanner.nextInt();


            switch (choice) {

                case 1:
                    List<Transaction> transactionList = new ArrayList<>();
                    System.out.println(transactionList);
                    break;
                case 2:
                    System.out.println("Enter a value to withdraw: ");
                    int value = scanner.nextInt();
                    Withdraw withdraw = new Withdraw(value);
                    withdraw.makeTransaction(value);
                    break;
                case 3:
                    System.out.println("Enter the value you want to deposit");
                     value = scanner.nextInt();
                    Deposit deposit = new Deposit(value);
                    break;
                case 4:

                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-4");
            }

        }
    }
}
