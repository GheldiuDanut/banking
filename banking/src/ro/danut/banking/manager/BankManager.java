package ro.danut.banking.manager;

import ro.danut.banking.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankManager {

    List<User> knownUsers = new ArrayList<>();

    List<Bank> bankList = new ArrayList<>();

    List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }


    private Account accountSelected;


    public void login() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            exit = true;
            System.out.println("Login");
            System.out.println("Enter your name: ");
            String name = scanner.next();
            System.out.println("Enter your password: ");
            String password = scanner.next();
            User userAdmin = new User("admin", "admin", true);
            knownUsers.add(userAdmin);
            for (User users : knownUsers) {
                if (userAdmin.getUserName().equals(name) && userAdmin.getPassword().equals(password)) {
                    Menu.principalMenu();
                    break;
                } else if (users.getUserName().equals(name) && users.getPassword().equals(password)) {
                    transactionMenu();
                    break;
                } else {
                    System.out.println("The username or password is not valid. Try again.");
                    login();
                    break;
                }
            }

        }
    }

    public void createBank() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a bank.");
        System.out.println("Enter a bank name: ");
        String bankName = scanner.next();
        Bank newBank = new Bank(bankName);
        try {
            boolean shouldCreateBank = true;

            for (Bank banks : bankList) {
                if (bankName.equals(banks.getName())) {
                    System.out.println("A bank with this name already exist");
                    shouldCreateBank = false;
                }
            }
            if (shouldCreateBank) {
                bankList.add(newBank);
            }
            shortBankMenu();
        } catch (Exception e) {
            createBank();
        }
    }


    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create an user.");
        System.out.println("Enter a name: ");
        String name = scanner.next();
        System.out.println("Enter a password: ");
        String password = scanner.next();

        try {
            User user = new User(name, password, false);
            boolean shouldCreateUser = true;
            for (User usersFromList : knownUsers) {
                if (usersFromList.getUserName().equals(user.getUserName())) {
                    System.out.println("An user with this name and password already exist");
                    shouldCreateUser = false;
                    break;
                }
            }
            if (shouldCreateUser) {
                knownUsers.add(user);
                System.out.println("User created successfully.");
                shortUserMenu();
            }
        } catch (Exception e) {
            createUser();
        }
    }

    public void createAccount() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create an account.");
            System.out.println("Enter  first name: ");
            String firstName = scanner.next();
            System.out.println("Enter  last name: ");
            String lastName = scanner.next();
            System.out.println("Enter a value");
            double value = scanner.nextDouble();
            System.out.println("Enter a currency: ");
            System.out.println("RON" + "\n" +
                    "EUR" + "\n" +
                    "USD" + "\n" +
                    "GBP");
            System.out.println("Enter a choice: ");
            String currency = scanner.next();
            switch (currency) {
                case "RON", "ron":
                    Curency ron = Curency.RON;
                    break;
                case "EUR", "eur":
                    Curency eur = Curency.EUR;
                    break;
                case "USD", "usd":
                    Curency usd = Curency.USD;
                    break;
                case "GBP", "gbp":
                    Curency gbp = Curency.GBP;
                    break;
                default:
                    System.out.println("Enter a true currency");
                    createAccount();
                    break;
            }
            boolean shouldCreateAccount = true;


            Account account = new Account(firstName, lastName, value, currency);
            for (Account accounts : accountList) {
                if (account.getFirstName().equals(accounts.getFirstName()) && account.getLastName().equals(accounts.getLastName())) {
                    System.out.println("An account with this value exists ");
                    shouldCreateAccount = false;
                }
            }
            if (shouldCreateAccount) {
                accountList.add(account);
                shortAccountMenuForAdmin();
            }
        } catch (Exception e) {
            createAccount();
        }
    }

    public void shortBankMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1-Create another bank.");
        System.out.println("2-Print bank list.");
        System.out.println("3-Select a bank.");
        System.out.println("4-Back to menu.");
        System.out.println();
        System.out.println("Enter a choice: ");
        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                createBank();
            } else if (choice == 2) {
                for (int i = 0; i < bankList.size(); i++) {
                    System.out.println((i + 1) + "-" + bankList.get(i).getName());
                }
                shortBankMenu();
            } else if (choice == 3) {
                for (int i = 0; i < bankList.size(); i++) {
                    System.out.println((i + 1) + "-" + bankList.get(i).getName());
                }
                System.out.println("Enter the number for bank: ");
                int bankChoice = scanner.nextInt();

                if (bankChoice > 0 && bankChoice <= bankList.size()) {
                    Bank bankSelected = bankList.get(bankChoice - 1);
                    System.out.println("You selected " + bankSelected.getName());
                    createUser();
                } else {
                    System.out.println("Invalid bank selection. Try again. ");
                }
            } else {
                Menu.principalMenu();
            }
        } catch (Exception e) {
            shortBankMenu();
        }
    }

    public void shortUserMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("1-Create another user.");
            System.out.println("2-Print user list.");
            System.out.println("3-Select a user.");
            System.out.println("4-Back to bank menu.");
            System.out.println();
            System.out.println("Enter a choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    if (!knownUsers.isEmpty()) {
                        System.out.println("User list:");
                        for (User user : knownUsers) {
                            System.out.println("-" + user.getUserName());
                        }
                    } else {
                        System.out.println("The user list is empty.");
                    }
                    System.out.println();
                    shortUserMenu();
                    break;
                case 3:
                    for (int i = 0; i < knownUsers.size(); i++) {
                        System.out.println((i + 1) + "-" + knownUsers.get(i).getUserName() + " " + knownUsers.get(i).getPassword());
                    }
                    System.out.println("Enter the number for user: ");
                    int userChoice = scanner.nextInt();

                    if (userChoice > 0 && userChoice <= bankList.size()) {
                        User userSelected = knownUsers.get(userChoice - 1);
                        System.out.println("You selected " + userSelected.getUserName() + " " + userSelected.getPassword());
                        createAccount();
                        break;
                    } else {
                        System.out.println("Invalid bank selection. Try again. ");
                    }
                case 4:
                    shortBankMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    shortUserMenu();
                    break;

            }
        } catch (Exception e) {
            shortUserMenu();
        }
    }
    public void shortAccountMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("1-Create another account.");
            System.out.println("2-Print account list.");
            System.out.println("3-Select an account.");
            System.out.println("4-Back to login.");
            System.out.println();
            System.out.println("Enter a choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (!accountList.isEmpty()) {
                        System.out.println("Account list:");
                        for (Account account : accountList) {
                            String accounts = account.getFirstName() + " " + account.getFirstName() + " " + account.getValue() + " " + account.getCurrency();
                            System.out.println("-" + accounts);
                        }
                    } else {
                        System.out.println("The account list is empty.");
                    }
                    System.out.println();
                    shortUserMenu();
                    break;
                case 3:
                    transactionMenu();
                    break;
                case 4:
                    login();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    shortUserMenu();
                    break;

            }
        } catch (Exception e) {
            shortAccountMenu();
        }
    }

    public void shortAccountMenuForAdmin() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println("1-Create another account.");
            System.out.println("2-Print account list.");
            System.out.println("3-Login.");
            System.out.println();
            System.out.println("Enter a choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (!accountList.isEmpty()) {
                        System.out.println("Account list:");
                        for (Account account : accountList) {
                            String accounts = account.getFirstName() + " " + account.getFirstName() + " " + account.getValue() + " " + account.getCurrency();
                            System.out.println("-" + accounts);
                        }
                    } else {
                        System.out.println("The account list is empty.");
                    }
                    System.out.println();
                    shortUserMenu();
                    break;
                case 3:
                    login();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    shortUserMenu();
                    break;

            }
        } catch (Exception e) {
            shortAccountMenuForAdmin();
        }
    }

    public void createAnotherTransaction() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do: ");
            System.out.println("1-Deposit money");
            System.out.println("2-Withdraw money");
            System.out.println("3-Show the current value");
            System.out.println("4-Back to account");
            int choiceMenu = scanner.nextInt();
            switch (choiceMenu) {
                case 1:
                    System.out.println("Enter the value you want to deposit");
                    int value = scanner.nextInt();
                    Deposit deposit = new Deposit(value);
                    deposit.makeTransaction(accountSelected);
                    createAnotherTransaction();
                    break;
                case 2:
                    System.out.println("Enter the value you want to withdraw");
                    value = scanner.nextInt();
                    Withdraw withdraw = new Withdraw(value);
                    withdraw.makeTransaction(accountSelected);
                    createAnotherTransaction();
                    break;
                case 3:
                    for (Account account : accountList) {
                        System.out.println(accountSelected.getTransactionList());
                    }
                    createAnotherTransaction();
                    break;
                case 4:
                    shortAccountMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } catch (Exception e) {
            createAnotherTransaction();
        }
    }

    public void transactionMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < accountList.size(); i++) {
                System.out.println((i + 1) + "-" + accountList.get(i).getFirstName() + " " + accountList.get(i).getLastName() + " " + accountList.get(i).getValue() + " " + accountList.get(i).getCurrency());
            }
            System.out.println("Enter the number for account: ");
            int userChoice = scanner.nextInt();

            if (userChoice > 0 && userChoice <= bankList.size()) {
                accountSelected = accountList.get(userChoice - 1);
                System.out.println("You selected " + accountSelected.getFirstName() + " - " + accountSelected.getLastName() + " - " + accountSelected.getValue() + " - " + accountSelected.getCurrency());
                System.out.println("What do you want to do: ");
                System.out.println("1-Deposit money");
                System.out.println("2-Withdraw money");
                System.out.println("3-Show the current value");
                System.out.println("4-Back to account");
                int choiceMenu = scanner.nextInt();
                switch (choiceMenu) {
                    case 1:
                        System.out.println("Enter the value you want to deposit");
                        int value = scanner.nextInt();
                        if (value == scanner.nextInt()) {
                            Deposit deposit = new Deposit(value);
                            deposit.makeTransaction(accountSelected);
                            createAnotherTransaction();
                        }else {
                            System.out.println("Enter a true value to deposit");
                            transactionMenu();
                        }
                        break;
                    case 2:
                        System.out.println("Enter the value you want to withdraw");
                        value = scanner.nextInt();
                        if (value == scanner.nextInt()){
                        Withdraw withdraw = new Withdraw(value);
                        withdraw.makeTransaction(accountSelected);
                        break;
                        }else {
                            System.out.println("Enter a true value to withdraw");
                            transactionMenu();
                        }
                    case 3:
                        for (int i = 0; i < accountList.size() - 1; i++) {
                            System.out.println(accountSelected.getTransactionList());
                        }
                        createAnotherTransaction();
                        break;
                    case 4:
                        shortAccountMenu();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } else {
                System.out.println("Invalid selection. Try again. ");
            }
        } catch (Exception e) {
            transactionMenu();
        }
    }
}
