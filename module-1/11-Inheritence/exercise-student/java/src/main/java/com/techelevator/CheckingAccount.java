package com.techelevator;

public class CheckingAccount extends BankAccount {

    private static final int OVERDRAFT_FEE = 10;

    public CheckingAccount (String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount (String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {

        if (super.getBalance() < 0 && super.getBalance() > -100) {
            amountToWithdraw = amountToWithdraw + OVERDRAFT_FEE;
            return super.withdraw(amountToWithdraw);
        }
        else if (super.getBalance() - amountToWithdraw <= -100) {
            return super.getBalance();
        }
        return super.withdraw(amountToWithdraw);
    }
}
