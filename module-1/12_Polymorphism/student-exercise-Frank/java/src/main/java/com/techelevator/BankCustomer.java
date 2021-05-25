package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer {

    private String name;

    private String address;

    private String phoneNumber;

    private List<Accountable> accounts = new ArrayList<>();   // List of Accountable objects

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[accounts.size()]);
    }

    public void addAccount(Accountable newAccount) {
                accounts.add(newAccount);
    }

    public boolean isVip () {

       // need to figure out how to call the balances of CheckingAccount, SavingsAccount, and CreditCardAccount
       // need to figure out why transfer to SavingsAccount isn't working

        return false;
    }


}