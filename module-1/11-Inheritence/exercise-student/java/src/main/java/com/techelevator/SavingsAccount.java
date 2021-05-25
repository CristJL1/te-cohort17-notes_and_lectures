package com.techelevator;

public class SavingsAccount extends BankAccount {

    private static final int SERVICE_CHARGE = 2;


    public SavingsAccount (String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }



    public SavingsAccount (String accountHolderName, String accountNumber, int balance) {
         super(accountHolderName, accountNumber, balance);
    }


    @Override
    public int withdraw(int amountToWithdraw) {

        if (super.getBalance() >= amountToWithdraw && super.getBalance()- amountToWithdraw >=150) {
            return super.withdraw(amountToWithdraw);
        }

        else if (super.getBalance() >= amountToWithdraw && super.getBalance() - amountToWithdraw < 150) {
            amountToWithdraw = amountToWithdraw + SERVICE_CHARGE;
            return super.withdraw(amountToWithdraw);
        }
        else {
            return super.getBalance();
        }
    }
}
