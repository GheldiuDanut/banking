
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Withdraw implements  Transaction{

    int value;


    public Withdraw( int value) {
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
        List<Transaction> transactionList = new ArrayList<>();
        Withdraw withdraw = new Withdraw(value);
        if (depositAmount > 0  && depositAmount <= withdraw.getValue()){
            int newValue = withdraw.getValue()- value;
            withdraw.setValue(newValue);
            transactionList.add(withdraw);
            System.out.println("Successful withdrawal");
        }
        else {
            System.out.println("The amount is less than amount  in the account");
        }
        for (Transaction transaction : transactionList){
            System.out.println(withdraw.showTransaction());
        }
    }

    public static void withdrawMoney(){
//        List<Transaction> transactionList = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a value to withdraw: ");
//        int value = scanner.nextInt();
//        Withdraw withdraw = new Withdraw(value);
//        if (value > 0  && value <= withdraw.getValue()){
//            int newValue = withdraw.getValue()- value;
//            withdraw.setValue(newValue);
//            transactionList.add(withdraw);
//            System.out.println("Successful withdrawal");
//        }
//        else {
//            System.out.println("The amount is less than amount  in the account");
//        }
//        for (Transaction transaction : transactionList){
//            System.out.println(withdraw.showTransaction());
//        }
    }

    public double showTransaction(){
        return getValue();
    }
}
