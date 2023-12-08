import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account implements ShowContent {

    private String firstName;
    private String lastName;

    private double value;

    private String currency;

    List<Transaction>transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public Account(String firstName, String lastName, double value, String currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.value = value;
        this.currency = currency;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public void showContent() {
        System.out.println("First name is: " + this.getFirstName() + "\n" +
                "Last name is: " + this.getLastName() + "\n" +
                "the value is: " + this.value + "\n" +
                "the currency is: " + this.currency +
                "---------------------------------------");
    }

//    public static void checkAccount(){
//
//        Account newAccount = new Account();
//        accountList.add( newAccount);
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter your account name: ");
//            String accountName = scanner.nextLine();
//            System.out.println("Enter your account password: ");
//            String accountPassword = scanner.nextLine();
//
//            boolean exists = false;
//        for (Account account : accountList){
//            if (account.getName().equals(accountName) && account.getPasswordKey().equals(accountPassword)){
//                exists = true;
//                break;
//            }
//        }
//        if(exists){
////            if(accountName.equals("admin")&&accountPassword.equals("admin"))
//            if(newAccount.getName().equals("admin") && newAccount.getPasswordKey().equals("admin")){
//                System.out.println("You are an admin");
//                System.out.println();
//                Menu.principalMenu();
//
//            }
//            else {
//                Menu.printMenu();
//                exists = false;
//            }
//        }else {
//            System.out.println("You don't have an account");
//            System.out.println("You can call an admin to create one");
//            System.out.println();
//            Account.checkAccount();
//            exists = false;
//
//        }
//
//        }

//    public static void createAccount(){
//        boolean exists = false;
//        Scanner scanner =  new Scanner(System.in);
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
//
//
//        System.out.println(" 1-Enter an account");
//        System.out.println(" 2-Print account list:");
//        System.out.println("3- Back to menu");
//        System.out.println("Enter a choice");
//        int choice = scanner.nextInt();
//
//        if (choice == 1) {
//            checkAccount();
//        }else if(choice == 2) {
//            for (Account account : accountList) {
//                System.out.println(account.showAccount());
//            }
//        }else{
//            Menu.principalMenu();
//        }
//
//    }

//    public String showAccount() {
//        return "First name is: " + this.getFirstName() + "\n" +
//                "Last name is: " + this.getLastName() + "\n" +
//                "the value is: " + this.value + "\n" +
//                "the currency is: " + this.currency +
//                "---------------------------------------";
//
//    }

}


