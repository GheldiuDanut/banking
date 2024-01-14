package ro.danut.banking.entity;

import ro.danut.banking.manager.Transaction;

public class Deposit implements Transaction {
    private final int value;

    public Deposit(int value) {
        this.value = value;
    }


    @Override
    public void makeTransaction(Account targetAccount) {
        if (value > 0) {
            targetAccount.setValue(targetAccount.getValue() + value);
            targetAccount.getTransactionList().add(this);
            System.out.println("Successful deposit " + value);
        } else {
            System.out.println("You can't deposit money in this account. Enter a value greater than 0");
        }
        System.out.println("Current account value is: " +"\n" + targetAccount.showContent());
        for (Transaction transaction : targetAccount.getTransactionList()) {
            System.out.println(transaction);
        }
    }
}
