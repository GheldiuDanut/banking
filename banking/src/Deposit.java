import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Deposit implements Transaction {

    int value;
    private Account account;
    private User user;
    private BankManager bankManager;


    public Deposit( int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public void makeTransaction(int depositAmount) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the value you want to deposit");
//        int value = scanner.nextInt();
        System.out.println( bankManager.getAccountList());
        if(depositAmount > 0){
            Deposit deposit = new Deposit(depositAmount);

            account.transactionList.add(deposit);
            System.out.println("Successful deposit " + depositAmount);
        }else {
            System.out.println("You can't deposit money in this account. Enter a value greater than 0");
        }

        for (Transaction transaction : account.transactionList){
            System.out.println(transaction);
        }
    }

//    public static void depositMoney(){
//        List<Transaction> transactionList = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the value you want to deposit");
//        int value = scanner.nextInt();
//
//
//        if(value > 0){
//            Deposit deposit = new Deposit(value);
//            transactionList.add(deposit);
//            System.out.println("Successful deposit " + value);
//        }else {
//            System.out.println("You can't deposit money in this account. Enter a value greater than 0");
//        }
//
//        for (Transaction transaction : transactionList){
//            System.out.println(transaction);
//        }
//    }

    public  int showTransaction(){
        return this.value;
    }

}

