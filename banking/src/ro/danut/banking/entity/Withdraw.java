package ro.danut.banking.entity;

import ro.danut.banking.manager.Transaction;

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
            System.out.println("Successful withdrawal");

        } else {
            System.out.println("The amount is less than amount  in the account");
        }
        for (Transaction transaction : targetAccount.transactionList) {
            System.out.println(transaction);

        }
    }
    public String showWithdrawalTransaction() {
        return "Withdraw of " + value;
    }

}
