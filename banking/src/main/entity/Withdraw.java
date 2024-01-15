package main.entity;

import main.manager.Transaction;

public class Withdraw implements Transaction {

    int value;

    public Withdraw(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    @Override
    public void makeTransaction(Account targetAccount) {

        if (targetAccount.getValue() > 0 && targetAccount.getValue() >= value) {
            targetAccount.setValue(targetAccount.getValue() - value);
            targetAccount.getTransactionList().add(this);
            System.out.println("Successful withdrawal" + value);
        } else {
            System.out.println("The amount is less than amount  in the account");
        }
        System.out.println("The current account value is: " +"\n" + targetAccount.showContent());
    }
}
