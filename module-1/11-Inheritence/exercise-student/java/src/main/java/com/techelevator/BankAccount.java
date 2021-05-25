package com.techelevator;

public class BankAccount {

    private String accountHolderName;

    private String accountNumber;

    private int balance;

    public BankAccount () { // 0 argument constructor
        accountHolderName = null;
        accountNumber = null;
        balance = 0;
}

    public BankAccount (String accountHolderName, String accountNumber) { // 2 argument constructor
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public BankAccount (String accountHolderName, String accountNumber, int balance) { // 3 argument constructor
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) { // deposit method
        balance = balance + amountToDeposit;

        return getBalance();
    }

    public int withdraw(int amountToWithdraw) { // withdraw method
        balance = balance - amountToWithdraw;

        return getBalance();
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
