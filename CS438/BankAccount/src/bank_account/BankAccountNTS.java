package bank_account;

public class BankAccountNTS extends BankAccount {

    public BankAccountNTS(int balance) {
        super(balance);
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

}
