package main.entity;

import main.manager.ShowContent;
import main.manager.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account implements ShowContent {

    private String firstName;
    private String lastName;

    private double value;

    private String currency;

    List<Transaction> transactionList = new ArrayList<>();

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


    public String getLastName() {
        return lastName;
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


    public String showContent() {
        return "First name is: " + firstName + ", " +
                "Last name is: " + lastName + ", " +
                "the new value is: " + value + ", " +
                "the currency is: " + currency;

    }

}


