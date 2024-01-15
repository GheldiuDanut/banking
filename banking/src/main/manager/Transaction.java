package main.manager;


import main.entity.Account;

public interface Transaction {

    void makeTransaction(Account targetAccount);
}
