package bank_account;

public abstract class BankAccount {

    protected int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);

    public int getBalance() {
        return balance;
    }

}
