import java.sql.SQLOutput;
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

    private Bank activeBank;


    public void checkAccounts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! ");
        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        for (User users : knownUsers) {
            if (name.equals("admin") && password.equals("admin")) {
                Menu.principalMenu();
            } else if (name.equals(users.getUserName()) && password.equals(users.getPassword())) {
                Menu.printMenu();
            } else {
                System.out.println("You don't have an user. ");
            }
        }

    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = scanner.next();
        System.out.println("Enter a password: ");
        String password = scanner.next();
        User userAdmin = new User("admin", "admin", true);
        knownUsers.add(userAdmin);
        for (User users : knownUsers) {
//            if (knownUsers.contains(users)){
            if (userAdmin.getUserName().equals(name) && userAdmin.getPassword().equals(password)) {
                Menu.principalMenu();
            } else if (users.getUserName().equals(name) && users.getPassword().equals(password)) {
                shortAccountMenu();
            } else {
                System.out.println("You don't have an user. Contact an admin");

            }
        }

    }

//    public void createUser(String firstName, String lastName, boolean isAdmin){
//        User newUser = new User(firstName,lastName,false);
//        knownUsers.add(newUser);
//    }

    public void createBank() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a bank name: ");
        String bankName = scanner.next();
        Bank newBank = new Bank(bankName);
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
    }


    public void createUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = scanner.next();
        System.out.println("Enter a password: ");
        String password = scanner.next();

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


    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter  first name: ");
        String firstName = scanner.next();
        System.out.println("Enter  last name: ");
        String lastName = scanner.next();
        System.out.println("Enter a value");
        double value = scanner.nextDouble();
        System.out.println("Enter a currency: ");
        System.out.println( "LEI"+"\n"+
                            "EURO"+"\n"+
                            "DOLLAR"+"\n"+
                            "LIRA");
        System.out.println("Enter a choice: ");
        String currency = scanner.next();
        switch (currency){
            case "LEI","lei":
                Curency lei = Curency.LEI;
                break;
            case "EURO","euro":
                Curency euro = Curency.EURO;
                break;
            case "DOLLAR","dollar":
                Curency dollar = Curency.DOLLAR;
                break;
            case "LIRA","lira":
                Curency lira = Curency.LIRA;
                break;
            default:
                System.out.println("Enter a true currency");
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
            login();
        }

    }
//        boolean exists = false;

//
//        System.out.println("Enter account name: ");
//        String accountName = scanner.next();
//
//        System.out.println("Enter account password");
//        String passwordAccount = scanner.next();
//
//        for (Account account : accountList){
//            if (account.getName().equals(accountName) && account.getPasswordKey().equals(passwordAccount)){
//                exists = true;
//                break;
//            }
//        }
//        if (exists){
//            System.out.println("An account with this name already exists");
//            createAccount();
//        }else {
//
//            Account account =  new Account(accountName,passwordAccount);
//            accountList.add(account);
//            System.out.println("An account was created successfully");
//        }


    public Bank getActiveBank() {
        return activeBank;
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
    }

    public void shortUserMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1-Create another user.");
        System.out.println("2-Print user list.");
        System.out.println("3-Select a user.");
        System.out.println("4-Back to menu.");
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
                        System.out.println(user.getUserName());
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
                    System.out.println("You selected " + userSelected.getUserName() + " " +  userSelected.getPassword());
                    createAccount();
//                        if (  knownUsers.contains(userSelected.getUserName())){
//
//                        }
                    break;
                } else {
                    System.out.println("Invalid bank selection. Try again. ");
                }
            case 4:
                Menu.principalMenu();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                shortUserMenu();
                break;

        }
    }

    public void shortAccountMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("1-Create another account.");
        System.out.println("2-Print account list.");
        System.out.println("3-Select an account.");
        System.out.println("4-Back to menu.");
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
//                    for (int i = 0; i < accountList.size(); i++) {
//                        System.out.println((i + 1) + " -" + accountList.get(i).getFirstName() && accountList.get(i).getFirstName() && accountList.get(i).getValue() && accountList.get(i).getCurrency());
//                    }
                    for (Account account : accountList) {
                        String accounts = account.getFirstName() +" "+ account.getFirstName() +" "+ account.getValue() +" "+ account.getCurrency();
                        System.out.println("-" + accounts);
                    }
                } else {
                    System.out.println("The account list is empty.");
                }
                System.out.println();
                shortUserMenu();
                break;
            case 3:
                for (int i = 0; i < accountList.size(); i++) {
                    System.out.println((i + 1) + "-" + accountList.get(i).getFirstName() + " " + accountList.get(i).getLastName() + " " + accountList.get(i).getValue() + " " + accountList.get(i).getCurrency());
                }
                System.out.println("Enter the number for account: ");
                int userChoice = scanner.nextInt();

                if (userChoice > 0 && userChoice <= bankList.size()) {
                    Account accountSelected = accountList.get(userChoice - 1);
                    System.out.println("You selected " + accountSelected.getFirstName() +" "+ accountSelected.getLastName() +" "+ accountSelected.getValue() +" "+ accountSelected.getCurrency());
                    System.out.println("What do you want to do: ");
                    System.out.println("1-Deposit money");
                    System.out.println("2-Withdraw money");
                    System.out.println("3-Show the current value");
                    System.out.println("4-Back to account");
                    int choiceMenu = scanner.nextInt();
                    switch (choiceMenu){
                        case 1:
                            System.out.println("Enter the value you want to deposit");
                            int value = scanner.nextInt();
                            Deposit deposit = new Deposit(value);
                            deposit.makeTransaction(value);
                            break;
                        case 2:
                            System.out.println("Enter the value you want to withdraw");
                             value = scanner.nextInt();
                            Withdraw withdraw = new Withdraw(value);
                            withdraw.makeTransaction(value);
                            break;
                        case 3:
                            for (Account account:accountList) {
                                System.out.println(account.getTransactionList());
                            }
                        case 4:
                            shortAccountMenu();
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                            break;


                    }
//                        if (  knownUsers.contains(userSelected.getUserName())){
//
//                        }
                } else {
                    System.out.println("Invalid bank selection. Try again. ");
                }
            case 4:
                Menu.principalMenu();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                shortUserMenu();
                break;

        }
    }

    }

//            Scanner scanner = new Scanner(System.in);
//            System.out.println("What do you want to do?");
//            System.out.println("1-Create another user.");
//            System.out.println("2-Print user list.");
//            System.out.println("3-Back to menu.");
//            System.out.println();
//            System.out.println("Enter a choice: ");
//            int choice = scanner.nextInt();
//            if (choice == 1) {
//                createUser();
//            } else if (choice == 2) {
//                for (User userList : knownUsers) {
//                    System.out.println("The bank list is: " + userList.getName());
//                    System.out.println();
//                }
//                shortUserMenu();
//            } else {
//                Menu.principalMenu();
//            }
//        }
//    }





//    public static void addBank(){
//        boolean exists = false;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter bank name: ");
//        String newBank = scanner.nextLine();
//
//        for(Bank banks : bankList) {
//            if (banks.name.equals(newBank)){
//                exists = true;
//                break;
//            }
//        }
//
//        if (exists){
//            System.out.println("The bank already exists");
//        } else {
//            Bank bank = new Bank(newBank);
//            bankList.add(bank);
//            System.out.println("A bank was created successfully");
//            bank.shortMenu();
//        }



