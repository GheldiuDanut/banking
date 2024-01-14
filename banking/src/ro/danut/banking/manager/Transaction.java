package ro.danut.banking.manager;

import ro.danut.banking.entity.Account;

public interface Transaction {

    void makeTransaction(Account targetAccount);
}
