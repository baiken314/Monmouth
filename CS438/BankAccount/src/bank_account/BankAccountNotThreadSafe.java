package bank_account;

public class BankAccountNotThreadSafe extends BankAccount {

    public BankAccountNotThreadSafe(int balance) {
        super(balance);
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

}
