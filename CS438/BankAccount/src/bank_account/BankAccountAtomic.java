package bank_account;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic extends BankAccount {

    protected AtomicInteger balance;

    public BankAccountAtomic(int balance) {
        super(balance);
        this.balance = new AtomicInteger(balance);
    }

    public void deposit(int amount) {
        balance.addAndGet(amount);
    };

    public void withdraw(int amount) {
        balance.addAndGet(-amount);
    };

    public int getBalance() {
        return balance.get();
    }

}
